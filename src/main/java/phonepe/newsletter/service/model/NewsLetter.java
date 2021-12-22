package phonepe.newsletter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NewsLetter {

	private final String id;
	private final Category category;
	private final String title;
    private final User publisher;
    private final int price ;


}
