package com.xizi.springbootjdbctemplate.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String loginName;
    private String username;
    private String password;

    public User(String loginName, String username, String password) {
        this.loginName = loginName;
        this.username = username;
        this.password = password;
    }
}
