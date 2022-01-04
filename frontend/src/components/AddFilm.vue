<template>
    <div>
        <div v-if="!submitted">
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" class="form-control" id="name" required name="name" v-model="film.name">
            </div>
            <div class="mb-3">
                <label for="year" class="form-label">Year</label>
                <input type="text" class="form-control" id="year" required name="year" v-model="film.year">
            </div>
            <div class="mb-3">
                <label for="rating" class="form-label">Rating</label>
                <input type="rating" class="form-control" id="rating" required name="rating" v-model="film.rating">
            </div>
            <div class="mb-3">
                <label for="genre" class="form-label">Genre</label>
                <input type="text" class="form-control" id="genre" required name="genre" v-model="film.genre">
            </div>
            <div class="mb-3">
                <button @click="saveFilm" class="btn btn-primary">Submit</button>
            </div>
        </div>
        <div v-else>
            <div class="alert alert-success" role="alert">
                {{this.message}}
            </div>
            <button @click="newFilm" class="btn btn-primary">Add new film</button>
        </div>
    </div>
</template>

<script>
import FilmService from '../services/FilmService'

export default {
  name: 'add-film',
  data () {
    return {
      film: {
        id: null,
        name: '',
        year: '',
        rating: '',
        genre: ''
      },
      message: '',
      submitted: false,
      exception: ''
    }
  },
  methods: {
    saveFilm () {
      var data = {
        name: this.film.name,
        year: this.film.year,
        rating: this.film.rating,
        genre: this.film.genre
      }
      FilmService.create(data)
        .then(response => {
          this.film.id = response.data.id
          this.submitted = true
          this.message = response.data.message
        })
        .catch(e => {
          alert(e)
        })
    },
    newFilm () {
      this.submitted = false
      this.film = {}
    }
  }
}
</script>
