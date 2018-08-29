/*
 * 会員　CRUD処理クラス
 */
package db;

import entity.BlackMgr;
import entity.Member;
import javax.ejb.Stateless;
import util.TryCatchDb;


/**
 *
 * @author s20163037
 */
@Stateless
public class MemberDb extends TryCatchDb {
    
    public MemberDb() {
        super(Member.class);
    }

}
