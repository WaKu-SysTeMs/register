/*
 * 貸出処理　CRUD処理クラス
 */
package db;

//import entity.Rental;
import entity.RentalInfo;
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
public class RentalDb extends TryCatchDb{
    
    public RentalDb() {
        super(RentalInfo.class);
    }
 
    

}
