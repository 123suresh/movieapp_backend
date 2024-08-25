package movie.com.example.movie.repository;

import movie.com.example.movie.entity.MovieList;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<MovieList, ObjectId> {
}
