package com.wxj.common;

/**
 * <p>静态变量类<p>
 */
public class Contans {
	/** 默认每页条数 */
	public static int PAGE_SIZE = 2;
	/** 默认当前页数  */
	public static int PAGE_INDEX = 1;
	/** 重置密码*/
	public static String RESET_PASSWORD = "123456";
	/** 员工状态：在职*/
	public static int EMPLOYEE_STATUS_ON = 1;
	/** 员工状态：离职*/
	public static int EMPLOYEE_STATUS_OUT = 0;

	/** 借支状态： 待提交 */
	public static int LEND_STATUS_WAIT_COMMIT = 0;
	/** 借支状态： 已提交待审核 */
	public static int LEND_STATUS_COMMITED = 1;
	/** 借支状态： 审核通过 */
	public static int LEND_STATUS_PASSED = 2;
	/** 借支状态： 驳回 */
	public static int LEND_STATUS_REJECT = 3;

}
