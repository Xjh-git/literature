package cn.wkd.examples.domain;

/**
 * @author 许佳华
 * @Description: 用户的订单
 * @date 2020/3/13 8:39
 */
public class Order {
    private int order_id; //订单id
    private int order_num; //订单中图书数量
    private double order_totalprice;  //订单总金额
    private String bk_ISBN;  //订单中图书书号
    private int uid;  //订单属于的用户的用户id

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_num=" + order_num +
                ", order_totalprice=" + order_totalprice +
                ", bk_ISBN='" + bk_ISBN + '\'' +
                ", uid=" + uid +
                '}';
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getOrder_num() {
        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public double getOrder_totalprice() {
        return order_totalprice;
    }

    public void setOrder_totalprice(double order_totalprice) {
        this.order_totalprice = order_totalprice;
    }

    public String getBk_ISBN() {
        return bk_ISBN;
    }

    public void setBk_ISBN(String bk_ISBN) {
        this.bk_ISBN = bk_ISBN;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Order() {
    }
}
