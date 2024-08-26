package movie.com.example.movie.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import movie.com.example.movie.dto.MovieListReq;
import movie.com.example.movie.dto.MovieListRes;
import movie.com.example.movie.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movielist")
@RequiredArgsConstructor
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<?> saveMovie(@Valid @RequestBody List<MovieListReq> movieRequest){
            movieService.saveMoviesList(movieRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("Movie saved successfully");
    }

    @GetMapping
    public ResponseEntity<List<MovieListRes>> getMovieList(){
        List<MovieListRes> movieList = movieService.getAllMovie();
        return ResponseEntity.status(HttpStatus.OK).body(movieList);
    }

    @GetMapping("id/{movieId}")
    public ResponseEntity<List<MovieListRes>> getMovieById(@PathVariable ObjectId movieId){
        List<MovieListRes> movie = movieService.getMovieById(movieId);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    @PutMapping("id/{movieId}")
    public ResponseEntity<String> updateMovieById(@PathVariable ObjectId movieId,@RequestBody MovieListReq movieRequest){
        return ResponseEntity.status(HttpStatus.OK).body(movieService.updateMovieById(movieId,movieRequest));
    }


}
