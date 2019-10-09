package hexarch.tutorial.domain.summary;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Summary {

    private String merchantName;
    private Float score;
}
