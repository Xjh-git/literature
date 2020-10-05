package cn.wkd.examples.domain;

/**
 * @author 许佳华
 * @Description:
 * @date 2020/3/12 22:03
 */
public class Cart {
    private int cart_id; //购物车id
    private int cart_num; //商品数量
    private String bk_ISBN; //书名
    private int uid; //用户id

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cart_id=" + cart_id +
                ", cart_num=" + cart_num +
                ", bk_ISBN='" + bk_ISBN + '\'' +
                ", uid=" + uid +
                '}';
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getCart_num() {
        return cart_num;
    }

    public void setCart_num(int cart_num) {
        this.cart_num = cart_num;
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
}
