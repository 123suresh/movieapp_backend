package movie.com.example.movie.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Indexed;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private ObjectId id;
    //@Indexed(unique = true)
    @NonNull
    private String userName;
    @NonNull
    private String password;

    //here we are mapping the movie id with associated user
    //but only doing this "private List<MovieList> movieList = new ArrayList<>();" your user collection
    //will not link to MovieList collection for that you have to give @DBRef annotation.
    @DBRef
    private List<MovieList> movieList = new ArrayList<>();

}
