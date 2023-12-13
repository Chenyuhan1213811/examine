package com.apexinfo.livecloud.server.plugins.project.common.login.user.controller;



import com.apexinfo.livecloud.server.common.exporter.Response;
import com.apexinfo.livecloud.server.core.web.AbstractController;
import com.apexinfo.livecloud.server.plugins.project.common.login.user.bean.Employee;
import com.apexinfo.livecloud.server.plugins.project.common.login.user.mapper.EmployeeMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;



@Controller
public class UserController extends AbstractController {
    EmployeeMapper employeeMapper = new EmployeeMapper();


    @RequestMapping("/livecloud/project/user.pagex")
    @ResponseBody
    public Response getEmployee(HttpServletRequest request, HttpServletResponse response) {
        setJsonResponse(request,response);
        List<Employee> users = employeeMapper.getUsers();
        return Response.ofSuccess(users);
    }
}
