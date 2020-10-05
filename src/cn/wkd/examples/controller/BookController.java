package cn.wkd.examples.controller;

import cn.wkd.examples.domain.Book;
import cn.wkd.examples.services.BookService;
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
 * @Description: 处理所有有关图书信息的请求
 * @date 2020/3/12 17:04
 */

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    Logger logger = Logger.getLogger(BookController.class);

    /**
     * 查询所有图书信息
     * @return
     */
    @ResponseBody
    @RequestMapping("queryAllBook")
    public Map<String, Object> queryAllBook() {
        Map<String, Object> map = new HashMap<>();
        logger.info("=================== 查询所有图书信息");
        try {
            List<Book> books = bookService.queryAllBook();
            map.put("books", books);
            logger.info("=================== books info : " + books);
        } catch (Exception e) {
            logger.error("=================== 查询所有图书信息失败：" + e);
        }
        return map;
    }

    /**
     * 查询图书信息，限制只查询 limit 条
     * queryBook?limit=10
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("queryBook")
    public Map<String, Object> queryBook(int limit) {
        Map<String, Object> map = new HashMap<>();
        logger.info("=================== 查询图书信息，限制只查询 " + limit + "条");
        try {
            List<Book> books = bookService.queryBookLimit(limit);
            map.put("books", books);
            logger.info("=================== books info : " + books);
        } catch (Exception e) {
            logger.error("=================== 查询图书信息失败：" + e);
        }
        return map;
    }

    /**
     * 通过价格区间查询图书信息
     * queryBookByPriceInterval?start=0&end=20
     * @param start
     * @param end
     * @return
     */
    @ResponseBody
    @RequestMapping("queryBookByPriceInterval")
    public Map<String, Object> queryBookByPriceInterval(int start,int end) {
        Map<String, Object> map = new HashMap<>();
        logger.info("=================== 通过价格区间查询图书信息 ");
        try {
            List<Book> books = bookService.queryBookByPriceInterval(start,end);
            map.put("books", books);
            logger.info("=================== books info : " + books);
        } catch (Exception e) {
            logger.error("=================== 查询图书信息失败：" + e);
        }
        return map;
    }

    /**
     * 通过书名查询图书信息
     * queryBookByName?name=鲁迅诗集
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("queryBookByName")
    public Map<String, Object> queryBookByName(String name) {
        Map<String, Object> map = new HashMap<>();
        logger.info("=================== 通过书名查询图书信息 ");
        try {
            List<Book> books = bookService.queryBookByName(name);
            map.put("books", books);
            logger.info("=================== books info : " + books);
        } catch (Exception e) {
            logger.error("=================== 查询图书信息失败：" + e);
        }
        return map;
    }

    /**
     * 通过ISBN号查询图书信息
     * queryBookByISBN?isbn=9787020034789
     * @param isbn
     * @return
     */
    @ResponseBody
    @RequestMapping("queryBookByISBN")
    public Map<String, Object> queryBookByISBN(String isbn) {
        Map<String, Object> map = new HashMap<>();
        logger.info("=================== 通过ISBN号查询图书信息 ");
        try {
            Book book = bookService.queryBookByISBN(isbn);
            map.put("book", book);
            logger.info("=================== book info : " + book);
        } catch (Exception e) {
            logger.error("=================== 查询图书信息失败：" + e);
        }
        return map;
    }


}
