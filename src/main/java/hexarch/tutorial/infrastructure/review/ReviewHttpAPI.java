package hexarch.tutorial.infrastructure.review;

import hexarch.tutorial.domain.review.IReviewService;
import hexarch.tutorial.domain.review.Review;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("review")
class ReviewHttpAPI {

    private IReviewService reviewService;
    private ReviewHttpAPIConverter reviewHttpAPIConverter;

    ReviewHttpAPI(IReviewService reviewService, ReviewHttpAPIConverter reviewHttpAPIConverter) {
        this.reviewService = reviewService;
        this.reviewHttpAPIConverter = reviewHttpAPIConverter;
    }

    @PostMapping
    void processReview(@RequestParam("average") String average,
                       @RequestParam("text") String text,
                       @RequestParam("merchantName") String merchantName,
                       @RequestParam("reviewType") String reviewType) {
        Review model = reviewHttpAPIConverter.toReviewModel(average, text, merchantName, reviewType);

        reviewService.processReview(model);
    }
}
