package movie.com.example.movie.exception;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    @NotNull
    private String errorMessage;

    @NotNull
    private String requestedURI;

    @NotNull
    private int statusCode;

    @NotNull
    private Instant timestamp;
}
