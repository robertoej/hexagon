package hexarch.tutorial.domain.summary;

public class SummaryService {
    private SummaryRepository summaryRepository;

    public SummaryService(SummaryRepository summaryRepository) {
        this.summaryRepository = summaryRepository;
    }

    public void addToSummary(String merchantName, Float score) {
        Summary summary = getOrCreateSummary(merchantName);

        Float newScore = summary.getScore() + score;

        summary.setScore(newScore);

        summaryRepository.updateSummary(summary);
    }

    public Summary getSummary(String merchantName) {
        Summary summary = getOrCreateSummary(merchantName);

        return summary;
    }

    private Summary getOrCreateSummary(String merchantName) {
        Summary summary = summaryRepository.getSummary(merchantName);

        if (summary == null) {
            summary = new Summary(merchantName, 5f);

            summaryRepository.updateSummary(summary);
        }

        return summary;
    }
}
