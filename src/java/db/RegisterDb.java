/*
 * ブラック会員情報　CRUD処理クラス
 */
package db;

import entity.Register;
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
public class RegisterDb extends TryCatchDb {

    @PersistenceContext
    private EntityManager em;

    public RegisterDb() {
        super(Register.class);
    }

    public Register loginid(String password) {
        try {
            Query q = em.createNativeQuery("select * from register where register_id = ?1", Register.class);
            q.setParameter(1, password);
            return (Register) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
