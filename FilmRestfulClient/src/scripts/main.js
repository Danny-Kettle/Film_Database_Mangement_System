//Parses string into JS Object to be sent to the API
export function stringifyFilm(film, crudOp) {
  console.log(film);
  if (crudOp === "edit" || crudOp === "delete") {
    film = JSON.stringify(film, [
      "id",
      "title",
      "year",
      "director",
      "stars",
      "review",
    ]);
  } else {
    film = JSON.stringify(film, [
      "title",
      "year",
      "director",
      "stars",
      "review",
    ]);
  }
  return film;
}

//Parses JS Object into string
export function jsToString(film, crudOp) {
  var string;
  const id = crudOp === "edit" || crudOp === "delete" ? film.id + "#" : "";
  string =
    id +
    film.title +
    "#" +
    film.year +
    "#" +
    film.director +
    "#" +
    film.stars +
    "#" +
    film.review;
  console.log(string);
  return string;
}

//Parses JS into
export function jsToXML(film, crudOp) {
  //Creating Document and elements
  var xmlDoc = document.implementation.createDocument(null, "film");

  //Edit & Delete CRUD Operations need ID
  if (crudOp === "edit" || crudOp === "delete") {
    var id = xmlDoc.createElement("id");
    id.append(film.id);
    xmlDoc.documentElement.appendChild(id);
  }

  var title = xmlDoc.createElement("title");
  var year = xmlDoc.createElement("year");
  var director = xmlDoc.createElement("director");
  var stars = xmlDoc.createElement("stars");
  var review = xmlDoc.createElement("review");

  //Assign form data to elements
  title.append(film.title);
  year.append(film.year);
  director.append(film.director);
  stars.append(film.stars);
  review.append(film.review);

  //Append the elements to the xml doc
  xmlDoc.documentElement.appendChild(title);
  xmlDoc.documentElement.appendChild(year);
  xmlDoc.documentElement.appendChild(director);
  xmlDoc.documentElement.appendChild(stars);
  xmlDoc.documentElement.appendChild(review);

  //Serialize xml dom
  var serializer = new XMLSerializer();
  console.log(xmlString);
  var xmlString = serializer.serializeToString(xmlDoc);

  return xmlString;
}
