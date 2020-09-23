package com.dw.sms.controller;

import com.dw.sms.entity.User;
import com.dw.sms.service.UserService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dw.sms.result.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dw.sms.result.ResultGenerator;

/**
 * @program:
 * @description: 用户接口
 * @author: dingwen
 * @create: 2020/9/23 10:52
 **/
@Api("用户接口")
@RestController
@Slf4j
public class UserController {
    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    /*
     *查询单个用户信息
     * @param [id]
     * @return com.dw.sms.result.Result
     */
    @ApiOperation(value = "查询单个用户信息",notes = "根据userId获取")
    //value是描述信息
    @ApiImplicitParam(name = "userId",value = "用户ID",required = true,dataType = "Long")
    @GetMapping("/users/{userId}")
    public Result findById(@PathVariable("userId") Long userId) {
        return ResultGenerator.genOkResult(userService.findById(userId));
    }

    /*
     *查询所有用户信息
     * @param []
     * @return com.dw.sms.result.Result
     */
    @ApiOperation(value = "查询所有用户信息")
    @GetMapping("/users")
    public Result findAll() {
        log.debug("查询所有用户信息，debug测试");
        log.info("查询所有用户信息，debug测试");
        return ResultGenerator.genOkResult(userService.findAll());
    }

    /*
     *条件查询
     * 通过@PathVariable，例如/blogs/1通过@RequestParam，例如blogs?blogId=1
     * 1、当URL指向的是某一具体业务资源（或资源列表），例如博客，用户时，使用@PathVariable
     * 2、当URL需要对资源或者资源列表进行过滤，筛选时，用@RequestParam
     * required = false 表示可以不传
     * @param [user]
     * @return com.dw.sms.result.Result
     */
    @ApiOperation(value = "查询符合条件的用户返回")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名",required = false,dataType = "String"),
            @ApiImplicitParam(name = "age",value = "年龄",required = false,dataType = "Integer")
    })
    @PostMapping("/users/query")
    public Result queryCondition(@RequestParam(value = "username", required = false) String username,
                                 @RequestParam(value = "age", required = false) Integer age) {
        return ResultGenerator.genOkResult(userService.queryCondition(username, age));
    }

    /*
     *users 分页查询
     * @param [pageNum, pageSize, order]
     * @return com.dw.sms.result.Result
     */
    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "页码数",required = true,dataType = "int"),
            @ApiImplicitParam(name ="pageSize",value = "每一页查询多少条数据",required = true,dataType = "int"),
            @ApiImplicitParam(name = "order",value = "降序ASC升序DESC")
    })
    @GetMapping("users/findByPaging")
    public Result findByPaging(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @RequestParam("order") String order) {
        //使用分页插件
        PageHelper.startPage(pageNum, pageSize);
        Map params = new HashMap();
        params.put("order", order);
        return ResultGenerator.genOkResult(userService.findByPaging(params));
    }

    /*
     *查询总记录条数
     * @param []
     * @return com.dw.sms.result.Result
     */
    @ApiOperation(value = "查询总记录条数")
    @GetMapping("/users/totalNumber")
    public Result findTotalNum() {
        return ResultGenerator.genOkResult(String.valueOf((userService.findAll().size())));
    }

    /*
     *添加用户
     * @param [user]
     * @return com.dw.sms.result.Result 添加成功的用户对象
     */
    @ApiOperation(value = "添加用户信息")
    @ApiImplicitParam(value = "用户对象",name = "user",required = true,dataType = "com.dw.sms.entity.User")
    @PostMapping("/users")
    public Result add(@RequestBody User user) {
        return ResultGenerator.genOkResult(userService.add(user));
    }

    /*
     *删除用户
     * @param [userId]
     * @return int
     */
    @ApiOperation("删除用户信息")
    @ApiImplicitParam(name = "userId",value = "用户ID")
    @DeleteMapping("/users/{userId}")
    public Result delete(@PathVariable("userId") Long userId) {
        return ResultGenerator.genOkResult(userService.delete(userId));
    }

    /*
     *修改用户
     * @param [user]
     * @return com.dw.sms.result.Result 修改成功的用户对象
     */
    @ApiOperation("修改用户信息")
    @ApiParam(name = "user",value = "用户对象")
    @PutMapping("/users")
    public Result update(@RequestBody User user) {
        return ResultGenerator.genOkResult(userService.update(user));
    }
}
