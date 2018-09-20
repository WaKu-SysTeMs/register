/*
 * ブラック会員情報　CRUD処理クラス
 */
package db;

import entity.JoinList;
import java.util.Calendar;
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
public class JoinListDb extends TryCatchDb {
    @PersistenceContext
    private EntityManager em;

    public JoinListDb() {
        super(JoinList.class);
    }

    public void insert(Date d, String member_num) {
        Date today = d;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.YEAR, 1);
        d=calendar.getTime();
        
        try {
            Query q = em.createNativeQuery("insert into join_list values(?1,'0',?2,?3)");
            q.setParameter(1, today);
            q.setParameter(2, d);
            q.setParameter(3, member_num);
            q.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void taikai(String member_num) {
        Query q = em.createNativeQuery("update join_list set resign_flg = 1 where member_num =?1");
        q.setParameter(1, member_num);
        q.executeUpdate();
    }

}
