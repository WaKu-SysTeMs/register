/*
 * 会員　CRUD処理クラス
 */
package db;

import entity.Member;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/**
 *
 * @author s20163037
 */
@Stateless
public class MemberDb {

    @PersistenceContext
    private EntityManager em;  // エンティティマネージャ

    public void create(Member member) {  // 作成・登録
        em.persist(member);
    }

//    public void update(Member member) {  // 更新
//        em.merge(member);
//    }
//
//    public void delete(Member member) {  // 削除
//        em.remove(em.merge(member));
//    }
//
//    public Member find(Integer key) {  // 検索
//        return em.find(Member.class, key);
//    }

    public List<Member> find(String name) {  // の検索
        TypedQuery<Member> q = em.createNamedQuery(Member.MemberQName, Member.class);
        q.setParameter(1, name);
        return q.getResultList();
    }

    public List<Member> getAll() {  // 会員データ全件取得
        return em.createNamedQuery(Member.MemberQAll, Member.class).getResultList();
    }
    
    
}
