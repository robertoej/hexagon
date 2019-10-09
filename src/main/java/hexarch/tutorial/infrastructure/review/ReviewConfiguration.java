package hexarch.tutorial.infrastructure.review;

import hexarch.tutorial.domain.review.ReviewService;
import hexarch.tutorial.domain.summary.SummaryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReviewConfiguration {

    @Bean
    ReviewHttpAPIConverter reviewConverter() {
        return new ReviewHttpAPIConverter();
    }

    @Bean
    ReviewService reviewService(SummaryService summaryService) {

        return new ReviewService(new ReviewFileRepository(), summaryService);
    }
}
