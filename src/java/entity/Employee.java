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

/**
 *
 * @author s20163037
 */
@Entity
@Table(name = "emp_info")
public class Employee implements Serializable{
    
    private static final long serialVersionUID = 1L; // シリアライズ
    
    @Id
    private Integer emp_num;
}
