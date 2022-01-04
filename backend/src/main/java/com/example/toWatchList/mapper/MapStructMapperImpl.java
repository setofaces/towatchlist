package com.example.toWatchList.mapper;

import com.example.toWatchList.dto.FilmGetDto;
import com.example.toWatchList.dto.FilmPostDto;
import com.example.toWatchList.entity.Film;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public class MapStructMapperImpl implements MapStructMapper {
    @Override
    public FilmPostDto filmToFilmPostDto(Film film) {
        return new FilmPostDto(film);
    }

    @Override
    public FilmGetDto filmToFilmGetDto(Film film) {
        return new FilmGetDto(film);
    }

    @Override
    public Film filmPostDtoToFilm(FilmPostDto filmPostDto) {
        return new Film(filmPostDto.getName(), filmPostDto.getYear(), filmPostDto.getRating(), filmPostDto.getGenre());
    }

    @Override
    public List<FilmGetDto> map(List<Film> films) {
        return films.stream()
                .map(film -> new FilmGetDto(film))
                .collect(Collectors.toList());
    }
}
