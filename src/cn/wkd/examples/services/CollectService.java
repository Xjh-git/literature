package cn.wkd.examples.services;

import cn.wkd.examples.dao.CollectDao;
import cn.wkd.examples.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: literature
 * @description:收藏service
 * @author: Mr.Gao
 * @create: 2020-03-12 22:24
 **/
@Service
public class CollectService {
    @Autowired
    CollectDao collectDao;

    /**
     * @Description: 根据用户id清空用户的收藏记录
     * @Param: [uid]
     * @return: void
     * @Author: Mr.Gao
     * @Date: 2020/3/12
     */
    public void deleteCollectByUid(int uid) {
        collectDao.deleteCollectByUid(uid);
    }

    /**
     * @Description: 根据收藏id删除单个记录
     * @Param: [colletcId]
     * @return: void
     * @Author: Mr.Gao
     * @Date: 2020/3/12
     */
    public void deleteCollectByCollectId(int collect_id) {
        collectDao.deleteCollectByCollectId(collect_id);
    }

    /**
     * @Description: 根据收藏id获得对应收藏图书的信息
     * @Param: [colletcId]
     * @return: cn.wkd.examples.domain.Book
     * @Author: Mr.Gao
     * @Date: 2020/3/12
     */
    public Book getBookByCollectId(int collect_id) {
        return collectDao.getBookByCollectId(collect_id);
    }

    /**
     * @Description: 根据用户id获取所有用户收藏的图书信息
     * @Param: [uid]
     * @return: java.util.ArrayList<cn.wkd.examples.domain.Book>
     * @Author: Mr.Gao
     * @Date: 2020/3/12
     */
    public ArrayList<Book> getBooksByUid(int uid) {
        return collectDao.getBooksByUid(uid);
    }

    /**
     * @Description: 插入一条收藏记录
     * @Param:
     * @return:
     * @Author: Mr.Gao
     * @Date: 2020/3/12
     */
    public void insertCollect(String bk_ISBN, int uid) {
        collectDao.insertCollect(bk_ISBN, uid);
    }

    /**
     * 查询用户是否收藏bk_ISBN书
     * @param bk_isbn
     * @param uid
     * @return
     */
    public boolean isCollect(String bk_isbn, int uid) {
        List<Book> books = collectDao.getBooksByUid(uid);
        for (Book book : books) {
            if (book.getBk_ISBN().equals(bk_isbn)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 删除用户uid的收藏的bk_isbn
     * @param bk_isbn
     * @param uid
     */
    public void deleteCollect(String bk_isbn, int uid) {
        Map<String, Object> map = new HashMap<>();
        map.put("bk_ISBN", bk_isbn);
        map.put("uid", uid);
        collectDao.deleteCollect(map);
    }
}
