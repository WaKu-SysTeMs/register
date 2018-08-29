/*
 * 会員情報処理　Bean
 */
package bean;

import db.BlackMgrDb;
import db.MemberDb;
import entity.BlackMgr;
import entity.Member;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/**
 *
 * @author s20163037
 */
@Named
@SessionScoped
public class MemberBean implements Serializable {
    
    private Integer memberNum;
    
        private String Name;
    
    @PersistenceContext
    EntityManager em;

    @EJB
    MemberDb memberDb;
    
    @EJB
    BlackMgrDb blackMgrDb;

    @Inject
    transient Logger log;

    @Inject
    Conversation conv;

    @PostConstruct
    public void start() {
        if (!conv.isTransient()) {
            log.info(log.getName() + "| 会話スコープ終了");
            conv.end();
        }
    }

    public String create() {
        log.info(log.getName() + "| 会員登録画面");
        if (conv.isTransient()) {
            conv.begin();
        }
        return "/pages/member/create.xhtml";
    }
    
    public List<Member> getAll(){
        return memberDb.getAll();
    }
    
    public void getName(Integer memberNum){
        Member Name = (Member) memberDb.search(memberNum);   // 会員名取得
        this.Name = Name.getMember_name();
    }
    
    public List<BlackMgr> findFlg(){
        Member mN = null;
        mN.getMember_num();
        
        TypedQuery<BlackMgr> q = em.createNamedQuery(BlackMgr.BlackMgrQFlg, BlackMgr.class);
        q.setParameter(1, mN);
        return q.getResultList();
    }

}
