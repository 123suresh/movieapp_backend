package movie.com.example.movie.dto;

import lombok.*;
import movie.com.example.movie.entity.MovieList;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserReq {
    @NonNull
    private String userName;
    @NonNull
    private String password;
    private List<MovieList> movieList = new ArrayList<>();
}
