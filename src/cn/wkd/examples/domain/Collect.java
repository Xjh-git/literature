package cn.wkd.examples.domain;

/**
 * @program: literature
 * @description:收藏
 * @author: Mr.Gao
 * @create: 2020-03-12 22:08
 **/
public class Collect {

    int collect_id;//收藏id
    String bk_ISBN;//图书编号
    int uid;//用户编号

    public int getCollect_id() {
        return collect_id;
    }

    public void setCollect_id(int collect_id) {
        this.collect_id = collect_id;
    }

    public String getBk_ISBN() {
        return bk_ISBN;
    }

    public void setBk_ISBN(String bk_ISBN) {
        this.bk_ISBN = bk_ISBN;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
