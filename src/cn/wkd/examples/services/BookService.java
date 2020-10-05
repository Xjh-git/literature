package cn.wkd.examples.services;

import cn.wkd.examples.dao.BookDAO;
import cn.wkd.examples.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 许佳华
 * @Description:
 * @date 2020/3/12 17:04
 */
@Service
public class BookService {
    @Autowired
    BookDAO bookDAO;

    public List<Book> queryAllBook() {
        return bookDAO.queryAllBook();
    }

    /**
     * 查询图书,通过limit限制数量
     * @return
     */
    public List<Book> queryBookLimit(int limit) {
        return bookDAO.queryBookLimit(limit);
    }

    /**
     * 通过价格区间查询图书，区间[start,end]
     * @param start
     * @param end
     * @return
     */
    public List<Book> queryBookByPriceInterval(double start, double end) {
        Map<String, Object> map = new HashMap<>();
        map.put("start", start);
        map.put("end", end);
        return bookDAO.queryBookByPriceInterval(map);
    }

    /**
     * 根据图书名查询图书
     * @param name
     * @return
     */
    public List<Book> queryBookByName(String name){
        Map<String, Object> map = new HashMap<>();
        if('"' == name.charAt(0)){
            name = name.substring(1,name.length()-1);
        }
        map.put("name", name);
        return bookDAO.queryBookByParams(map);
    }

    /**
     * 根据图书号查询图书
     * @param isbn
     * @return
     */
    public Book queryBookByISBN(String isbn){
        Map<String, Object> map = new HashMap<>();
        map.put("isbn",isbn);
        List<Book> books = bookDAO.queryBookByParams(map);
        if (books.size()>0){
            return books.get(0);
        }
        return null;
    }
}
