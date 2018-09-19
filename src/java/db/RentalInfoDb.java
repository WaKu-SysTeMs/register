/*
 * 貸出処理　CRUD処理クラス
 */
package db;

//import entity.Rental;
import entity.RentalInfo;
import java.math.BigDecimal;
import java.util.Date;
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
public class RentalInfoDb extends TryCatchDb{
    
    @PersistenceContext
    private EntityManager em;
    
    Integer cnt;
    
    public RentalInfoDb() {
        super(RentalInfo.class);
    }

    public void insert(int seikyuu, Date kasidasihizuke, String user, String member_num, String password) {
        try {
            Query q = em.createNativeQuery("select count(*) from rental_info");
            cnt = ((BigDecimal)q.getSingleResult()).intValue();
            cnt++;
            setCnt(cnt);
        } catch (Exception e) {
             e.printStackTrace();
        }
        String s;
        s = Integer.toString(this.getCnt());
        
        try {
            Query q = em.createNativeQuery("insert into rental_info values(?1,?2,?3,?4,?5,?6)");
            q.setParameter(1,s);
            q.setParameter(2,seikyuu);
            q.setParameter(3,kasidasihizuke);
            q.setParameter(4,user);
            q.setParameter(5,member_num);
            q.setParameter(6,password);
            q.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }
    
    
    
}
