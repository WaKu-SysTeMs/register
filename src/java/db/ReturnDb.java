///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package db;
//
//import entity.Return;
//import java.util.List;
//import javax.ejb.Stateless;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
///**
// *
// * @author s20163060
// */
//@Stateless
//public class ReturnDb {
//    
//    @PersistenceContext
//    private EntityManager em;  // エンティティマネージャ
//
//    public void create(Return retu) {  // 作成・登録
//        em.persist(retu);
//    }
//
//    public void update(Return retu) {  // 更新
//        em.merge(retu);
//    }
//
//    public void delete(Return retu) {  // 削除
//        em.remove(em.merge(retu));
//    }
//
//    public Return find(Integer key) {  // 検索
//        return em.find(Return.class, key);
//    }
//
////    public List<Return> find(String name) {  // の検索
////        TypedQuery<Return> q = em.createNamedQuery(Return.Qdvd_num, Return.class);
////        q.setParameter(1, name);
////        return q.getResultList();
////    }
//
//    public List<Return> getAll() {  // 貸出データ全件取得
//        return em.createNamedQuery(Return.Qreturn, Return.class).getResultList();
//    }
//}
