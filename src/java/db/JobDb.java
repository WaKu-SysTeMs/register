/*
 * ブラック会員情報　CRUD処理クラス
 */
package db;

import entity.Job;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import util.TryCatchDb;


/**
 *
 * @author s20163037
 */
@Stateless
public class JobDb extends TryCatchDb {


    public JobDb() {
        super(Job.class);
    }


}
