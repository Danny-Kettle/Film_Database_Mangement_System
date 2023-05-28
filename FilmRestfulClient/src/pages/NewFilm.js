import React from "react";
import SelectDataFormat from "../components/SelectDataFormat";
import { Film } from "../models/film";
import { jsToXML, stringifyFilm, jsToString } from "../scripts/main";

export default function NewFilm() {
  const postTitle = React.useRef(null);
  const postYear = React.useRef(null);
  const postDirector = React.useRef(null);
  const postStars = React.useRef(null);
  const postReview = React.useRef(null);
  const [dataFormat, setDataFormat] = React.useState([]);

  const changeDataFormat = (selectedOption) => {
    console.log(selectedOption);
    setDataFormat(selectedOption);
  };

  const submitFilm = () => {
    const baseURL = "http://localhost:8080/FilmRestful/filmapi";
    let contentType;
    let film = new Film(
      postTitle.current.value,
      postYear.current.value,
      postDirector.current.value,
      postStars.current.value,
      postReview.current.value
    );

    let filmParse;

    if (dataFormat.value === "json") {
      filmParse = stringifyFilm(film);
      contentType = "application/json";
    } else if (dataFormat.value === "xml") {
      filmParse = jsToXML(film, "create");
      contentType = "application/xml";
    } else {
      filmParse = jsToString(film, "create");
      contentType = "text/html";
    }
    console.log(filmParse);

    try {
      fetch(baseURL, {
        method: "post",
        headers: {
          "data-type": dataFormat.value,
          "Content-type": contentType,
        },
        body: filmParse,
      }).then(function (response) {
        if (response.status === 200) {
          window.location = "/";
          window.alert("Film Created");
        }
      });
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <main className="rounded d-flex flex-column align-items-center pt-5 pb-4 w-75 mx-auto mt-5 mb-5 shadow">
      <fieldset className="w-100 d-flex mb-3 flex-column align-items-center">
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
      </fieldset>
      <form action="#" className="d-flex w-75 flex-column">
        <div className="d-flex w-100 flex-row">
          <div className="d-flex w-25 flex-column px-2">
            <div className="mb-4">
              <SelectDataFormat changeDataFormat={changeDataFormat} />
            </div>

            <input ref={postTitle} className="mb-4 py-1 px-2" type="text" placeholder="Title"/>
            <input
              ref={postYear}
              className="mb-4 py-1 px-2"
              type="number"
              placeholder="Year"
            />
            <input
              ref={postDirector}
              className="mb-4 py-1 px-2"
              type="text"
              placeholder="Director"
            />
            <input
              ref={postStars}
              className="mb-4 py-1 px-2"
              type="text"
              placeholder="Stars"
            />
          </div>
          <div className="w-75 mb-4">
            <textarea
              ref={postReview}
              className="h-100 w-100 p-3"
              rows="4"
              placeholder="Review..."
            ></textarea>
          </div>
        </div>
        <div className="d-flex">
          <input
            type="button"
            className="mb-4 mx-2 py-2 px-4 btn btn-outline-primary"
            onClick={submitFilm}
            value="Submit"
          />
        </div>
      </form>
    </main>
  );
}
