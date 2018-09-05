/*
 * 会員　CRUD処理クラス
 */
package db;

import entity.Member;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import util.TryCatchDb;


/**
 *
 * @author s20163037
 */
@Stateless
public class MemberDb extends TryCatchDb {
    
    @PersistenceContext
    private EntityManager em;
    
    public MemberDb() {
        super(Member.class);
    }
    
    public void getName(){
        TypedQuery<Member> q = em.createNamedQuery(Member.QName, Member.class);
        q.setParameter(1, 100000001);
        q.getResultList();
    }


}
