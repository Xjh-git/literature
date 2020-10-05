package cn.wkd.examples.controller;

import cn.wkd.examples.domain.Order;
import cn.wkd.examples.services.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 许佳华
 * @Description:
 * @date 2020/3/13 8:52
 */
@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    Logger logger = Logger.getLogger(BookController.class);

    /**
     * 查询某个用户的全部订单
     *queryOrderByUid?uid=1
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping("queryOrderByUid")
    public Map<String, Object> queryOrderByUid(int uid) {
        Map<String, Object> map = new HashMap<>();
        logger.info("=================== 查询某个用户的全部订单 ");
        try {
            List<Order> orders = orderService.queryOrderByUid(uid);
            map.put("orders", orders);
            logger.info("=================== orders info : " + orders);
        } catch (Exception e) {
            logger.error("=================== 查询用户的全部订单失败：" + e);
        }
        return map;
    }

    /**
     * 添加订单信息
     * addOrder?isbn=9787020034789&num=1&uid=1
     * @param isbn 添加的图书书号
     * @param num 图书数量
     * @param uid 用户id
     * @return
     */
    @ResponseBody
    @RequestMapping("addOrder")
    public Map<String, Object> addOrder(String isbn, int num, int uid) {
        Map<String, Object> map = new HashMap<>();
        logger.info("=================== 添加一个订单 ");
        try {
            Order order = new Order();
            order.setBk_ISBN(isbn);
            order.setOrder_num(num);
            order.setUid(uid);
            orderService.addOrder(order);
            map.put("success", true);
        } catch (Exception e) {
            logger.error("=================== 添加订单失败：" + e);
        }
        return map;
    }
}
