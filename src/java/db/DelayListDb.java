package db;

import entity.DelayList;
import java.util.Calendar;
import java.util.Date;
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

    public void tourokuall(String rental_num, String detail_num, Integer entaikin) {
        Date d = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        try {
            Query q = em.createNativeQuery("insert into delay_list values(?1,?2,?3,?4)");
            q.setParameter(1, rental_num);
            q.setParameter(2, detail_num);
            q.setParameter(3, entaikin);
            q.setParameter(4, d);
            q.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void touroku(String rental_num, String detail_num, Integer entaikin) {
        try {
            Query q = em.createNativeQuery("insert into delay_list values(?1,?2,?3,null)");
            q.setParameter(1, rental_num);
            q.setParameter(2, detail_num);
            q.setParameter(3, entaikin);
            q.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
