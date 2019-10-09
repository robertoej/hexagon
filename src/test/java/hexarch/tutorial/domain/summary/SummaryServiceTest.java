package hexarch.tutorial.domain.summary;

import hexarch.tutorial.domain.review.Review;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class SummaryServiceTest {

    @InjectMocks
    SummaryService summaryService;

    @Mock
    SummaryRepository summaryRepository;

    Review review;
    Summary summary;

    @BeforeEach
    void setUp() {
        initMocks(this);

        String merchantName = "Unit test";

        review = new Review();
        review.setAverage(4.1f);
        review.setMerchantName(merchantName);

        summary = new Summary(merchantName, 1f);
    }

    @Test
    @DisplayName("Should add review average to summary score")
    void addToSummary() {
        Summary expectedSummary = new Summary(review.getMerchantName(), review.getAverage() + summary.getScore());

        when(summaryRepository.getSummary(review.getMerchantName())).thenReturn(summary);

        summaryService.addToSummary(review.getMerchantName(), review.getAverage());

        verify(summaryRepository).updateSummary(expectedSummary);
    }

    @Test
    @DisplayName("Should fetch and return summary")
    void getSummary() {
        when(summaryRepository.getSummary(review.getMerchantName())).thenReturn(summary);

        Summary returnedSummary = summaryService.getSummary(review.getMerchantName());

        verify(summaryRepository).getSummary(review.getMerchantName());
        assertEquals(summary, returnedSummary);
    }

    @Test
    @DisplayName("Should return new summary when inexistent")
    void getInexSummary() {
        Summary returnedSummary = summaryService.getSummary(review.getMerchantName());
        Summary expectedSummary = new Summary(review.getMerchantName(), 5f);

        verify(summaryRepository).getSummary(review.getMerchantName());

        assertEquals(expectedSummary, returnedSummary);
    }
}