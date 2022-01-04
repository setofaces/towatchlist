package com.example.toWatchList.service;

import com.example.toWatchList.dto.FilmPostDto;
import com.example.toWatchList.dto.SearchDto;
import com.example.toWatchList.mapper.MapStructMapper;
import com.example.toWatchList.repository.FilmRepository;
import com.example.toWatchList.response.Response;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    private final MapStructMapper mapper;

    public FilmServiceImpl(FilmRepository filmRepository, MapStructMapper mapper) {
        this.filmRepository = filmRepository;
        this.mapper = mapper;
    }

    @Override
    public Response getAllFilms() {
        return new Response(200, mapper.map(filmRepository.findAll()));
    }

    @Override
    public Response getFilmById(int id) {

        return Optional.ofNullable(filmRepository.getById(id)).map(
                        (film) -> new Response(200, mapper.filmToFilmGetDto(film)))
                .orElseGet(() -> new Response(404, "No film with such id"));
    }


    @Override
    public Response getFilmsByParams(SearchDto sDto) {
        if (sDto.getGenre().isEmpty()) {
            return new Response(mapper.map(filmRepository.findByYearBetweenAndRatingBetween(sDto.getYear1(), sDto.getYear2(),
                    sDto.getRating1(), sDto.getRating2())));

        }
        return new Response(mapper.map(filmRepository.findByYearBetweenAndRatingBetweenAndGenre(sDto.getYear1(), sDto.getYear2(),
                sDto.getRating1(), sDto.getRating2(), sDto.getGenre())));
    }

    @Override
    public Response saveFilm(FilmPostDto filmPostDto) {

        try {
            filmRepository.save(mapper.filmPostDtoToFilm(filmPostDto));
            return new Response(200, "Film was saved successfully");
        } catch (Exception e) {
            return new Response(500, "Internal error");
        }
    }

    @Override
    public void deleteFilm(int id) {
        filmRepository.deleteById(id);
    }

}
