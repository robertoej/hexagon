package hexarch.tutorial.domain.summary;

public interface SummaryRepository {

    Summary getSummary(String merchantName);

    void updateSummary(Summary summary);
}
