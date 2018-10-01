package db;

import entity.DelayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import util.TryCatchDb;

/**
 *
 * @author s20163037
 */
@Stateless
public class DelayListDb extends TryCatchDb {

    @PersistenceContext
    EntityManager em;

    public DelayListDb() {
        super(DelayList.class);
    }

    /**
     *
     * @param member_num
     * @return
     */
    public DelayList searchDelay(String member_num) {
        try {
            Query q = em.createNativeQuery("SELECT * FROM delay_list WHERE member_num = ?1", DelayList.class);
            q.setParameter(1, member_num);
            return (DelayList) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
