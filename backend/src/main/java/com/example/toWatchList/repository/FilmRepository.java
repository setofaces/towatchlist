package com.example.toWatchList.repository;

import com.example.toWatchList.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film,Integer> {
    List<Film> findByYearBetweenAndRatingBetweenAndGenre(int year1, int year2, float rating1, float rating2, String genre);
    List<Film> findByYearBetweenAndRatingBetween(int year1, int year2, float rating1, float rating2);
}
