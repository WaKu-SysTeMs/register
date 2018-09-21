package db;

//import entity.Rental;
import entity.ProductInfo;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
 
    public ProductInfo serchName(String productnum){
        try {
            Query q=em.createNativeQuery("select * from ProductInfo where product_num = ?1", ProductInfo.class);
            q.setParameter(1, productnum);
            return (ProductInfo)q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ProductInfo serchProduct(String product_num) {
        try {
            Query q=em.createNativeQuery("select * from product_info where product_num = ?1", ProductInfo.class);
            q.setParameter(1, product_num);
            return (ProductInfo)q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ProductInfo> prokensaku(String product_name) {
        try {
            Query q = em.createNativeQuery("select * from product_info where product_name like ?1",ProductInfo.class);
            q.setParameter(1, ("%"+product_name+"%"));
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
