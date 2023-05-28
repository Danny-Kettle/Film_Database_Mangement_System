import React, { useState, useEffect } from "react";
import Search from "../components/Search";
import { useNavigate } from "react-router-dom";
import FilmTableRows from "../components/FilmTableRows";
import SelectDataFormat from "../components/SelectDataFormat";
import "../sass/main.css";
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import { BarLoader } from "react-spinners";

import { Film } from "../models/film";

function SearchFilm() {
  const navigate = useNavigate();
  const [open, setOpen] = React.useState(false);
  const [dataFormat, setDataFormat] = React.useState([]);
  const [search, setSearch] = React.useState("*"); // Fix set search to go all even after delete
  const [filmList, setFilmList] = useState([]);
  const convert = require("xml-js");
  const baseURL = "http://localhost:8080/FilmRestful/filmapi";
  const [isLoading, setIsLoading] = useState(false);

  const navigateNew = () => {
    navigate("/new");
  };

  const getJson = () => {
    let config = {
      headers: {
        "data-type": "json",
        "Content-type": "application/json",
      },
      params: {
        search: search,
      },
    };
    setIsLoading(true);
    axios
      .get(baseURL, config)
      .then((res) => {
        const resData = res.data;
        const firstLetter = search.includes("#", 0);
        let newList = [];
        if (firstLetter) {
          const f = resData;
          console.log(resData.id);
          const film = new Film(f.title, f.year, f.director, f.stars, f.review);
          film.setId(f.id);

          newList.push(film);
          setFilmList(newList);
        } else {
          setFilmList(resData);
        }
        console.log(filmList);
      })
      .catch((err) => {});
    setIsLoading(false);
  };

  const getXML = () => {
    let config = {
      headers: {
        "data-type": "xml",
        "Content-type": "application/xml",
      },
      params: {
        search: search,
      },
    };

    axios
      .get(baseURL, config)
      .then((res) => {
        let newList = [];

        const resData = convert.xml2js(res.data, { compact: true });
        const firstLetter = search.includes("#", 0);
        console.log(firstLetter);
        if (firstLetter) {
          const f = resData.film;
          const film = new Film(
            f.title._text,
            f.year._text,
            f.director._text,
            f.stars._text,
            f.review._text
          );
          film.setId(f.id._text);

          newList.push(film);
        } else {
          resData.films.film.forEach((f) => {
            const film = new Film(
              f.title._text,
              f.year._text,
              f.director._text,
              f.stars._text,
              f.review._text
            );
            film.setId(f.id._text);
            newList.push(film);
          });
        }

        console.log(newList);
        setFilmList(newList);
      })
      .catch((err) => {});
  };

  const getString = () => {
    let config = {
      headers: {
        "data-type": "string",
        "Content-type": "text/html",
      },
      params: {
        search: search,
      },
    };
    axios
      .get(baseURL, config)
      .then((res) => {
        let str = res.data;
        let newList = [];
        let splitStr = str.split("}");

        const firstLetter = search.includes("#", 0);

        if (firstLetter) {
          const f = splitStr[0];
          let splitFilm = f.split("#");
          const id = splitFilm[0];
          const title = splitFilm[1];
          const year = splitFilm[2];
          const director = splitFilm[3];
          const stars = splitFilm[4];
          const review = splitFilm[5];
          const newFilm = new Film(title, year, director, stars, review);
          newFilm.setId(id);
          newList.push(newFilm);
        } else {
          splitStr.forEach((film) => {
            let splitFilm = film.split("#");
            const id = splitFilm[0];
            const title = splitFilm[1];
            const year = splitFilm[2];
            const director = splitFilm[3];
            const stars = splitFilm[4];
            const review = splitFilm[5];
            const newFilm = new Film(title, year, director, stars, review);
            newFilm.setId(id);
            newList.push(newFilm);
          });
        }

        console.log(newList);
        setFilmList(newList);
      })
      .catch((err) => {});
  };

  const openData = () => {
    switch (dataFormat.value) {
      case "json":
        getJson();
        break;
      case "xml":
        getXML();
        break;
      default:
        getString();
    }
    setOpen(true);
  };

  const updateSearchState = (e) => {
    setSearch(e.target.value);
  };

  const changeDataFormat = (selectedOption) => {
    console.log(selectedOption);
    setDataFormat(selectedOption);
  };

  return (
    <main className="rounded d-flex shadow flex-column align-items-center pt-5 w-75 mx-auto mb-5">
      <fieldset className="w-75 d-flex flex-column">
        <div className="d-flex flex-row">
          <h1 className="pb-1">Film Management</h1>
          <span
            role="img"
            className="mx-3"
            style={{ fontSize: "2em" }}
            aria-label="film"
          >
            🎞️
          </span>
        </div>
        <div className="fs-6 mt-2">
          <h5>Instructions </h5>
          <ul id="instructionList">
            <li>Click on row to expand film entry</li>
            <li>Data format is defaulted to string</li>
            <li>To search by film id use #ID. For example, #10274</li>
          </ul>
        </div>
        <div className="d-flex flex-row justify-content-between align-items-center py-4">
          <Search updateSearchState={updateSearchState} />
          <SelectDataFormat changeDataFormat={changeDataFormat} />
          <button
            type="button"
            className="rounded btn btn-outline-primary"
            onClick={openData}
          >
            Show Films
          </button>
          <button
            type="button"
            className="px-3 rounded btn btn-outline-primary"
            onClick={navigateNew}
          >
            Create New Entry
          </button>
        </div>
      </fieldset>
      <div className="w-100 bg-white">
        <table className="table mb-0 table-striped table-bordered table-hover">
          <thead>
            <tr>
              <th scope="col">Title</th>
              <th scope="col">Year</th>
              <th scope="col">Director</th>
              <th scope="col">Stars</th>
              <th scope="col">Review</th>
            </tr>
          </thead>
          <tbody>
            {isLoading ? (
              <tr>
                <BarLoader color={"#2BC1F7"} size={30} />
              </tr>
            ) : (
              open && (
                <FilmTableRows isLoading={isLoading} filmList={filmList} />
              )
            )}
          </tbody>
        </table>
      </div>
    </main>
  );
}

export default SearchFilm;
