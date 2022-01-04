package com.example.toWatchList.mapper;

import com.example.toWatchList.dto.FilmGetDto;
import com.example.toWatchList.dto.FilmPostDto;
import com.example.toWatchList.entity.Film;

import java.util.List;


public interface MapStructMapper {
    FilmPostDto filmToFilmPostDto(Film film);

    FilmGetDto filmToFilmGetDto(Film film);

    Film filmPostDtoToFilm(FilmPostDto filmPostDto);

    List<FilmGetDto> map(List<Film> films);
}
