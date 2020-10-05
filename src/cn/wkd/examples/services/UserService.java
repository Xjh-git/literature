package cn.wkd.examples.services;

import cn.wkd.examples.dao.UserDAO;
import cn.wkd.examples.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 许佳华
 * @Description:
 * @date 2020/3/12 17:35
 */
@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    /**
     * 通过 uid 查询 user 信息
     * @param uid
     * @return
     */
    public User queryUserByUid(int uid){
        return userDAO.queryUserByUid(uid);
    }

    /**
     * 查询 user 信息,限定查询的条数
     * @param limit
     * @return
     */
    public List<User> queryUserLimit(int limit){
        return userDAO.queryUserLimit(limit);
    }

}
