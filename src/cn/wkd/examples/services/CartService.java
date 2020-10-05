package cn.wkd.examples.services;

import cn.wkd.examples.dao.CartDAO;
import cn.wkd.examples.domain.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 许佳华
 * @Description:
 * @date 2020/3/12 22:11
 */
@Service
public class CartService {
    @Autowired
    CartDAO cartDAO;

    /**
     * 添加到购物车
     *
     * @param cart
     */
    public void addCart(Cart cart) {
        Map<String, Object> map = new HashMap<>();
        map.put("bk_ISBN", cart.getBk_ISBN());
        List<Cart> carts = cartDAO.queryCartByParam(map);
        if (carts.size() > 0) {
            cart = carts.get(0);
            cart.setCart_num(cart.getCart_num() + 1);
            cartDAO.editCart(cart);
        } else
            cartDAO.addCart(cart);
    }

    /**
     * 修改购物车，如果数量小于等于0，则删除
     *
     * @param cart
     */
    public void editCart(Cart cart) {
        if (cart.getCart_num() <= 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("cart_id", cart.getCart_id());
            cartDAO.deleteCart(map);
        } else {
            cartDAO.editCart(cart);
        }
    }

    /**
     * 清空购物车
     *
     * @param uid
     */
    public void clearCart(int uid) {
        cartDAO.clearCart(uid);
    }

    /**
     * 查询某个用户的购物车列表
     * @param uid
     * @return
     */
    public List<Cart> queryCartByUid(int uid) {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        return cartDAO.queryCartByParam(map);
    }

    public void deleteCart(int cart_id){
        Map<String,Object> map = new HashMap<>();
        map.put("cart_id",cart_id);
        cartDAO.deleteCart(map);
    }
}
