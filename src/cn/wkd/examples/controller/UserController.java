package cn.wkd.examples.controller;

import cn.wkd.examples.domain.User;
import cn.wkd.examples.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 许佳华
 * @Description: 处理所有有关用户信息的请求
 * @date 2020/3/12 17:34
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    Logger logger = Logger.getLogger(UserController.class);

    /**
     * 通过 uid 查询用户信息
     * queryUser?uid=1
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping("queryUser")
    public Map<String, Object> queryUser(int uid) {
        Map<String, Object> map = new HashMap<>();
        logger.info("======================== 通过 uid 查询用户信息");
        try {
            User user = userService.queryUserByUid(uid);
            logger.info("======================== user info : " + user);
            map.put("user", user);
        } catch (Exception e) {
            logger.error("======================== 通过 uid 查询用户信息失败：" + e);
        }
        return map;
    }

    /**
     * 查询 user 信息,限定查询的条数
     * queryUserLimit?limit=3
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("queryUserLimit")
    public Map<String, Object> queryUserLimit(int limit) {
        Map<String, Object> map = new HashMap<>();
        logger.info("======================== 查询用户信息,限定查询的条数");
        try {
            List<User> users = userService.queryUserLimit(limit);
            logger.info("======================== user info : " + users);
            map.put("users", users);
        } catch (Exception e) {
            logger.error("======================== 查询用户信息失败：" + e);
        }
        return map;
    }
}
