package com.bdqn.Dao;

import com.bdqn.pojo.Users;

import java.util.List;

public interface UsersDao {
    Users getLoginByNamePassWord(String name,String pwd) throws Exception;

    List<Users> selectAll(String name) throws Exception;

    int updatePwd(String password,String name) throws Exception;

    int countPages() throws Exception;

    List<Users> sellist(Integer first,Integer second) throws Exception;
}
