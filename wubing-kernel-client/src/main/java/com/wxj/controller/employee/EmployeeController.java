package com.wxj.controller.employee;

import com.wxj.domain.dto.employee.EmployeeAddDto;
import com.wxj.domain.dto.employee.EmployeeConditionDto;
import com.wxj.domain.dto.employee.EmployeeModifyDto;
import com.wxj.domain.entity.Employee;
import com.wxj.domain.vo.employee.EmployeeVo;
import com.wxj.service.EmployeeService;
import com.wxj.util.PageUtils;
import com.wxj.util.ResultObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * <p>@ClassName: EmployeeController<p>
 * <p>@Description: TODO 员工管理controller<p>
 * <p> @author: wxj<p>
 * <p>@date: 2018-12-26 21:35<p>
 * <p>@Tel:18772118541<p>
 * <p>@email:18772118541@163.com<p>
 */
@RestController
@RequestMapping(value = "/employee")
@Api(tags = "员工相关")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    /**
     * <p>@Title: query  <p>
     * <p>@Description: TODO 员工查询<p>
     * <p>@param page<p>
     * <p>@param employee<p>
     * <p>@return   <p>
     * <p>@date:2019-01-01 12:10<p>
     */
    @ApiOperation(value = "员工查询")
//    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @PostMapping(value = "/query")
    public ResultObject query(EmployeeConditionDto condition) {
        final PageUtils<EmployeeVo> page = employeeService.queryByPage(condition);
        ResultObject result = new ResultObject(page);
        return result;
    }

    /**
     * <p> @Title: add  </p>
     * <p>@Description: TODO 员工添加</p>
     * <p>@param page</p>
     * <p>@param employee</p>
     * <p> @return   </p>
     * <p>@date:2019-01-01 12:12</p>
     */
    @ApiOperation(value = "员工添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject add(EmployeeAddDto employee) {
        ResultObject result = new ResultObject(employeeService.add(employee));
        return result;
    }

    /**
     * <p>@Title: modify  </p>
     * <p>@Description: TODO 员工信息更新</p>
     * <p>@param employee</p>
     * <p>@return   </p>
     * <p>@date:2019-01-01 15:46</p>
     */
    @ApiOperation(value = "员工信息更新")
    @RequestMapping(value = "/modify", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject modify(EmployeeModifyDto employee) {
        employeeService.modify(employee);
        return new ResultObject();
    }

    /**
     * <p>@Title: verifyID  </p>
     * <p>@Description: TODO 校验是否有重复的身份证号</p>
     * <p>@return   </p>
     * <p>@date:2019-01-20 18:29</p>
     */
    @ApiOperation(value = "校验是否有重复的身份证号")
    @RequestMapping(value = "/verifyID", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject verifyID(String identity) {
        boolean flg = employeeService.verifyID(identity);
        return new ResultObject(flg);
    }

    /**
     * <p>@Title: login  </p>
     * <p>@Description: TODO 登录</p>
     * <p>@param employee</p>
     * <p>@return   </p>
     * <p>@date:2019-03-07 15:35</p>
     */
    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject login(Employee employee, HttpSession session) {
        boolean flg = employeeService.login(employee,session);
        return new ResultObject(flg);
    }

    /**
     * <p>@Title: resetPassowrd  </p>
     * <p>@Description: TODO 重置密码</p>
     * <p>@param employee</p>
     * <p>@return   </p>
     * <p>@date:2019-03-07 15:50</p>
     */
    @ApiOperation(value = "重置密码")
    @RequestMapping(value = "/resetPassowrd", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject resetPassowrd(Employee employee) {
        boolean flg = employeeService.resetPassowrd(employee);
        return new ResultObject(flg);
    }

    /**
     * <p>@Title: mofifyPassword  </p>
     * <p>@Description: TODO 修改密码</p>
     * <p>@param employee</p>
     * <p>@return   </p>
     * <p>@date:2019-03-07 16:07</p>
     */
    @ApiOperation(value = "修改密码")
    @RequestMapping(value = "/mofifyPassword", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject mofifyPassword(Employee employee, String newPassword) {
        ResultObject result = new ResultObject();
        boolean flg;
        try {
            flg = employeeService.mofifyPassword(employee, newPassword);
            result.setObj(flg);
        } catch (Exception e) {
            result.setObj(e.getMessage());
        }
        return result;
    }

    /**
     * <p>@Title: queryEmployeeById  </p>
     * <p>@Description: TODO 根据id查询员工信息</p>
     * <p>@param id</p>
     * <p>@return </p>
     * <p>@date:2019-05-16 09:55</p>
     */
    @ApiOperation(value = "根据id查询员工信息")
    @RequestMapping(value = "/queryEmpById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject queryEmployeeById(String id) {
        ResultObject result = new ResultObject();
        Employee employee = employeeService.queryById(id);
        result.setObj(employee);
        return result;
    }

    @ApiOperation(value = "删除员工信息")
    @RequestMapping(value = "/remove", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject remove(String id) {
        ResultObject result = new ResultObject();
        int i = employeeService.remove(id);
        result.setObj(i);
        return result;
    }
}
