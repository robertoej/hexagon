package hexarch.tutorial.infrastructure.review;

import hexarch.tutorial.domain.review.Review;
import hexarch.tutorial.domain.review.ReviewRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReviewFileRepository implements ReviewRepository {

    @Override
    public void saveReview(Review review) {

        try {
            Files.write(Paths.get("./review.txt"), review.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Couldn't write review to file");
        }
    }
}
