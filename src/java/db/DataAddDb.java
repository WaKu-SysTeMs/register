package db;

import entity.Category;
import entity.Member;
import entity.ProductInfo;
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
public class DataAddDb {

    @PersistenceContext
    private EntityManager em;  // エンティティマネージャ

    public void createProduct(ProductInfo p) {  // 作成・登録
        em.persist(p);
    }
    
        public void createCate(Category p) {  // 作成・登録
        em.persist(p);
    }

//    public void update(Member member) {  // 更新
//        em.merge(member);
//    }
//
//    public void delete(Member member) {  // 削除
//        em.remove(em.merge(member));
//    }

//    public Member find(Integer key) {  // 検索
//        return em.find(Member.class, key);
//    }

//    public List<Member> find(String name) {  // の検索
//        TypedQuery<Member> q = em.createNamedQuery(Member.MemberQName, Member.class);
//        q.setParameter(1, name);
//        return q.getResultList();
//    }
//
//    public List<Member> getAll() {  // 会員データ全件取得
//        return em.createNamedQuery(Member.MemberQAll, Member.class).getResultList();
//    }
    
    
}
