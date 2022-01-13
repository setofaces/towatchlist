import http from '../http-common'

class FilmService {
  getAll () {
    return http.get('/all')
  }

  get (id) {
    return http.get(`films/${id}`)
  }

  create (data) {
    return http.post('/add', data)
  }

  delete (id) {
    return http.delete(`films/${id}`)
  }

  find (data) {
    return http.post('/find', data)
  }
}

export default new FilmService()
