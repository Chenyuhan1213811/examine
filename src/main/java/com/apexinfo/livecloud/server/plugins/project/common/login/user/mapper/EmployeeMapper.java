package com.apexinfo.livecloud.server.plugins.project.common.login.user.mapper;

import com.apex.util.ApexDao;
import com.apex.util.ApexRowSet;
import com.apexinfo.livecloud.server.core.GeneralMapper;
import com.apexinfo.livecloud.server.plugins.project.common.login.user.bean.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper extends GeneralMapper {


    public List<Employee> getUsers() {
        List<Employee> employees = new ArrayList<>();
        try {
            String sql = "select ID, FNO, FDept from t_hr_employee";
            ApexDao dao = new ApexDao();
            dao.prepareStatement(sql);
            ApexRowSet rs = dao.getRowSet(getDataSource());
            while (rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getInt("ID"));
                employee.setfNo(rs.getString("FNO"));
                employee.setfDept(rs.getInt("FDept"));
                employees.add(employee);
                System.out.println(employees);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

}
