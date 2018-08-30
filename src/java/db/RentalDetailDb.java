package db;

//import entity.Rental;
import entity.RentalDetail;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import util.TryCatchDb;


/**
 *
 * @author s20163037
 */
@Stateless
public class RentalDetailDb extends TryCatchDb{
    
    @PersistenceContext
    EntityManager em; 
    
    public RentalDetailDb() {
        super(RentalDetail.class);
    }
 
    

}
