export class Film {
  constructor(title, year, director, stars, review) {
    this.title = title;
    this.year = year;
    this.director = director;
    this.stars = stars;
    this.review = review;
  }

  setId(params) {
    this.id = params;
  }
}
