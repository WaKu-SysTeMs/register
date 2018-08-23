/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author s20163060
 */
public class Test2 {
    
    private Integer num;
    private String name;
    private String shop;
    private String date1;
    private String date2;
    private Integer money;
    
    public Test2(){}

    public Test2(Integer num, String name, String shop, String date1, String date2, Integer money) {
        this.num = num;
        this.name = name;
        this.shop = shop;
        this.date1 = date1;
        this.date2 = date2;
        this.money = money;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
    
    
}
