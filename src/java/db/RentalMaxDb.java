/*
 * ブラック会員情報　CRUD処理クラス
 */
package db;

import entity.RentalMax;
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
public class RentalMaxDb extends TryCatchDb {
    @PersistenceContext
    EntityManager em;

    public RentalMaxDb() {
        super(RentalMax.class);
    }
    
    public RentalMax syutoku(String member_num){
        try {
            Query q = em.createNativeQuery("select * from rental_max where member_num = ?1",RentalMax.class);
            q.setParameter(1, member_num);
            return (RentalMax)q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;        
    }


    public void genzan(String member_num, Integer size, Integer kasidasijougen) {
        try {            
            Query q = em.createNativeQuery("update rental_max set borrowing_cnt = ?1 where member_num = ?2");
            q.setParameter(1, (kasidasijougen - size));
            q.setParameter(2, member_num);
            q.executeUpdate();
            em.refresh((RentalMax)this.search(member_num));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
