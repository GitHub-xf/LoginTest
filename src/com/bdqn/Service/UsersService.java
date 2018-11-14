package com.bdqn.Service;

import com.bdqn.pojo.Page;
import com.bdqn.pojo.Users;

import java.util.List;

public interface UsersService {
    Users getLoginByNamePassWords(String name, String pwd) throws Exception;

    List<Users> selectAlls(String name) throws Exception;

    int updatePwds(String password,String name) throws Exception;

    int countPagess() throws Exception;

    Page sellists(Integer currentPage) throws Exception;
}
