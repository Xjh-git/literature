package cn.wkd.examples.controller;

import cn.wkd.examples.domain.SearchHistory;
import cn.wkd.examples.domain.User;
import cn.wkd.examples.services.SearchHistoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 许佳华
 * @Description:
 * @date 2020/3/12 21:11
 */
@Controller
public class SearchHistoryController {
    @Autowired
    SearchHistoryService searchHistoryService;
    Logger logger = Logger.getLogger(UserController.class);

    /**
     * 查询用户搜索记录
     * querySearchHistory?uid=1
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping("querySearchHistory")
    public Map<String,Object> querySearchHistoryByUid(int uid){
        Map<String,Object> map = new HashMap<>();
        logger.info("======================== 查询用户搜索记录");
        try {
            List<SearchHistory> searchHistories = searchHistoryService.querySearchHistoryByUid(uid);
            logger.info("======================== searchHistories info : " + searchHistories);
            map.put("searchHistories", searchHistories);
        } catch (Exception e) {
            logger.error("======================== 查询用户搜索记录失败：" + e);
        }
        return map;
    }

    /**
     * 清空用户搜索记录
     * clearSearchHistory?uid=1
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping("clearSearchHistory")
    public Map<String,Object> clearSearchHistoryByUid(int uid){
        Map<String,Object> map = new HashMap<>();
        logger.info("======================== 清空用户搜索记录");
        try {
            searchHistoryService.clearSearchHistoryByUid(uid);
            map.put("success",true);
        } catch (Exception e) {
            logger.error("======================== 清空用户搜索记录失败：" + e);
        }
        return map;
    }

    /**
     * 添加用户搜索记录
     * addSearchHistory?uid=1&search=鲁迅诗集
     * @param uid
     * @param search
     * @return
     */
    @ResponseBody
    @RequestMapping("addSearchHistory")
    public Map<String,Object> addSearchHistory(int uid,String search){
        Map<String,Object> map = new HashMap<>();
        logger.info("======================== 添加用户搜索记录");
        try {
            SearchHistory searchHistory = new SearchHistory();
            searchHistory.setUid(uid);
            searchHistory.setSearch(search);
            searchHistory.setsTime(LocalDateTime.now().toString());
            searchHistoryService.addSearchHistory(searchHistory);
            map.put("success",true);
        } catch (Exception e) {
            logger.error("======================== 添加用户搜索记录失败：" + e);
        }
        return map;
    }
}
