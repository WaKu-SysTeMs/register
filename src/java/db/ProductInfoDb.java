package db;

//import entity.Rental;
import entity.ProductInfo;
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
public class ProductInfoDb extends TryCatchDb{
    
    @PersistenceContext
    EntityManager em;
    
    public ProductInfoDb() {
        super(ProductInfo.class);
    }
 
    

}
