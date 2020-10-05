package cn.wkd.examples.dao;


import cn.wkd.examples.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 许佳华
 * @Description: 操作book表的接口
 * @date 2020/3/11 23:38
 */
@Repository
public interface BookDAO {
    /**
     * 查询所有图书
     * @return
     */
    public List<Book> queryAllBook();

    /**
     * 查询图书,通过limit限制数量
     * @return
     */
    public List<Book> queryBookLimit(int limit);

    /**
     * 根据动态的查询条件查询图书
     * @param map
     * @return
     */
    public List<Book> queryBookByParams(Map<String, Object> map);

    /**
     * 通过价格区间查询图书，区间[start,end]
     * @param map   map {"start",start} {"end",end}
     * @return
     */
    public List<Book> queryBookByPriceInterval(Map<String,Object> map);
    /**
     * 将图书信息保存到数据库
     * @param book
     */
    public void addBook(Book book);

    /**
     * 修改图书信息
     * @param book
     */
    public void editBook(Book book);

    /**
     * 通过isbn号删除图书信息
     * @param isbn
     */
    public void deleteBook(String isbn);
}
