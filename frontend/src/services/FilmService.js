import http from '../http-common'

class FilmService {
  getAll () {
    return http.get('/all')
  }

  get (id) {
    return http.get(`/${id}`)
  }

  create (data) {
    return http.post('/add', data)
  }

  delete (id) {
    return http.delete(`/${id}`)
  }

  find (data) {
    return http.post('/find', data)
  }
}

export default new FilmService()
