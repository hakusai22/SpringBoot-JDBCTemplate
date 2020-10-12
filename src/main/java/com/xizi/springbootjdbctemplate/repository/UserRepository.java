package com.xizi.springbootjdbctemplate.repository;

import com.xizi.springbootjdbctemplate.pojo.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @Repository注解：标注这是一个持久化操作对象
 */
@Repository
public class UserRepository {

    //注入JdbcTemplate模板对象
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 插入数据
     * @return 插入影响的行数
     */
    public Integer insertUser(){
        String sql = "insert into tb_user(login_name, username, password) values(?, ?, ?), (?, ?, ?)";
        Object args[] = new Object[]{"戏子", "admin", "123456", "戏子2", "123456", "123456"};
        //参数一：插入数据的SQL语句，参数二：对应SQL语句中占位符？的参数
        return jdbcTemplate.update(sql, args);
    }

    /***
     * 根据userName查询数据
     * @param username
     * @return User对象
     */
    public User selectByUsername(String username){
        //定义SQL语句
        String sql = "select * from tb_user where username = ?";
        //定义一个RowMapper
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        //执行查询方法
        User user = jdbcTemplate.queryForObject(sql, new Object[]{username}, rowMapper);
        return user;
    }

    /**
     * 根据id查询数据
     * @param id
     * @return User对象
     */
    public User findUserById(Integer id){
        //定义SQL语句
        String sql = "select * from tb_user where id = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        //执行查询方法
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    /**
     * 查询所有数据
     * @return 包含User对象的List集合
     */
    public List<User> findAll(){
        //定义SQL语句
        String sql = "select * from tb_user";
        //声明结果集的映射rowMapper,将结果集的数据映射成User对象数据
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    /**
     * 根据id删除数据
     * @param id
     */
    public void delete(final Integer id){
        //定义SQL语句
        String sql = "delete from tb_user where id=?";
        //执行
        jdbcTemplate.update(sql, new Object[]{id});
    }

    /**
     * 修改数据
     * @param user
     */
    public void update(final User user){
        //定义SQL语句
        String sql = "update tb_user set username=?, login_name=? where id=?";
        //执行
        jdbcTemplate.update(sql, new Object[]{user.getUsername(),user.getLoginName(), user.getId()});
    }


}

