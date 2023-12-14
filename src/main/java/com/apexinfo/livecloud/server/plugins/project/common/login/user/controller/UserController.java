package com.apexinfo.livecloud.server.plugins.project.common.login.user.controller;


import com.apexinfo.livecloud.server.common.exception.PageException;
import com.apexinfo.livecloud.server.common.exporter.Response;
import com.apexinfo.livecloud.server.core.web.AbstractController;
import com.apexinfo.livecloud.server.plugins.project.common.login.user.bean.User;
import com.apexinfo.livecloud.server.plugins.project.common.login.user.constant.UserConstant;
import com.apexinfo.livecloud.server.plugins.project.common.login.user.service.UserService;
import oracle.jdbc.driver.T4CRowidBinder;
import org.bouncycastle.jcajce.provider.symmetric.Threefish;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import java.io.UnsupportedEncodingException;
import java.util.List;


/**
 * @ClassName: UserController
 * @Description:
 * @Author chenyuhan
 * @Date 2023/12/13
 * @Version 1.0
 */
@Controller
public class UserController extends AbstractController {


    @RequestMapping(value = UserConstant.ROUTE_USER,params = "action=query",
            method = RequestMethod.GET)
    @ResponseBody
    public Response getUsers(int pageNo,int pageSize,String keyword,
                             HttpServletRequest request, HttpServletResponse response){
        setJsonResponse(request, response);
        List<User> users = UserService.getInstance().getUsers(pageNo, pageSize, keyword);
        return Response.ofSuccess(users);
    }

    /**
     *  删除用户
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = UserConstant.ROUTE_USER, params = "action=delete",
            method = RequestMethod.GET)
    @ResponseBody
    public Response deletUser(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html; charset=UTF-8");
        try {
            String idStr = verificationParameter(request, "id", true, false);
            Long id = Long.parseLong(idStr);
            setJsonResponse(request, response);
            UserService.getInstance().deleteUser(id);
            return Response.ofSuccess("删除成功", null);
        } catch (PageException e) {
            e.printStackTrace();
            return Response.ofFail("删除失败",null);
        }
    }

    /**
     * 增加用户
     * @param user
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = UserConstant.ROUTE_USER, params = "action=add",
            method = RequestMethod.POST)
    @ResponseBody
    public Response addUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response){
        setJsonResponse(request,response);
        int count = UserService.getInstance().addUser(user);
        if (count > 0){
            return Response.ofSuccess("添加成功",null);
        }else {
            return Response.ofFail("添加失败",null);
        }
    }

    @RequestMapping(value = UserConstant.ROUTE_USER, params = "action=update",
            method = RequestMethod.POST)
    @ResponseBody
    public Response updateUser(@RequestBody User user,HttpServletRequest request,HttpServletResponse response){
        //判断影响行数
        int count = 0;
        setJsonResponse(request,response);
        count = UserService.getInstance().updateUser(user);
        if (count > 0){
            return Response.ofSuccess("修改成功",null);
        }else {
            return Response.ofFail("修改失败",null);
        }
    }

    /**
     *  根据id查询用户
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = UserConstant.ROUTE_USER, params = "action=queryById",
            method = RequestMethod.GET)
    @ResponseBody
    public Response getUserById(long id, HttpServletRequest request, HttpServletResponse response) {
            User user = new User();
            setJsonResponse(request, response);
            user = UserService.getInstance().getUserById(id);
            return Response.ofSuccess(user);
    }


}
