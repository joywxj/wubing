package com.wxj.controller.work;

import com.wxj.domain.entity.work.Construction;
import com.wxj.domain.vo.KeyValueVo;
import com.wxj.service.WorkService;
import com.wxj.util.PageUtils;
import com.wxj.util.ResultObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>@ClassName: WorkController  </p>
 * <p>@Description: TODO 工地管理controller</p>
 * <p>@author: wxj  </p>
 * <p>@date: 2019年3月10日</p>
 * <p>@Tel:18772118541</p>
 * <p>@email:18772118541@163.com</p>
 */
@RequestMapping("work")
@RestController
@Api(tags = "工地管理控制类")
public class ConstructionController {
    @Autowired
    private WorkService workService;

    /**
     * <p>@Title: getWorkDict  </p>
     * <p>@Description: TODO 在添加员工的时候要给这个员工分配对应的工地，所以这里提供一个查询工地信息的接口</p>
     * <p>@return   </p>
     * <p>@date:2019-03-10 14:53</p>
     */
    @ApiOperation(value = "工地字典(返回正常的工地名称和工地主键)")
    @RequestMapping(value = "/getWorkDict", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResultObject getWorkDict() {
        List<KeyValueVo> lsit = workService.getWorkDict();
        return new ResultObject(lsit);
    }

    /**
     * <p>@Title: add  </p>
     * <p>@Description: TODO 工地信息添加</p>
     * <p>@return   </p>
     * <p>@date:2019-03-10 14:58</p>
     */
    @ApiOperation(value = "工地信息添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResultObject add(Construction workAre) {
        workAre.setUpdateUser("1");
        workAre.setCreateUser("1");
        int i = workService.add(workAre);
        return new ResultObject(i + "条");
    }

    /**
     * <p>@Title: remove  </p>
     * <p>@Description: TODO remove the contrustion site</p>
     * <p>@param workAre</p>
     * <p>@return   </p>
     * <p>@date:2019-03-11 09:33</p>
     */
    @ApiOperation(value = "工地信息删除")
    @RequestMapping(value = "/remove", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResultObject remove(Construction workAre) {
        int i = workService.remove(workAre);
        return new ResultObject(i + "条");
    }

    /**
     * <p>@Title: modify  </p>
     * <p>@Description: TODO modify site info</p>
     * <p>@param workAre</p>
     * <p>@return   </p>
     * <p>@date:2019-03-11 09:50</p>
     */
    @ApiOperation(value = "工地信息更新")
    @RequestMapping(value = "/modify", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResultObject modify(Construction workAre) {
        int i = workService.modify(workAre);
        return new ResultObject(i + "条");
    }

    /**
     * <p>@Title: query  </p>
     * <p>@Description: TODO query site info</p>
     * <p>@param workAre</p>
     * <p>@return   </p>
     * <p>@date:2019-03-11 10:00</p>
     */
    @ApiOperation(value = "工地信息查询(分页)")
    @RequestMapping(value = "/query", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResultObject query(Construction workAre, PageUtils<Construction> page) {
        page = workService.query(workAre, page);
        return new ResultObject(page);
    }

    @ApiOperation(value = "根据id查询单条工地信息")
    @RequestMapping(value = "/queryById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResultObject queryById(String id) {
        Construction query = workService.queryById(id);
        return new ResultObject(query);
    }

    /**
     * <p>方法名 emDict </p>
     * <p>方法描述: TODO</p>
     * <p>@param workAre
     * <p>@param page
     * <p>@return</p>
     * <p>日期:2019-08-05 10:16</p>
     */
    @ApiOperation(value = "员工字典")
    @RequestMapping(value = "/emDict", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResultObject emDict() {
        List<KeyValueVo> list = workService.queryEmployeeDic();
        ResultObject result = new ResultObject(list);
        return result;
    }

    @ApiOperation(value = "员工字典")
    @RequestMapping(value = "/emDictByadd", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResultObject emDictByadd() {
        List<KeyValueVo> list = workService.queryEmDictByadd();
        ResultObject result = new ResultObject(list);
        return result;
    }
}
