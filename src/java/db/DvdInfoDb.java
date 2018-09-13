/*
 * ブラック会員情報　CRUD処理クラス
 */
package db;

import entity.DvdInfo;
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


}
