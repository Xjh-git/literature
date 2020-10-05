package cn.wkd.examples.domain;

/**
 * @author 许佳华
 * @Description: 用户的搜索历史
 * @date 2020/3/12 21:05
 */
public class SearchHistory {
    private int id;
    private int uid; //搜索记录的用户id
    private String search; //搜索记录的内容
    private String sTime; //搜索的时间

    public SearchHistory() {
    }

    @Override
    public String toString() {
        return "SearchHistory{" +
                "id=" + id +
                ", uid=" + uid +
                ", search='" + search + '\'' +
                ", sTime='" + sTime + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }
}
