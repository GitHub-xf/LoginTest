package com.bdqn.Dao.impl;

import com.bdqn.Dao.BaseDao;
import com.bdqn.Dao.UsersDao;
import com.bdqn.pojo.Users;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoimpl extends BaseDao implements UsersDao {
    @Override
    public Users getLoginByNamePassWord(String name, String pwd) throws Exception {
        String sql="select * from Users where name=? and password=?";
        Object[] pram={name,pwd};
        ResultSet rs = selall(sql, pram);
        Users users=null;
        while (rs.next()){
            users=new Users();
            users.setName(rs.getString("name"));
            users.setPassword(rs.getString("password"));
            users.setStatus(rs.getInt("status"));
        }
        return users;
    }

    @Override
    public List<Users> selectAll(String name) throws Exception {
        String sql="select * from Users where name like '%"+name+"%'";
        ResultSet rs = selall(sql);
        List<Users> list=new ArrayList<>();
        while (rs.next()){
            Users users = new Users();
            users.setId(rs.getInt("id"));
            users.setName(rs.getString("name"));
            users.setPassword(rs.getString("password"));
            users.setStatus(rs.getInt("status"));
            users.setTime(rs.getDate("last_modify_time"));
            users.setType_id(rs.getInt("type_id"));
            list.add(users);
        }
        return list;
    }

    @Override
    public int updatePwd(String password,String name) throws Exception {
        String sql="update users set password=? where name=?";
        Object[] pram={password,name};
        int i = updatesql(sql, pram);
        return i;
    }

    @Override
    public int countPages() throws Exception {
        String sql="select count(*) count from users";
        ResultSet rs = selall(sql);
        while (rs.next()) {
            return rs.getInt("count");
        }
        return 0;
    }

    @Override
    public List<Users> sellist(Integer first, Integer second) throws Exception {
        String sql="select * from users limit ?,?";
        ResultSet rs = selall(sql, first, second);
        List<Users> list=new ArrayList<>();
        while (rs.next()){
            Users users = new Users();
            users.setId(rs.getInt("id"));
            users.setName(rs.getString("name"));
            users.setPassword(rs.getString("password"));
            users.setStatus(rs.getInt("status"));
            users.setTime(rs.getDate("last_modify_time"));
            users.setType_id(rs.getInt("type_id"));
            list.add(users);
        }
        return list;
    }
}
