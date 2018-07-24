///*
// * 会員　CRUD処理クラス
// */
//package db;
//
//import entity.Member;
//import java.util.List;
//import javax.ejb.Stateless;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//
//
///**
// *
// * @author s20163037
// */
//@Stateless
//public class MemberDb {
//
//    @PersistenceContext
//    private EntityManager em;  // エンティティマネージャ
//
//    public void create(Member member) {  // 作成・登録
//        em.persist(member);
//    }
//
////    public void update(Rental rental) {  // 更新
////        em.merge(rental);
////    }
////
////    public void delete(Rental rental) {  // 削除
////        em.remove(em.merge(rental));
////    }
////
////    public Rental find(Integer key) {  // 検索
////        return em.find(Rental.class, key);
////    }
//
////    public List<Rental> find(String name) {  // の検索
////        TypedQuery<Rental> q = em.createNamedQuery(Rental.RentalQName, Rental.class);
////        q.setParameter(1, name);
////        return q.getResultList();
////    }
//
//    public List<Member> getAll() {  // 会員データ全件取得
//        return em.createNamedQuery(Member.MemberQAll, Member.class).getResultList();
//    }
//    
//    
//}
