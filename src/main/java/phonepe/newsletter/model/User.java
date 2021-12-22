package phonepe.newsletter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {

	public User(String userId, String name2, String email2) {

		id = userId; 
		name = name2 ;
		email = email2;
	}
	private final String id;
	private final String name;
	private final String email;

}
