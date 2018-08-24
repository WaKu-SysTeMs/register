/*
 * 店舗情報 STORE_INFO
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
@Table(name = "store_info")
public class StoreInfo implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Id
    @Size(max = 3)
    private String store_id;            // 店舗ID

    @Size(max = 20)
    private String store_name;          // 店舗名

    @Size(max = 60)
    private String store_add;           // 店舗住所

    @Size(max = 20)
    private String store_phone;         // 電話番号

    @Size(max = 40)
    private String store_mail;          // メールアドレス

    @OneToMany(mappedBy = "store_id", cascade = CascadeType.ALL)
    private List<Employee> employee;

    @OneToMany(mappedBy = "store_id", cascade = CascadeType.ALL)
    private List<Register> register;

    @OneToMany(mappedBy = "store_id", cascade = CascadeType.ALL)
    private List<DvdInfo> dvdInfo;

    @OneToMany(mappedBy = "store_id", cascade = CascadeType.ALL)
    private List<Stock> stock;
    
    @Transient
    private boolean editable;           // シリアライズしない

    /* コンストラクタ */
    public StoreInfo() {
    }

    public StoreInfo(String store_id, String store_name, String store_add, String store_phone, String store_mail) {
        this.store_id = store_id;
        this.store_name = store_name;
        this.store_add = store_add;
        this.store_phone = store_phone;
        this.store_mail = store_mail;
    }

    /* ゲッター、セッター */
    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_add() {
        return store_add;
    }

    public void setStore_add(String store_add) {
        this.store_add = store_add;
    }

    public String getStore_phone() {
        return store_phone;
    }

    public void setStore_phone(String store_phone) {
        this.store_phone = store_phone;
    }

    public String getStore_mail() {
        return store_mail;
    }

    public void setStore_mail(String store_mail) {
        this.store_mail = store_mail;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public List<Register> getRegister() {
        return register;
    }

    public void setRegister(List<Register> register) {
        this.register = register;
    }

    public List<DvdInfo> getDvdInfo() {
        return dvdInfo;
    }

    public void setDvdInfo(List<DvdInfo> dvdInfo) {
        this.dvdInfo = dvdInfo;
    }

    public List<Stock> getStock() {
        return stock;
    }

    public void setStock(List<Stock> stock) {
        this.stock = stock;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
