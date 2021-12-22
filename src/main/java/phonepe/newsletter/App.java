package phonepe.newsletter;

import phonepe.newsletter.service.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserService userService= new UserService();
        EarningsService earningsService =  new EarningsService() ;
 
        NewsLetterService newsLetterService = new NewsLetterService(userService, earningsService);
        SubscriptionService subscriptionService =  new SubscriptionService(userService, newsLetterService) ;
        subscriptionService.setSubscriptionService(subscriptionService);
        subscriptionService.setUserService(userService);
       
    }
}
