/*
 * DB処理用　汎用クラス(継承)
 */
package util;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author s20163037
 */
public abstract class SuperDb<T> {

    protected Class<T> entityC;

    @PersistenceContext
    private EntityManager em;

    public SuperDb(Class<T> entityC) {
        this.entityC = entityC;
    }

    /* CURD処理 */
    public void create(T entity) {       // 新規登録
        em.persist(entity);
    }

    public void edit(T entity) {      // 更新
        em.merge(entity);
    }

    public void remove(T entity) {      // 削除
        em.remove(em.merge(entity));
    }

    public T find(Object key) {         // 検索
        return em.find(entityC, key);
    }

    /* 全データ取得 */
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityC));
        return em.createQuery(cq).getResultList();
    }

    /* 指定範囲の取得処理 */
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityC));
        javax.persistence.Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    /* 総件数取得 */
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityC);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
