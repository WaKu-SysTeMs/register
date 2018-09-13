/*
 * ブラック会員情報　CRUD処理クラス
 */
package db;

import entity.ReleaseList;
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
public class ReleaseListDb extends TryCatchDb {
    @PersistenceContext
    private EntityManager em;

    public ReleaseListDb() {
        super(ReleaseList.class);
    }
    
    public ReleaseList serchName(String kbn){
        try {
            Query q=em.createNativeQuery("select * from release_list where release_kbn = ?1", ReleaseList.class);
            q.setParameter(1, kbn);
            return (ReleaseList)q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    


}
