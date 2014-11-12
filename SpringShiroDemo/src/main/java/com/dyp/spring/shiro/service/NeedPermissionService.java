package com.dyp.spring.shiro.service;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Service;

@Service(value="needPermissionService")
public class NeedPermissionService {
	@RequiresPermissions("admin:manage")
	public String needPermissionFuc()
	{
		return "this is a permission fuc";
	}
}
