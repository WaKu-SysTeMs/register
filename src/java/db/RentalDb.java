///*
// * 貸出処理　CRUD処理クラス
// */
//package db;
//
//import entity.Rental;
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
//public class RentalDb {
//
////    @PersistenceContext
////    private EntityManager em;  // エンティティマネージャ
////
////    public void create(Rental rental) {  // 作成・登録
////        em.persist(rental);
////    }
////
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
////
////    public List<Rental> getAll() {  // 貸出データ全件取得
////        return em.createNamedQuery(Rental.RentalQAll, Rental.class).getResultList();
////    }
//}
