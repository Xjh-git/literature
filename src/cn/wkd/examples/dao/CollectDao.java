package cn.wkd.examples.dao;

import cn.wkd.examples.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Map;

/**
 * @program: literature
 * @description:
 * @author: Mr.Gao
 * @create: 2020-03-12 22:02
 **/
@Repository
public interface CollectDao {

    /**
     * @Description: 根据用户id清空用户的收藏记录
     * @Param: [uid]
     * @return: void
     * @Author: Mr.Gao
     * @Date: 2020/3/12
     */
    void deleteCollectByUid(int uid);

    /**
     * @Description: 根据收藏id删除单个记录
     * @Param: [colletcId]
     * @return: void
     * @Author: Mr.Gao
     * @Date: 2020/3/12
     */
    void deleteCollectByCollectId(int collect_id);

    /**
     * @Description: 根据收藏id获得对应收藏图书的信息
     * @Param: [colletcId]
     * @return: cn.wkd.examples.domain.Book
     * @Author: Mr.Gao
     * @Date: 2020/3/12
     */
    Book getBookByCollectId(int collect_id);

    /**
     * @Description: 根据用户id获取所有用户收藏的图书信息
     * @Param: [uid]
     * @return: java.util.ArrayList<cn.wkd.examples.domain.Book>
     * @Author: Mr.Gao
     * @Date: 2020/3/12
     */
    ArrayList<Book> getBooksByUid(int uid);

    /**
     * @Description: 插入一条收藏记录
     * @Param:
     * @return:
     * @Author: Mr.Gao
     * @Date: 2020/3/12
     */
    void insertCollect(String bk_ISBN, int uid);

    /**
     * 删除收藏记录
     * @param map {"bk_ISBN",bk_ISBN} {"uid",uid}
     */
    void deleteCollect(Map<String,Object> map);
}
