package hexarch.tutorial.infrastructure.summary;

import hexarch.tutorial.domain.summary.Summary;
import hexarch.tutorial.domain.summary.SummaryRepository;

import java.util.HashMap;
import java.util.Map;

class InMemorySummaryRepository implements SummaryRepository {

    private Map<String, Summary> memory;

    public InMemorySummaryRepository() {
        this.memory = new HashMap<>();
    }

    @Override
    public Summary getSummary(String merchantName) {
        return memory.get(merchantName);
    }

    @Override
    public void updateSummary(Summary summary) {
        memory.put(summary.getMerchantName(), summary);
    }
}
