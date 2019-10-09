package hexarch.tutorial.domain.review;

import hexarch.tutorial.domain.summary.SummaryService;

public class ReviewService {
    private ReviewRepository reviewRepository;
    private SummaryService summaryService;

    public ReviewService(ReviewRepository reviewRepository, SummaryService summaryService) {
        this.reviewRepository = reviewRepository;
        this.summaryService = summaryService;
    }

    public void processReview(Review review) {
        switch (review.getReviewType()) {
            case DISH:
                processDishReview(review);
                break;
            case ORDER:
                processOrderReview(review);
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    private void processOrderReview(Review review) {
        reviewRepository.saveReview(review);
        summaryService.addToSummary(review.getMerchantName(), review.getAverage());
    }

    private void processDishReview(Review review) {
        reviewRepository.saveReview(review);

        if (review.getComment() != null) {
            summaryService.addToSummary(review.getMerchantName(), review.getAverage());
        }
    }
}
