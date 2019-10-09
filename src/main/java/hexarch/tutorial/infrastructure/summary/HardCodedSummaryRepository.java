package hexarch.tutorial.infrastructure.summary;

import hexarch.tutorial.domain.summary.Summary;
import hexarch.tutorial.domain.summary.SummaryRepository;

class HardCodedSummaryRepository implements SummaryRepository {

    @Override
    public Summary getSummary(String merchantName) {
        return new Summary(merchantName, 5f);
    }

    @Override
    public void updateSummary(Summary summary) {
        System.out.println("Summary is hardcoded, no updates were maded.");
    }
}
