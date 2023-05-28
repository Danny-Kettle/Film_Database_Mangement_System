import React from "react";
import SelectDataFormat from "../components/SelectDataFormat";
import { Film } from "../models/film";
import { useLocation } from "react-router-dom";
import { jsToXML, stringifyFilm, jsToString } from "../scripts/main";

function EditFilm(props) {
  const location = useLocation();
  const filmId = location.state.id;
  const filmTitle = location.state.title;
  const filmYear = location.state.year;
  const filmDirector = location.state.director;
  const filmStars = location.state.stars;
  const filmReview = location.state.review;
  const [dataFormat, setDataFormat] = React.useState([]);
  const postTitle = React.useRef(null);
  const postYear = React.useRef(null);
  const postDirector = React.useRef(null);
  const postStars = React.useRef(null);
  const postReview = React.useRef(null);
  const [data, setData] = React.useState([]);

  const changeDataFormat = (selectedOption) => {
    console.log(selectedOption);
    setDataFormat(selectedOption);
  };

  const deleteFilm = () => {
    const baseURL = "http://localhost:8080/FilmRestful/filmapi";
    let contentType;
    let filmParse;

    let film = new Film(
      postTitle.current.value,
      postYear.current.value,
      postDirector.current.value,
      postStars.current.value,
      postReview.current.value
    );
    film.setId(filmId);

    if (dataFormat.value === "json") {
      filmParse = stringifyFilm(film, "delete");
      contentType = "application/json";
    } else if (dataFormat.value === "xml") {
      filmParse = jsToXML(film, "delete");
      contentType = "application/xml";
    } else {
      filmParse = jsToString(film, "delete");
      contentType = "text/html";
    }

    fetch(baseURL, {
      method: "delete",
      headers: {
        "data-type": dataFormat.value,
        "Content-type": contentType,
      },
      body: filmParse,
    }).then(() => {
      window.location = "/";
      window.alert("Film Deleted");
    });
  };

  const submitFilm = () => {
    const baseURL = "http://localhost:8080/FilmRestful/filmapi";
    let contentType;
    let filmParse;

    let film = new Film(
      postTitle.current.value,
      postYear.current.value,
      postDirector.current.value,
      postStars.current.value,
      postReview.current.value
    );
    film.setId(filmId);

    if (dataFormat.value === "json") {
      filmParse = stringifyFilm(film, "edit");
      contentType = "application/json";
    } else if (dataFormat.value === "xml") {
      filmParse = jsToXML(film, "edit");
      contentType = "application/xml";
    } else {
      filmParse = jsToString(film, "edit");
      contentType = "text/html";
    }

    console.log(filmParse);

    try {
      fetch(baseURL, {
        method: "put",
        headers: {
          "data-type": dataFormat.value,
          "Content-type": contentType,
        },
        body: filmParse,
      }).then(function (response) {
        if (response.status === 200) {
          window.location = "/";
          window.alert("Film Updated");
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

      {data > 0 ? (
        data
      ) : (
        <form action="#" className="d-flex w-75 flex-column">
          <div className="d-flex w-100 flex-row">
            <div className="d-flex w-25 flex-column px-2">
              <div className="mb-4">
                <SelectDataFormat changeDataFormat={changeDataFormat} />
              </div>

              <input
                ref={postTitle}
                className="mb-4 py-1 px-2"
                type="text"
                defaultValue={filmTitle}
              />
              <input
                ref={postYear}
                className="mb-4 py-1 px-2"
                type="number"
                placeholder="Year"
                defaultValue={filmYear}
              />
              <input
                ref={postDirector}
                className="mb-4 py-1 px-2"
                type="text"
                placeholder="Director"
                defaultValue={filmDirector}
              />
              <input
                ref={postStars}
                className="mb-4 py-1 px-2"
                type="text"
                placeholder="Stars"
                defaultValue={filmStars}
              />
            </div>
            <div className="w-75 mb-4">
              <textarea
                ref={postReview}
                className="h-100 w-100 p-3"
                rows="4"
                placeholder="Review..."
                defaultValue={filmReview}
              ></textarea>
            </div>
          </div>

          <div className="d-flex flex-row">
            <input
              className="mb-4 mx-2 py-1 px-2 btn btn-outline-primary"
              type="button"
              onClick={submitFilm}
              value="Update"
            />
            <input
              className="mb-4 py-1 px-2 btn btn-outline-danger"
              type="button"
              onClick={deleteFilm}
              value="Delete"
            />
          </div>
        </form>
      )}
    </main>
  );
}

export default EditFilm;
