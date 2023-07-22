package com.example.controller;

import com.example.common.Result;
import com.example.entity.User;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Adopat
 * @description 用户增删改查接口
 * @date 2023-07-22 12:13
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理模块") //修饰整个类，进行描述
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 增加用户接口
     * @param user
     * @return
     */
    @PostMapping
    @ApiOperation(value = "增加用户信息",notes = "增加用户信息")
    public Result add(@RequestBody User user) {
        userService.save(user);
        return Result.success();
    }

    /**
     * 更改用户信息接口
     * @param user
     * @return
     */
    @PutMapping
    @ApiOperation(value = "更改用户信息",notes = "更改用户信息")
    public Result update(@RequestBody User user) {
        userService.save(user);
        return Result.success();
    }

    /**
     * 根据id删除用户信息接口
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除用户信息",notes = "根据id删除用户信息")
    public Result delete(@PathVariable Long id) {
        userService.del(id);
        return Result.success();
    }

    /**
     * 根据id查询用户信息接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询用户信息",notes = "根据id查询用户信息")
    public Result<User> findById(@PathVariable Long id) {
        return Result.success(userService.findById(id));

    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping
    @ApiOperation(value = "不分页查询所有用户信息",notes = "不分页查询所有用户信息")
    public Result<List<User>> findAll() {
        return Result.success(userService.findAll());
    }

    /**
     * 用户信息分页查询
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页查询用户信息",notes = "分页查询用户信息")
    public Result<Page<User>> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                       @RequestParam(required = false) String name) {
        return Result.success(userService.findPage(pageNum, pageSize, name));

    }


}
