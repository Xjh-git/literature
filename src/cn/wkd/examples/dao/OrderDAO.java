package cn.wkd.examples.dao;

import cn.wkd.examples.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 许佳华
 * @Description: 修改用户的订单表的接口
 * @date 2020/3/13 8:42
 */
@Repository
public interface OrderDAO {
    /**
     * 添加用户的订单信息
     * @param order
     */
    public void addOrder(Order order);

    /**
     * 查询某个用户的全部订单
     * @param uid
     */
    public List<Order> queryOrderByUid(int uid);
}
