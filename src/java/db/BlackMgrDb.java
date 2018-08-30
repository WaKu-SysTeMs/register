/*
 * ブラック会員情報　CRUD処理クラス
 */
package db;

import entity.BlackMgr;
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
public class BlackMgrDb extends TryCatchDb {


    public BlackMgrDb() {
        super(BlackMgr.class);
    }


}
