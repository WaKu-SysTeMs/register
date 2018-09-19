/*
 * 返却処理用Bean
 */
package bean;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import login.AccountManager;

@Named
@ConversationScoped
public class ReturnBean implements Serializable {

    @Inject
    transient Logger log;
    
    @Inject
    Conversation conv;
    
    @Inject
    AccountManager AM;

    /**
     * 返却処理
     *
     * @return 返却処理へ
     */
    public String update() {
        if (conv.isTransient()) {
            conv.begin();
            log.info(log.getName() + " | 返却処理開始 ****");
        } else {
            log.info(log.getName() + " | 貸出会話スコープ ****");
        }
        return "/pages/return/update.xhtml?faces-redirect=true";
    }

}
