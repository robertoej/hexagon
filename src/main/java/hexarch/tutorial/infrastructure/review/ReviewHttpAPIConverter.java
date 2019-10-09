package hexarch.tutorial.infrastructure.review;

import hexarch.tutorial.domain.review.Review;

class ReviewHttpAPIConverter {

    public Review toReviewModel(String average, String text, String merchantName, String reviewType) {
        return Review.builder()
                .average(Float.parseFloat(average))
                .comment(text)
                .merchantName(merchantName)
                .reviewType(Review.Type.valueOf(reviewType))
                .build();
    }
}
