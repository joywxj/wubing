package com.wxj.controller.task;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wxj.domain.entity.job.ScheduleJob;
import com.wxj.service.JobTaskService;
import com.wxj.util.ResultObject;
import com.wxj.util.SpringUtils;
/**  
* <p>@ClassName: JobTaskController  </p>
* <p>@Description: TODO</p>
* <p>@author: wxj  </p>
* <p>@date: 2019年3月6日</p>
* <p>@Tel:18772118541</p>
* <p>@email:18772118541@163.com</p>
*/
@Controller
@RequestMapping("/task")
public class JobTaskController {
	// 日志记录器
	public final Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private JobTaskService taskService;

	@RequestMapping("taskList")
	public String taskList(HttpServletRequest request) {
		List<ScheduleJob> taskList = taskService.getAllTask();
		request.setAttribute("taskList", taskList);
		return "base/task/taskList";
	}

	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	@RequestMapping("add")
	@ResponseBody
	public ResultObject taskList(HttpServletRequest request, ScheduleJob scheduleJob) {
		ResultObject retObj = new ResultObject();
		retObj.setStatus(0);
		try {
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());
		} catch (Exception e) {
			retObj.setObj("cron表达式有误，不能被解析！");
			return retObj;
		}
		Object obj = null;
		try {
			if (StringUtils.isNotBlank(scheduleJob.getSpringId())) {
				obj = SpringUtils.getBean(scheduleJob.getSpringId());
			} else {
				Class clazz = Class.forName(scheduleJob.getBeanClass());
				obj = clazz.newInstance();
			}
		} catch (Exception e) {
			// do nothing.........
		}
		if (obj == null) {
			retObj.setObj("未找到目标类！");
			return retObj;
		} else {
			Class clazz = obj.getClass();
			Method method = null;
			try {
				method = clazz.getMethod(scheduleJob.getMethodName(), null);
			} catch (Exception e) {
				// do nothing.....
			}
			if (method == null) {
				retObj.setObj("未找到目标方法！");
				return retObj;
			}
		}
		try {
			taskService.addTask(scheduleJob);
		} catch (Exception e) {
			e.printStackTrace();
			retObj.setStatus(0);
			retObj.setObj("保存失败，检查 name group 组合是否有重复！");
			return retObj;
		}

		retObj.setStatus(1);
		return retObj;
	}

	@RequestMapping("changeJobStatus")
	@ResponseBody
	public ResultObject changeJobStatus(HttpServletRequest request, Long jobId, String cmd) {
		ResultObject retObj = new ResultObject();
		retObj.setStatus(0);
		try {
			taskService.changeStatus(jobId, cmd);
		} catch (SchedulerException e) {
			log.error(e.getMessage(), e);
			retObj.setObj("任务状态改变失败！");
			return retObj;
		}
		retObj.setStatus(1);
		return retObj;
	}

	@SuppressWarnings("unused")
	@RequestMapping("updateCron")
	@ResponseBody
	public ResultObject updateCron(HttpServletRequest request, Long jobId, String cron) {
		ResultObject retObj = new ResultObject();
		retObj.setStatus(0);
		try {
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
		} catch (Exception e) {
			retObj.setObj("cron表达式有误，不能被解析！");
			return retObj;
		}
		try {
			ScheduleJob job = taskService.getTaskById(jobId);
			taskService.updateCron(job, cron);
		} catch (SchedulerException e) {
			retObj.setObj("cron更新失败！");
			return retObj;
		}
		retObj.setStatus(1);
		return retObj;
	}
}
