/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author s20163037
 */
@Entity
@Table(name = "register")
public class Register implements Serializable {

    private static final long serialVersionUID = 1L; // シリアライズ

    @Id
    private String register_id;         // レジID

    private Store store_id;             // 店舗ID

    @Size(max = 7)
    private int register_amt = 0;           // レジ内金額
}
