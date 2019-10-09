package hexarch.tutorial.infrastructure.summary;

import hexarch.tutorial.domain.summary.Summary;
import hexarch.tutorial.domain.summary.SummaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("summary")
public class SummaryHttpAPI {

    private SummaryService summaryService;

    public SummaryHttpAPI(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @GetMapping
    Summary getSummary(@RequestParam("merchantName") String merchantName) {
        return summaryService.getSummary(merchantName);
    }
}
