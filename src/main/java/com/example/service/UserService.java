package com.example.service;

import com.example.dao.UserDao;
import com.example.entity.User;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Adopat
 * @description 用户service层接口
 * @date 2023-07-22 11:43
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;
    public void save(User user){
        String now = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        user.setCreateTime(now);
        userDao.save(user);
    }
    public void del(Long id){
     userDao.deleteById(id);
    }
    public User findById(Long id){
        return userDao.findById(id).orElse(null);
    }
    public List<User> findAll() {
        return userDao.findAll();
    }
    public Page<User> findPage(Integer pageNum,Integer pageSize,String name){
        Sort sort = Sort.by(Sort.Direction.DESC, "create_time");
        PageRequest pageRequest = PageRequest.of(pageNum - 1, pageSize, sort);
        return userDao.findNameLike(name,pageRequest);
    }
}
