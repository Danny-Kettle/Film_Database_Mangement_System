import React from "react";
import { useNavigate } from "react-router-dom";

function FilmTableRows(props) {
  // const [openEdit, setOpenEdit] = React.useState(null);
  const filmList = props.filmList;
  const loading = props.isLoading;
  const navigate = useNavigate();

  const handleClick = (el) => {
    navigate("/edit", {
      state: {
        id: el.id,
        title: el.title,
        year: el.year,
        director: el.director,
        stars: el.stars,
        review: el.review,
      },
    });
  };

  const child = filmList.map((el, index) => {
    return (
      <tr onClick={() => handleClick(el)} key={index}>
        <td>{el.title}</td>
        <td>{el.year}</td>
        <td>{el.director}</td>
        <td>{el.stars}</td>
        <td>{el.review}</td>
      </tr>
    );
  });

  return <>{filmList && child}</>;
}

export default FilmTableRows;
