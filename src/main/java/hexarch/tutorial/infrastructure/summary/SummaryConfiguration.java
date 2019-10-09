package hexarch.tutorial.infrastructure.summary;

import hexarch.tutorial.domain.summary.SummaryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SummaryConfiguration {

    @Bean
    SummaryService summaryService() {
        InMemorySummaryRepository summaryRepository = new InMemorySummaryRepository();
        return new SummaryService(summaryRepository);
    }
}
