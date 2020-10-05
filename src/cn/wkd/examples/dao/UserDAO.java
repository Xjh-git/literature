package cn.wkd.examples.dao;

import cn.wkd.examples.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 许佳华
 * @Description:
 * @date 2020/3/12 17:30
 */
@Repository
public interface UserDAO {

    /**
     * 通过 uid 查询 user 信息
     * @param uid
     * @return
     */
    public User queryUserByUid(int uid);

    /**
     * 新增一个用户
     * @param user
     */
    public void addUser(User user);

    /**
     * 查询 user 信息,限定查询的条数
     * @param limit
     * @return
     */
    public List<User> queryUserLimit(int limit);
}
