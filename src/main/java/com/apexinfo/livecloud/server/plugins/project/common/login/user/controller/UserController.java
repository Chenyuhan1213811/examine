package com.apexinfo.livecloud.server.plugins.project.common.login.user.controller;


import com.apexinfo.livecloud.server.common.exporter.Response;
import com.apexinfo.livecloud.server.core.web.AbstractController;
import com.apexinfo.livecloud.server.plugins.product.sql.query.util.MD5Tools;
import com.apexinfo.livecloud.server.plugins.project.common.login.user.bean.User;
import com.apexinfo.livecloud.server.plugins.project.common.login.user.constant.CommonConstant;
import com.apexinfo.livecloud.server.plugins.project.common.login.user.constant.UserConstant;
import com.apexinfo.livecloud.server.plugins.project.common.login.user.service.UserService;
import com.apexinfo.livecloud.server.plugins.project.common.login.user.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;


/**
 * @ClassName: UserController
 * @Description:用户控制层
 * @Author chenyuhan
 * @Date 2023/12/13
 * @Version 1.0
 */
@Controller
public class UserController extends AbstractController {

    /**
     * 增加用户
     *
     * @param user
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = UserConstant.ROUTE_USER, params = CommonConstant.ACTION_ADD,
            method = RequestMethod.POST)
    @ResponseBody
    public Response addUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        setJsonResponse(request, response);
        if (user.getName() == null || user.getPassword() == null || user.getEmail() == null
            || user.getPhone() == null){
            return Response.ofFail(CommonConstant.MESSAGE_PARAMETER_ERROR);
        }
        MD5Tools md5Tools = new MD5Tools();
        String password = md5Tools.stringToMD5(user.getPassword());
        user.setPassword(password);
        return UserService.getInstance().addUser(user);
    }

    /**
     * 删除用户
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = UserConstant.ROUTE_USER, params = CommonConstant.ACTION_DELETE,
            method = RequestMethod.GET)
    @ResponseBody
    public Response deletUser(long id, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        setJsonResponse(request, response);
        if (id < 0) {
            return Response.ofFail(CommonConstant.MESSAGE_PARAMETER_ERROR);
        }
        return UserService.getInstance().deleteUser(id);
    }

    /**
     * 修改用户
     *
     * @param user
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = UserConstant.ROUTE_USER, params = CommonConstant.ACTION_UPDATE,
            method = RequestMethod.POST)
    @ResponseBody
    public Response updateUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        setJsonResponse(request, response);
        if (user.getId() < 0 || user.getName() == null || user.getPassword() == null || user.getEmail() == null
                || user.getPhone() == null){
            return Response.ofFail(CommonConstant.MESSAGE_PARAMETER_ERROR);
        }
        return UserService.getInstance().updateUser(user);
    }

    /**
     * 根据id查询用户
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = UserConstant.ROUTE_USER, params = CommonConstant.ACTION_QUERY_BY_ID,
            method = RequestMethod.GET)
    @ResponseBody
    public Response getUserById(long id, HttpServletRequest request, HttpServletResponse response) {
        setJsonResponse(request, response);
        if (id < 0) {
            return Response.ofFail(CommonConstant.MESSAGE_PARAMETER_ERROR);
        }
        return UserService.getInstance().getUserById(id);
    }

    /**
     * 分页查询用户
     *
     * @param pageNo
     * @param pageSize
     * @param keyword
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = UserConstant.ROUTE_USER, params = CommonConstant.ACTION_QUERY,
            method = RequestMethod.GET)
    @ResponseBody
    public Response getUsers(int pageNo, int pageSize, String keyword,
                             HttpServletRequest request, HttpServletResponse response) {
        setJsonResponse(request, response);
        if (pageNo < 0) {
            pageNo = 1;
        }
        if (pageSize < 0) {
            pageSize = 5;
        }
        keyword = PageUtil.wrapKeyword(keyword);
        return UserService.getInstance().getUsers(pageNo, pageSize, keyword);
    }

    /**
     * 根据用户id查询角色
     *
     * @param id
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = UserConstant.ROUTE_USER, params = UserConstant.ACTION_QUERY_ROLES_BY_USER_ID,
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryRolesByUserId(long id, HttpServletRequest request, HttpServletResponse response) {
        setJsonResponse(request, response);
        if (id < 0) {
            return Response.ofFail(CommonConstant.MESSAGE_PARAMETER_ERROR);
        }
        return UserService.getInstance().queryRolesByUserId(id);
    }
}
