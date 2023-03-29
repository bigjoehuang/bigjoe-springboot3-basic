package org.bigjoe.demo;

import java.util.List;

import org.bigjoe.demo.entity.User;
import org.bigjoe.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppMain.class)
public class TestSpringDataJpa {

    @Autowired
    UserService userService;

    /**
     * 新增的方法
     */
    @Test
    public void test01(){
        User user = new User();
        user.setUsername("kobe");
        user.setPassword("kobe24");
        user.setTelephone("13333333333");
        userService.addUser(user);
    }

    /**
     * 根据id查询的方法
     */
    @Test
    public void test02(){
        User user = userService.findUserById(1);
        System.out.println(user);
    }

    /**
     * 修改的方法
     */
    @Test
    public void test03(){
        User user = new User();
        user.setPassword("admin");
        user.setUsername("Mourinho");
        user.setTelephone("16666567890");
        userService.updateUser(user);
    }

    /**
     * 查询所有数据的方法
     */
    @Test
    public void test04(){
        List<User> userList = userService.findAll();
        userList.forEach(user->{
            System.out.println(user);
        });
    }

    @Test
    public void test05(){
        userService.deleteUserById(3);
    }
}