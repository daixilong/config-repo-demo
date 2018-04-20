package com.xdl.config_client.model;

import javax.validation.constraints.NotNull;

/**
 * 执行校验方法
 * @author a
 *
 */
public class User {

	@NotNull(message="主键的值不能为空")
	private Integer id;
	
	@NotNull(message="名称不能为空")
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
