package phonepe.newsletter.service;
import java.util.HashMap;
import java.util.UUID;

import phonepe.newsletter.model.*;

public class UserService {
	HashMap<String, User> userDb = new HashMap<String, User>();
	
	
	User registerUser(String name, String email) {
		String userId = UUID.randomUUID().toString();
		User user = new User(userId, name, email);
		userDb.put(userId, user);
		return user;
	}


	public User getUser(String userId) {
         return userDb.get(userId);
	}

}
