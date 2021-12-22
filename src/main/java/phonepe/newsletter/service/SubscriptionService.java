package phonepe.newsletter.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.AllArgsConstructor;
import phonepe.newsletter.model.*;

@AllArgsConstructor
public class SubscriptionService {
	HashMap<NewsLetter, ArrayList<User>> subscriptionDb = new HashMap<NewsLetter,ArrayList<User>>();
	UserService userService;
	NewsLetterService newsLetterService ; 
	
	public SubscriptionService(UserService userService2, NewsLetterService newsLetterService2) {
		userService = userService2;
		newsLetterService = newsLetterService2 ;
	}

	//Assumption: Subscritpion to newsletter always succeeds
	void subscribeToNewsLetter(String userId, String newsLetterId ){
		User u = userService.getUser(userId);
		NewsLetter nl = newsLetterService.getNewsLetterById(newsLetterId);
		
		if(subscriptionDb.containsKey(nl)) {
			ArrayList<User> list = subscriptionDb.get(nl);
			list.add(u);
			subscriptionDb.put(nl, list);
		}
		else {
			ArrayList<User> list = new ArrayList<User>();
			list.add(u);
			subscriptionDb.put(nl, list);
		}

	}
	
	ArrayList<User> getSubscriptions(NewsLetter nl){
		return subscriptionDb.get(nl);
		
	}
	
	

}
