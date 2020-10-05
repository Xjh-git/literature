package cn.wkd.examples.controller;

import cn.wkd.examples.domain.Book;
import cn.wkd.examples.domain.Cart;
import cn.wkd.examples.services.BookService;
import cn.wkd.examples.services.CartService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 许佳华
 * @Description:
 * @date 2020/3/12 22:12
 */
@Controller
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    BookService bookService;
    Logger logger = Logger.getLogger(BookController.class);

    /**
     * 将图书加入到购物车
     * addCart?isbn=9787020034789&uid=1
     *
     * @param isbn
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping("addCart")
    public Boolean addCart(String isbn, int uid) {
        logger.info("=================== 将图书加入到购物车 ");
        try {
            Cart cart = new Cart();
            cart.setBk_ISBN(isbn);
            cart.setCart_num(1);
            cart.setUid(uid);
            cartService.addCart(cart);
        } catch (Exception e) {
            logger.error("=================== 加入购物车失败：" + e);
        }
        return true;
    }

    /**
     * 修改购物车
     * editCart?isbn=9787020034789&num=10&uid=1
     *
     * @param id  购物车id
     * @param num 数量
     * @return
     */
    @ResponseBody
    @RequestMapping("editCart")
    public boolean editCart(int id, int num) {
        Map<String, Object> map = new HashMap<>();
        logger.info("=================== 修改购物车 ");
        try {
            Cart cart = new Cart();
            cart.setCart_id(id);
            cart.setCart_num(num);
            cartService.editCart(cart);
        } catch (Exception e) {
            logger.error("=================== 修改购物车失败：" + e);
            return false;
        }
        return true;
    }

    /**
     * 清空购物车
     * clearCart?uid=2
     *
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping("clearCart")
    public Map<String, Object> clearCart(int uid) {
        Map<String, Object> map = new HashMap<>();
        logger.info("=================== 清空购物车 ");
        try {
            cartService.clearCart(uid);
        } catch (Exception e) {
            logger.error("=================== 清空购物车失败：" + e);
        }
        return map;
    }

    /**
     * 查询某个用户的购物车
     * queryUserCart?uid=1
     *
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping("queryUserCart")
    public Map<String, Object> queryUserCart(int uid) {
        Map<String, Object> map = new HashMap<>();
        logger.info("=================== 查询某个用户的购物车 ");
        try {
            List<Cart> carts = cartService.queryCartByUid(uid);
            map.put("carts", carts);
            List<Book> books = new ArrayList<>();
            for (Cart cart : carts) {
                Book book = bookService.queryBookByISBN(cart.getBk_ISBN());
                books.add(book);
            }
            map.put("books", books);
            logger.info("=================== carts info : " + carts);
        } catch (Exception e) {
            logger.error("=================== 查询购物车失败：" + e);
        }
        return map;
    }

    /**
     * 删除某个购物车
     * deleteCart?id=1
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteCart")
    public boolean deleteCart(int id) {
        logger.info("=================== 删除某个购物车 ");
        try {
            cartService.deleteCart(id);
            logger.info("=================== 删除某个购物车成功");
        } catch (Exception e) {
            logger.error("=================== 删除某个购物车失败：" + e);
            return false;
        }
        return true;
    }
}
