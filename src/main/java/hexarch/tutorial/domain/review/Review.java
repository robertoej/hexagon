package hexarch.tutorial.domain.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    public enum Type {
        DISH,
        ORDER,
        OTHER
    }

    private String merchantName;
    private String comment;
    private Float average;
    private Type reviewType;
}
