package com.ycf.controller;

import com.ycf.model.User;
import com.ycf.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/redisTest")
    public String redisTest(){
        //redisUtils.set("today","Friday");

        /*redisUtils.zadd("company","阿里",80);
        redisUtils.zadd("company","腾讯",90);
        redisUtils.zadd("company","各种银行",40);
        redisUtils.zadd("company","字节",85);
        redisUtils.zadd("company","shopee",80);*/

        Set<String> resultSet = redisUtils.zrange("company", 0, 10);
        System.out.println(resultSet);
        return "redisTest";
    }

    @GetMapping("/mysqlTest")
    public String mysqlTest(){
        String sql = "select * from `user`";
        List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                return user;
            }
        });
        return "mysqlTest";
    }

    //这里ycf' or 1=1 or name = 'c就可以进行sql注入查出全表的数据
    @GetMapping("/sqlInjectTest/{name}")
    public String sqlInjectTest(@PathVariable String name) {
        String sql = "select * from `user` where `name` = '" + name + "'";
        List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                return user;
            }
        });
        return userList.toString();
    }

}
