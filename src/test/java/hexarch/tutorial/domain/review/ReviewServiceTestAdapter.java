package hexarch.tutorial.domain.review;

import hexarch.tutorial.domain.summary.SummaryService;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

class ReviewServiceTestAdapter {

    @InjectMocks
    ReviewService reviewService;

    @Mock
    ReviewRepository reviewRepository;

    @Mock
    SummaryService summaryService;

    Review review;

    @BeforeEach
    void setUp() {
        initMocks(this);

        review = new Review();
        review.setAverage(5f);
        review.setMerchantName("Unit test");
        review.setReviewType(Review.Type.DISH);
    }

    @Test
    @DisplayName("Should not add to summary dish review without comment")
    void processDishReviewWithoutComment() {
        review.setComment(null);
        review.setReviewType(Review.Type.DISH);

        reviewService.processReview(review);

        verify(reviewRepository).saveReview(review);
        verify(summaryService, never()).addToSummary(anyString(), anyFloat());
    }

    @Test
    @DisplayName("Should add to summary dish review with comment")
    void processDishReviewWithComment() {
        review.setReviewType(Review.Type.DISH);
        review.setComment("Test comment");

        reviewService.processReview(review);

        verify(reviewRepository).saveReview(review);
        verify(summaryService).addToSummary(review.getMerchantName(), review.getAverage());
    }

    @Test
    @DisplayName("Should add summary order review with comment")
    void processOrderReviewWithComment() {
        review.setReviewType(Review.Type.ORDER);
        review.setComment("Test comment");

        reviewService.processReview(review);

        verify(reviewRepository).saveReview(review);
        verify(summaryService).addToSummary(review.getMerchantName(), review.getAverage());
    }

    @Test
    @DisplayName("Should add summary order review without comment")
    void processOrderReviewdWithoutComment() {
        review.setReviewType(Review.Type.ORDER);
        review.setComment(null);

        reviewService.processReview(review);

        verify(reviewRepository).saveReview(review);
        verify(summaryService).addToSummary(review.getMerchantName(), review.getAverage());
    }

    @Test
    @DisplayName("Should throw exception when review type is null")
    void processOrderReviewWithoutType() {
        review.setReviewType(Review.Type.OTHER);

        assertThrows(UnsupportedOperationException.class, () -> reviewService.processReview(review));

        verify(reviewRepository, never()).saveReview(any(Review.class));
        verify(summaryService, never()).addToSummary(anyString(), anyFloat());
    }
}