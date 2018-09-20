/*
 * 会員　CRUD処理クラス
 */
package db;

import entity.Member;
import java.math.BigDecimal;
import java.util.Date;
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
    
    Integer saibangou;
    
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

    public void insert(String member_num, String add_ruby, Date birth_date, String member_add, String member_mail, String member_name, String member_phone, String member_ruby, String postal_code, String sex_name, String job_id) {
        try {
            Query q = em.createNativeQuery("insert into member_info values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,'1',null,?11)");
            q.setParameter(1, member_num);
            q.setParameter(2, add_ruby);
            q.setParameter(3, birth_date);
            q.setParameter(4, member_add);
            q.setParameter(5, member_mail);
            q.setParameter(6, member_name);
            q.setParameter(7, member_phone);
            q.setParameter(8, member_ruby);
            q.setParameter(9, postal_code);
            q.setParameter(10, sex_name);
            q.setParameter(11, job_id);
            q.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cntall() {
        try {
            Query q = em.createNativeQuery("select count(*) from member_info");
            this.saibangou = ((BigDecimal)q.getSingleResult()).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getSaibangou() {
        return saibangou;
    }

    public void setSaibangou(Integer saibangou) {
        this.saibangou = saibangou;
    }

    public List<Member> rubykensaku(String member_ruby) {
            try {
               Query q = em.createNativeQuery("select * from member_info where member_ruby like ?1");
               q.setParameter(1, ("%"+member_ruby+"%"));
               return q.getResultList();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
    }

    public Member kensaku(String member_num) {
            try {
                Query q = em.createNativeQuery("select * from member_info where member_num = ?1");
                q.setParameter(1, member_num);
                return (Member)q.getSingleResult();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
    }
}
