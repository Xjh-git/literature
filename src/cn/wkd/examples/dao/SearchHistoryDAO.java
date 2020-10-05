package cn.wkd.examples.dao;

import cn.wkd.examples.domain.SearchHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 许佳华
 * @Description:
 * @date 2020/3/12 21:07
 */
@Repository
public interface SearchHistoryDAO {

    /**
     * 通过 uid 查询搜索历史，即查询某个用户的搜索历史
     * @param uid
     * @return
     */
    public List<SearchHistory> querySearchHistoryByUid(int uid);

    /**
     * 通过 uid 清空搜索历史，即清空某个用户的搜索历史
     * @param uid
     * @return
     */
    public void clearSearchHistoryByUid(int uid);

    /**
     * 添加用户的搜索记录
     * @param searchHistory
     */
    public void addSearchHistory(SearchHistory searchHistory);
}
