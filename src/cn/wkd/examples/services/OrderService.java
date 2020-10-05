package cn.wkd.examples.services;

import cn.wkd.examples.dao.OrderDAO;
import cn.wkd.examples.domain.Book;
import cn.wkd.examples.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 许佳华
 * @Description:
 * @date 2020/3/13 8:50
 */
@Service
public class OrderService {
    @Autowired
    OrderDAO orderDAO;
    @Autowired
    BookService bookService;

    /**
     * 添加用户的订单信息
     * @param order
     */
    public void addOrder(Order order) {
        Book book = bookService.queryBookByISBN(order.getBk_ISBN());
        order.setOrder_totalprice(order.getOrder_num() * book.getBk_price());
        orderDAO.addOrder(order);
    }

    /**
     * 查询某个用户的全部订单
     * @param uid
     */
    public List<Order> queryOrderByUid(int uid) {
        return orderDAO.queryOrderByUid(uid);
    }
}
