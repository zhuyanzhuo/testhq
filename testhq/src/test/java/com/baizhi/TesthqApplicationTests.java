package com.baizhi;

import com.baizhi.dao.UserMapper;
import com.baizhi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TesthqApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSelect(){
        /*List<User> users = userMapper.selectAll();
        users.forEach(user -> System.out.println(user));*/
        User user = userMapper.selectByPrimaryKey("660b05a6-56f6-4784-82dc-95fc80819ef1");
        System.out.println(user);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("张三");
        user.setAge(23);
        user.setBir(new Date());
        userMapper.insert(user);
    }

    @Test
    public void testUpdate(){
        userMapper.updateByPrimaryKeySelective(new User("660b05a6-56f6-4784-82dc-95fc80819ef1",null,25,null));
    }

    @Test
    public void testDelete(){
        userMapper.deleteByPrimaryKey("660b05a6-56f6-4784-82dc-95fc80819ef1");
    }
}
