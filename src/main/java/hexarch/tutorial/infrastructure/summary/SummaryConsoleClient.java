package hexarch.tutorial.infrastructure.summary;

import hexarch.tutorial.domain.summary.SummaryService;

class SummaryConsoleClient {

    public static void main(String[] args) {
        String merchantName = "Merchant Console Test";

        SummaryService summaryService = new SummaryService(new InMemorySummaryRepository());

        summaryService.addToSummary(merchantName, 5f);

        System.out.println(summaryService.getSummary(merchantName));
    }
}
