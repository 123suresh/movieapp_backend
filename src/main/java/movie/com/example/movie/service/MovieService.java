package movie.com.example.movie.service;

import movie.com.example.movie.dto.MovieListReq;
import movie.com.example.movie.dto.MovieListRes;
import org.bson.types.ObjectId;

import java.util.List;

public interface MovieService {
    public void saveMoviesList(List<MovieListReq> movieListReq);
    public List<MovieListRes> getAllMovie();
    public List<MovieListRes> getMovieById(ObjectId movieId);
    public String updateMovieById (ObjectId movieId, MovieListReq MovieListReq);
    public String delMovieById(ObjectId movieId);
}
