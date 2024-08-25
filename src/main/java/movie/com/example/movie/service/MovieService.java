package movie.com.example.movie.service;

import movie.com.example.movie.dto.MovieListReq;
import movie.com.example.movie.dto.MovieListRes;

import java.util.List;

public interface MovieService {
    public void saveMoviesList(List<MovieListReq> movieListReq);
    public List<MovieListRes> getAllMovie();
}
