package com.bdqn.Service.impl;

import com.bdqn.Dao.UsersDao;
import com.bdqn.Dao.impl.UserDaoimpl;
import com.bdqn.Service.UsersService;
import com.bdqn.pojo.Page;
import com.bdqn.pojo.Users;

import java.util.List;

public class UsersServiceimpl implements UsersService {
    UsersDao usersDao=new UserDaoimpl();
    @Override
    public Users getLoginByNamePassWords(String name, String pwd) throws Exception {
        return usersDao.getLoginByNamePassWord(name,pwd);
    }

    @Override
    public List<Users> selectAlls(String name) throws Exception {
        return usersDao.selectAll(name);
    }

    @Override
    public int updatePwds(String password, String name) throws Exception {

        return usersDao.updatePwd(password,name);
    }

    @Override
    public int countPagess() throws Exception {
        return usersDao.countPages();
    }

    @Override
    public Page sellists(Integer currentPage) throws Exception {
        int pageSize=1;
        int totalRows = usersDao.countPages();
        int totalPages=totalRows%pageSize==0?totalRows/pageSize:totalRows/pageSize+1;
        int first=(currentPage-1)*pageSize;
        List<Users> sellist = usersDao.sellist(first, pageSize);
        Page pages = new Page();
        pages.setCurrentPage(currentPage);
        pages.setList(sellist);
        pages.setPageSize(pageSize);
        pages.setTotalPages(totalPages);
        pages.setTotalRows(totalRows);

        return pages;
    }
}
