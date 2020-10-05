package cn.wkd.examples.dao;

import cn.wkd.examples.domain.Cart;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 许佳华
 * @Description:
 * @date 2020/3/12 22:04
 */
@Repository
public interface CartDAO {

    /**
     * 添加到购物车
     * @param cart
     */
    public void addCart(Cart cart);

    /**
     * 根据参数查询购物车信息
     * @param map
     * @return
     */
    public List<Cart> queryCartByParam(Map<String,Object> map);

    /**
     * 修改查询购物车信息
     * @param cart
     * @return
     */
    public void editCart(Cart cart);

    /**
     * 删除购物车中的某一件商品
     * @param map
     */
    public void deleteCart(Map<String,Object> map);

    /**
     * 清空购物车
     * @param uid
     */
    public void clearCart(int uid);
}
