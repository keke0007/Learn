package com.swagger.common;

import java.util.Date;

import lombok.Data;


@Data
public class BaseDo {
	/**
	 * 是否可用 0可用 1不可用
	 */
	private Long isAvailability;
	/**
	 * 注册时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 *
	 */
	private Date updateTime;
	/**
	 * id
	 */
	//private Long id;


}
