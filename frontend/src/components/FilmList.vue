<template>
    <div>
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
    </div>
</template>

<script>
import FilmService from '../services/FilmService'

export default {
  name: 'films',
  data () {
    return {
      films: []
    }
  },
  methods: {
    retrieveFilms () {
      FilmService.getAll()
        .then(response => {
          this.films = response.data.data
        })
        .catch(e => {
          alert(e)
        })
    },
    deleteFilm (id) {
      FilmService.delete(id)
      this.films = this.films.filter(film => film.id !== id)
    }
  },
  mounted () {
    this.retrieveFilms()
  }
}
</script>
