<template>
    <div>
      <div v-if="!submitted">
          <div class="mb-3 row">
              <label for="year" class="form-label">Year</label>
              <label for="year1" class="col-sm-2 col-form-label">From</label>
              <div class="col-sm-10">
                <input type="year1" class="form-control" id="year1" v-model="film.year1">
              </div>
              <label for="year2" class="col-sm-2 col-form-label">To</label>
              <div class="col-sm-10">
                <input type="year2" class="form-control" id="year2" v-model="film.year2">
              </div>
          </div>
          <div class="mb-3 row">
              <label for="rating" class="form-label">Rating</label>
              <label for="rating1" class="col-sm-2 col-form-label">From</label>
              <div class="col-sm-10">
                <input type="rating1" class="form-control" id="rating1" v-model="film.rating1">
              </div>
              <label for="rating2" class="col-sm-2 col-form-label">To</label>
              <div class="col-sm-10">
                <input type="rating2" class="form-control" id="rating2" v-model="film.rating2">
              </div>
          </div>
          <div class="mb-3">
              <label for="genre" class="form-label">Genre</label>
              <input type="text" class="form-control" id="genre" required name="genre" v-model="film.genre">
          </div>
          <div class="mb-3">
              <button @click="findFilm" class="btn btn-primary">Find</button>
          </div>
      </div>
      <div v-if="submitted">
      <table class="table">
          <thead>
              <tr>
              <th scope="col">Name</th>
              <th scope="col">Year</th>
              <th scope="col">Rating</th>
              <th scope="col">Genre</th>
              <th scope="col">Actions</th>
              </tr>
          </thead>
          <tbody v-for="(film, index) in films" :key="index">
              <tr>
                  <td>{{film.name}}</td>
                  <td>{{film.year}}</td>
                  <td>{{film.rating}}</td>
                  <td>{{film.genre}}</td>
                  <td><button @click="deleteFilm(film.id)" class="btn btn-primary">Delete</button></td>
              </tr>
          </tbody>
      </table>
      <button @click="newSearch" class="btn btn-primary">Make another search</button>
    </div>

    </div>
</template>

<script>
import FilmService from '../services/FilmService'

export default {
  name: 'find-film',
  data () {
    return {
      film: {
        year1: 1900,
        year2: 2023,
        rating1: 0,
        rating2: 10,
        genre: ''
      },
      message: '',
      submitted: false,
      exception: ''
    }
  },
  data2 () {
    return {
      films: []
    }
  },
  methods: {
    findFilm () {
      var data = {
        year1: this.film.year1,
        year2: this.film.year2,
        rating1: this.film.rating1,
        rating2: this.film.rating2,
        genre: this.film.genre
      }
      FilmService.find(data)
        .then(response => {
          this.films = response.data.data
          this.submitted = true
          this.message = response.data.message
        })
        .catch(e => {
          alert(e)
        })
    },
    deleteFilm (id) {
      FilmService.delete(id)
      this.films = this.films.filter(film => film.id !== id)
    },
    newSearch () {
      this.submitted = false
      this.films = {}
    }
  }
}
</script>
