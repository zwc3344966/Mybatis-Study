package com.zwc.dao;

import com.zwc.pojo.User;
import com.zwc.utils.BaseDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author: zhangwch
 * @create: 2020-05-17 21:45
 **/
public class UserDaoTest {

    @Test
    public void test() {
        // 第一步：获取sqlSession对象
        SqlSession sqlSession = BaseDao.getSqlSession();


        // 第一种方式（推荐）
         UserDao userDao = sqlSession.getMapper(UserDao.class);
         List<User> userList = userDao.getUserList();

        // 第二种方法（不推荐）
        // List<User> userList = sqlSession.selectList("com.zwc.dao.UserDao.getUserList");

        // 开启日志后关闭打印
//        for (User user: userList) {
//            System.out.println("id:" + user.getId() + "; name" + user.getName() + "; pwd:" + user.getPassword());
//        }


        // 关闭sqlSession
        sqlSession.close();
    }
}
