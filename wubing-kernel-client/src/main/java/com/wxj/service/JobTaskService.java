package com.wxj.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.quartz.SchedulerException;

import com.wxj.domain.entity.job.ScheduleJob;
/**
 * @功能说明：
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：青云科技
 * @作者：wxj
 * @Email：18772118541@163.com
 * @TEL：18772118541
 * @创建时间：2018年2月23日 上午10:47:03
 * @版本：V1.0
 */
public interface JobTaskService {
	/**
	* @方法说明：删除一个触发器
	* @方法名称：deleteTrigger
	* @作....者：wxj
	* @参....数：@param scheduleJob
	* @业....务：
	* @创建时间：2018年5月23日 下午7:15:30
	*/
	public void deleteTrigger(ScheduleJob scheduleJob);
	/**
	 * 从数据库中取 区别于getAllJob
	 * 
	 * @return
	 */
	List<ScheduleJob> getAllTask();
	/**
	 * 添加到数据库中 区别于addJob
	 */
	void addTask(ScheduleJob job);

	/**
	 * 从数据库中查询job
	 */
	ScheduleJob getTaskById(Long jobId);

	/**
	 * 更改任务状态
	 * 
	 * @throws SchedulerException
	 */
	void changeStatus(Long jobId, String cmd) throws SchedulerException;

	/**
	 * 更改任务 cron表达式
	 * 
	 * @throws SchedulerException
	 */
	void updateCron(ScheduleJob job, String cron) throws SchedulerException;

	/**
	 * 添加任务
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	void addJob(ScheduleJob job) throws SchedulerException;

	void init() throws Exception;

	/**
	 * 获取所有计划中的任务列表
	 * 
	 * @return
	 * @throws SchedulerException
	 */
	List<ScheduleJob> getAllJob() throws SchedulerException;

	/**
	 * 所有正在运行的job
	 * 
	 * @return
	 * @throws SchedulerException
	 */
	List<ScheduleJob> getRunningJob() throws SchedulerException;

	/**
	 * 暂停一个job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	void pauseJob(ScheduleJob scheduleJob) throws SchedulerException;

	/**
	 * 恢复一个job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	void resumeJob(ScheduleJob scheduleJob) throws SchedulerException;

	/**
	 * 删除一个job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	void deleteJob(ScheduleJob scheduleJob) throws SchedulerException;

	/**
	 * 立即执行job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	void runAJobNow(ScheduleJob scheduleJob) throws SchedulerException;

	/**
	 * 更新job时间表达式
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	void updateJobCron(ScheduleJob scheduleJob) throws SchedulerException;

}