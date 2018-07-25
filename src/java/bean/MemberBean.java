/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import db.MemberDb;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author s20163037
 */
@Named
@SessionScoped
public class MemberBean implements Serializable{
    
    @EJB
    MemberDb memberDb;
    
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
        return "";
    }

}
