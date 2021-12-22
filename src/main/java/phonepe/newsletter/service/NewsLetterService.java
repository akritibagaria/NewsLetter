package phonepe.newsletter.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import phonepe.newsletter.model.*;

import lombok.AllArgsConstructor;
import phonepe.newsletter.model.NewsLetter;

@AllArgsConstructor
public class NewsLetterService {
	
	UserService userService ;
	EarningsService earningsService ;
	HashMap<String, NewsLetter> newsLetterDb = new HashMap<String, NewsLetter>();
	HashMap<Category, ArrayList<NewsLetter>> categoryIndex = new HashMap<Category,  ArrayList<NewsLetter>>();
	
	public NewsLetterService(UserService userService2, EarningsService earningsService2) {
		userService = userService2 ;
		earningsService = earningsService2 ;
	}

	NewsLetter createNewsLetter(String title, String userId, int price, List<Category> categories){
		
		String newsLetterId = UUID.randomUUID().toString();
		User publisher = userService.getUser(userId);
		NewsLetter nl = new NewsLetter(newsLetterId, title, publisher , price, categories );
		newsLetterDb.put(newsLetterId, nl);
		for(Category c: categories) {
			if(categoryIndex.containsKey(c)) {
				ArrayList<NewsLetter> list = categoryIndex.get(c);
				list.add(nl);
				categoryIndex.put(c, list);
			}
			else {
				ArrayList<NewsLetter> list = new ArrayList<NewsLetter>();
				list.add(nl);
				categoryIndex.put(c, list);
			}
			
		}
		earningsService.addNewsLetterToDb(publisher, nl);
		
		return nl;
		
	}
	
	ArrayList<NewsLetter> getNewsLetterByCategory(ArrayList<Category> categories){
		//TODO: Check for duplicate newsletters
		ArrayList<NewsLetter> ans = new ArrayList<NewsLetter>();
		for(Category c: categories) {
			ArrayList<NewsLetter> temp = categoryIndex.get(c);
			for(NewsLetter nl : temp)
				ans.add(nl);
		}
		
		return ans;
		
	}

	public NewsLetter getNewsLetterById(String newsLetterId) {
		return newsLetterDb.get(newsLetterId);
		
	}

}
