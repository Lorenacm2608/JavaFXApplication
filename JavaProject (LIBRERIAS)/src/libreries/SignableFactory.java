package libreries;
/**
 *
 * @author Nadir Essadi
 */
public class SignableFactory {
    
    public Signable getSignableImplementation( ){      
            return new SignableImplementation();
             
    }
}