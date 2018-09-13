/*
 * 会員　CRUD処理クラス
 */
package db;

import entity.Member;
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
public class MemberDb extends TryCatchDb {
    
    @PersistenceContext
    private EntityManager em;
    
    public MemberDb() {
        super(Member.class);
    }
    

    /**
     *  会員番号の昇順で会員一覧を取得し、返す。
     * @return 会員一覧(昇順)
     */
    @Override
    public List<Member> getAll(){
        TypedQuery<Member> query = em.createNamedQuery(Member.QAll, Member.class);
        return query.getResultList();
    }
    
    public Member searchName(String memberNum){
        try {
            Query q=em.createNativeQuery("select * from member_info where member_num = ?1", Member.class);
            q.setParameter(1, memberNum);
            return (Member)q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }


}
