package phonepe.newsletter.service;
import java.util.ArrayList;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import phonepe.newsletter.model.*;
import phonepe.newsletter.service.*;

@AllArgsConstructor
public class EarningsService {
	SubscriptionService subscriptionService ;
	UserService userService ;
	HashMap<User, ArrayList<NewsLetter>>  publisherDb = new HashMap<User,  ArrayList<NewsLetter>>();

	public void addNewsLetterToDb(User publisher, NewsLetter nl) {
		
		if(publisherDb.containsKey(publisher)) {
			ArrayList<NewsLetter> list = publisherDb.get(publisher);
			list.add(nl);
			publisherDb.put(publisher, list);
		}
		else {
			ArrayList<NewsLetter> list = new ArrayList<NewsLetter>();
			list.add(nl);
			publisherDb.put(publisher, list);
		}
		
	}
	
	int fetchEarnings(String userId) {
		
		User publisher = userService.getUser(userId);
		int price = 0 ;
		for(NewsLetter nl: publisherDb.get(publisher)) {
			  int noOfUsers = subscriptionService.getSubscriptions(nl).size();
			  price = price +  nl.getPrice() * noOfUsers ;
		}
		return price ;
		
	}
	
	
	
	
	


}
