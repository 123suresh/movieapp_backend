package movie.com.example.movie.service;

import lombok.extern.slf4j.Slf4j;
import movie.com.example.movie.dto.MovieListRes;
import movie.com.example.movie.repository.MovieRepository;
import movie.com.example.movie.dto.MovieListReq;
import movie.com.example.movie.entity.MovieList;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository movieRepository;
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

    public List<MovieListRes> getMovieById(ObjectId movieId){
        List<MovieListRes> movieById=movieRepository.findById(movieId).stream().map(movie->MovieListRes.builder()
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
        return movieById;
    }

    public String updateMovieById (ObjectId movieId, MovieListReq updateReq){
          Optional<MovieList> movie = movieRepository.findById(movieId);
          if(movie.isEmpty()){
              log.error("Movie not found with Id ", movieId);
              return "Movie not found with given Id";
          }
          MovieList updateMovie = movie.get();
          updateMovie.setTitle(updateReq.getTitle()!=null?updateReq.getTitle():updateMovie.getTitle());
          updateMovie.setDisc(updateReq.getDisc()!=null?updateReq.getDisc():updateMovie.getDisc());
          updateMovie.setSrc(updateReq.getSrc()!=null?updateReq.getSrc():updateMovie.getSrc());
          updateMovie.setCast1(updateReq.getCast1()!=null?updateReq.getCast1():updateMovie.getCast1());
          updateMovie.setCast1Name(updateReq.getCast1Name()!=null?updateReq.getCast1Name():updateMovie.getCast1Name());
          updateMovie.setCast2(updateReq.getCast2()!=null?updateReq.getCast2():updateMovie.getCast2());
          updateMovie.setCast2Name(updateReq.getCast2Name()!=null?updateReq.getCast2Name():updateMovie.getCast2Name());
          updateMovie.setVideourl(updateReq.getVideourl()!=null?updateReq.getVideourl():updateMovie.getVideourl());
          movieRepository.save(updateMovie);
          return "Movie "+updateMovie.getTitle()+" updated successfully";
    }

    public String delMovieById(ObjectId movieId){
          boolean exist = movieRepository.existsById(movieId);
          if(!exist){
              return "Movie does not exist with given id";
          }
          movieRepository.deleteById(movieId);
          return "Movie deleted successfully";
    }

}


