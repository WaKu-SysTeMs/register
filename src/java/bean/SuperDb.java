//package bean;
//
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//public abstract class SuperDb<T>{
//    protected Class<T> entityClass;
//    @PersistenceContext
//    private EntityManager em;
//    public SuperDb(Class<T> entityClass){
//        this.entityClass = entityClass;
//    }
//    
//    //CRUD処理
//    public void create(T entity){  //新規登録
//        em.persist(entity);
//    }
//    public void edit(T entity){    //更新
//        em.merge(entity);
//    }
//    public void remove(T entity){  //削除
//        em.remove(entity);
//    }
//    public T find(Object id){      //検索
//        return em.find(entityClass, id);
//    }
//    
//    //全データ取得処理
//    public List<T> findAll(){
//        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//        cq.select(cq.from(entityClass));
//        return em.createQuery(cq).getResultList();
//    }
//    
//    //指定の範囲の取得処理
//    public List<T> findRange(int[] range){
//        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//        cq.select(cq.from(entityClass));
//        javax.persistence.Query q = em.createQuery(cq);
//        q.setMaxResults(range[1] - range[0] + 1);
//        q.setFirstResult(range[0]);
//        return q.getResultList();
//    }
//    
//    //総件数の取得処理
//    public int count(){
//        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
//        cq.select(em.getCriteriaBuilder().count(rt));
//        javax.persistence.Query q = em.createQuery(cq);
//        return ((Long) q.getSingleResult()).intValue();
//    }
//}