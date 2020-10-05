package cn.wkd.examples.controller;

import cn.wkd.examples.domain.Book;
import cn.wkd.examples.domain.User;
import cn.wkd.examples.services.CollectService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: literature
 * @description:
 * @author: Mr.Gao
 * @create: 2020-03-12 22:46
 **/
@Controller
public class CollectController {
    @Autowired
    CollectService collectService;
    Logger logger = Logger.getLogger(CollectController.class);

    /**
     * @Description: 清空收藏
     * @Param: [uid]
     * @return: java.lang.Boolean
     * @Author: Mr.Gao
     * @Date: 2020/3/12
     */
    @ResponseBody
    @RequestMapping("deleteCollectByUid")
    public Boolean deleteCollectByUid(int uid) {

        logger.info("======================== 清空收藏");
        try {
            collectService.deleteCollectByUid(uid);
            logger.info("======================== 清空成功");
        } catch (Exception e) {
            logger.error("======================== 通过 uid 清空失败：" + e);
            return false;
        }
        return true;
    }

    /**
     * @Description: 删除收藏
     * @Param: [Collect_id]
     * @return: java.lang.Boolean
     * @Author: Mr.Gao
     * @Date: 2020/3/12
     */
    @ResponseBody
    @RequestMapping("deleteCollectByCollectId")
    public Boolean deleteCollectByCollectId(int collect_id) {

        logger.info("======================== 删除收藏");
        try {
            collectService.deleteCollectByCollectId(collect_id);
            logger.info("======================== 删除成功");
        } catch (Exception e) {
            logger.error("======================== 通过 Collect_id 删除失败：" + e);
            return false;
        }
        return true;
    }

    /**
     * @Description: 删除收藏
     * @Param: [Collect_id]
     * @return: java.lang.Boolean
     * @Author: Mr.Gao
     * @Date: 2020/3/12
     */
    @ResponseBody
    @RequestMapping("deleteCollect")
    public Boolean deleteCollect(String bk_ISBN, int uid) {
        logger.info("======================== 删除收藏");
        try {
            collectService.deleteCollect(bk_ISBN, uid);
            logger.info("======================== 删除成功");
        } catch (Exception e) {
            logger.error("======================== 通过 bk_ISBN 和 uid 删除失败：" + e);
            return false;
        }
        return true;
    }

    /**
     * @Description: 通过收藏id获取图书信息
     * @Param: [collect_id]
     * @return: java.util.HashMap<java.lang.String       ,       java.lang.Object>
     * @Author: Mr.Gao
     * @Date: 2020/3/12
     */
    @ResponseBody
    @RequestMapping("getBookByCollectId")
    public HashMap<String, Object> getBookByCollectId(int collect_id) {
        HashMap<String, Object> map = new HashMap<>();
        logger.info("======================== 获取图书信息");
        try {
            Book book = collectService.getBookByCollectId(collect_id);
            map.put("book", book);
            logger.info("======================== 获取成功");
        } catch (Exception e) {
            logger.error("======================== 获取失败：" + e);
            map.put("err", "err");
            return map;
        }
        return map;
    }

    /**
     * @Description: 通过用户id获取图书信息
     * @Param: [collect_id]
     * @return: java.util.HashMap<java.lang.String   ,   java.lang.Object>
     * @Author: Mr.Gao
     * @Date: 2020/3/12
     */
    @ResponseBody
    @RequestMapping("getBooksByUid")
    public Map<String, Object> getBooksByUid(int uid) {
        HashMap<String, Object> map = new HashMap<>();
        logger.info("======================== 获取图书信息");
        try {
            ArrayList<Book> books = collectService.getBooksByUid(uid);
            map.put("books", books);
            logger.info("======================== 获取成功:" + books);
        } catch (Exception e) {
            logger.error("======================== 获取失败：" + e);
            map.put("err", "err");
            return map;
        }
        return map;
    }

    /**
     * @Description: 插入收藏信息
     * @Param: [bk_ISBN, uid]
     * @return: java.lang.Boolean
     * @Author: Mr.Gao
     * @Date: 2020/3/12
     */
    @ResponseBody
    @RequestMapping("insertCollect")
    public Boolean insertCollect(String bk_ISBN, int uid) {
        logger.info("======================== 插入收藏信息");
        try {
            collectService.insertCollect(bk_ISBN, uid);
            logger.info("======================== 插入成功");
        } catch (Exception e) {
            logger.error("=======================  插入失败：" + e);
            return false;
        }
        return true;
    }

    @ResponseBody
    @RequestMapping("isCollect")
    public Boolean isCollect(String bk_ISBN, int uid) {
        boolean collect;
        logger.info("======================== 查询改图书是否被收藏");
        try {
            collect = collectService.isCollect(bk_ISBN, uid);
            logger.info("======================== 查询成功");
        } catch (Exception e) {
            logger.error("=======================  查询失败：" + e);
            return false;
        }
        return collect;
    }
}
