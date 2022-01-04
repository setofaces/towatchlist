package com.example.toWatchList.controller;


import com.example.toWatchList.dto.FilmPostDto;
import com.example.toWatchList.dto.SearchDto;
import com.example.toWatchList.response.Response;
import com.example.toWatchList.service.FilmServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class FilmController {
    private final FilmServiceImpl filmService;

    public FilmController(FilmServiceImpl filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/all")
    public Object getAllFilms() {
        return filmService.getAllFilms();
    }

    @PostMapping("/add")
    public Response addFilm(@RequestBody @Valid FilmPostDto filmPostDto) {

        return filmService.saveFilm(filmPostDto);
    }

    @PostMapping("/find")
    public Response findFilm(@RequestBody @Valid SearchDto searchDto) {
        return filmService.getFilmsByParams(searchDto);
    }

    @GetMapping("/{id}")
    public Response getFilm(@PathVariable int id) {
        return filmService.getFilmById(id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable int id) {
        filmService.deleteFilm(id);
    }

}
