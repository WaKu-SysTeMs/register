/*
 * ブラック会員情報　CRUD処理クラス
 */
package db;

import entity.DvdInfo;
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
public class DvdInfoDb extends TryCatchDb {
    @PersistenceContext
    private EntityManager em;

    public DvdInfoDb() {
        super(DvdInfo.class);
    }
    
    public DvdInfo serchDVD(String dvdNum){
        try {
            Query q=em.createNativeQuery("select * from dvd_info where dvd_num = ?1", DvdInfo.class);
            q.setParameter(1, dvdNum);
            return (DvdInfo)q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insert(int seikyuu, Date kasidasihizuke, String user, String member_num, String password) {
        try {
            Query q = em.createNativeQuery("insert into rental_info values('999',?2,?3,?4,?5,?6)");
     //     q.setParameter(1,自動採番された数値をあStringに変換した値);
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
}
