package cn.wkd.examples.services;

import cn.wkd.examples.dao.SearchHistoryDAO;
import cn.wkd.examples.domain.SearchHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 许佳华
 * @Description:
 * @date 2020/3/12 21:10
 */
@Service
public class SearchHistoryService {
    @Autowired
    SearchHistoryDAO searchHistoryDAO;

    /**
     * 通过 uid 查询搜索历史，即查询某个用户的搜索历史
     * @param uid
     * @return
     */
    public List<SearchHistory> querySearchHistoryByUid(int uid) {
        return searchHistoryDAO.querySearchHistoryByUid(uid);
    }

    /**
     * 通过 uid 清空搜索历史，即清空某个用户的搜索历史
     * @param uid
     * @return
     */
    public void clearSearchHistoryByUid(int uid) {
        searchHistoryDAO.clearSearchHistoryByUid(uid);
    }

    /**
     * 添加用户的搜索记录
     * @param searchHistory
     */
    public void addSearchHistory(SearchHistory searchHistory){
        searchHistoryDAO.addSearchHistory(searchHistory);
    }
}
