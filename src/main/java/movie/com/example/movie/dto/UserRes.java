package movie.com.example.movie.dto;

import lombok.*;
import movie.com.example.movie.entity.MovieList;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRes {
    @NonNull
    private String userName;
    private List<MovieList> movieList;
}
