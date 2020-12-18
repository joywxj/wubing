package com.wxj.domain.vo;

/**  
* <p>@ClassName: KeyValueVo  </p>
* <p>@Description: TODO KeyValueVo  </p>
* <p>@author: wxj  </p>
* <p>@date: 2018年12月28日</p>
* <p>@Tel:18772118541</p>
* <p>@email:18772118541@163.com</p>
*/
public class KeyValueVo {
	private String keywords;
	private String value;
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "KeyValueVo [keywords=" + keywords + ", value=" + value + "]";
	}
}
