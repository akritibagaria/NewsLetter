package phonepe.newsletter.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NewsLetter {

	private final String id;
	private final String title;
    private final User publisher;
    private final int price ;
	private final ArrayList<Category> category;
	
	public NewsLetter(String newsLetterId, String title2, User user, int price2, List<Category> categories) {
		id = newsLetterId ;
		title = title2 ;
		publisher = user ;
		price = price2 ;
		category = (ArrayList<Category>) categories;
	}

	public int getPrice() {
		
		return this.price;
	}


}
