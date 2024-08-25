package movie.com.example.movie.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieListRes {
    @Id
    private ObjectId id;
    @NotNull(message = "Title is required")
    @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
    private String title;
    @NotNull(message = "Description is required")
    private String disc;
    @NotNull(message = "source is required")
    private String src;
    private String cast1;
    private String cast1Name;
    private String cast2;
    private String cast2Name;
    private String videourl;
}
