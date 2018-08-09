/*
 * REGISTER
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author s20163037
 */
@Entity
@Table(name = "register")
public class Register implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Id
    @Size(max = 4)
    private String register_id;         // レジID

    @NotNull
    @Size(max = 3)
    private StoreInfo store_id;             // 店舗ID(FK)

    @Size(max = 7)
    private Integer register_amt;           // レジ内金額

    @OneToMany(mappedBy = "register_id", cascade = CascadeType.ALL)
    private List<RentalInfo> rental;

    @Transient                           // シリアライズしない
    private boolean editable;

    /* コンストラクタ */
    public Register() {
    }

    public Register(String register_id, StoreInfo store_id, Integer register_amt) {
        this.register_id = register_id;
        this.store_id = store_id;
        this.register_amt = register_amt;
    }

    /* ゲッター、セッター */
    public String getRegister_id() {
        return register_id;
    }

    public void setRegister_id(String register_id) {
        this.register_id = register_id;
    }

    public StoreInfo getStore_id() {
        return store_id;
    }

    public void setStore_id(StoreInfo store_id) {
        this.store_id = store_id;
    }

    public Integer getRegister_amt() {
        return register_amt;
    }

    public void setRegister_amt(Integer register_amt) {
        this.register_amt = register_amt;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
