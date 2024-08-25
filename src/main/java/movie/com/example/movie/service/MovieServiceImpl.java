package movie.com.example.movie.service;

import movie.com.example.movie.dto.MovieListRes;
import movie.com.example.movie.repository.MovieRepository;
import movie.com.example.movie.dto.MovieListReq;
import movie.com.example.movie.entity.MovieList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository movieRepository;
//    public List<MovieListRes> saveMoviesList(List<MovieListReq> movieListReq) {
      public void saveMoviesList(List<MovieListReq> movieListReq) {
          List<MovieList> savedMovieList= movieRepository.saveAll(movieListReq.stream().map(movie->MovieList.builder()
                          .title(movie.getTitle())
                          .disc(movie.getDisc())
                          .src(movie.getSrc())
                          .cast1(movie.getCast1())
                          .cast1Name(movie.getCast1Name())
                          .cast2(movie.getCast2())
                          .cast2Name(movie.getCast2Name())
                          .videourl(movie.getVideourl())
                          .build()
                          ).toList()
          );
    }

    public List<MovieListRes> getAllMovie() {
//          List<MovieList> movieList = movieRepository.findAll();
          List<MovieListRes> finalMovieListRes=movieRepository.findAll().stream().map(movie->MovieListRes.builder()
                        .id(movie.getId())
                        .title(movie.getTitle())
                        .disc(movie.getDisc())
                        .src(movie.getSrc())
                        .cast1(movie.getCast1())
                        .cast1Name(movie.getCast1Name())
                        .cast2(movie.getCast2())
                        .cast2Name(movie.getCast2Name())
                        .videourl(movie.getVideourl())
                        .build()
                ).toList();
        return finalMovieListRes;
    }
}

