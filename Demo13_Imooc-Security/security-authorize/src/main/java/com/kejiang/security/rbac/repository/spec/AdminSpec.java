package com.kejiang.security.rbac.repository.spec;

import com.kejiang.security.rbac.domain.Admin;
import com.kejiang.security.rbac.dto.AdminCondition;
import com.kejiang.security.rbac.repository.support.ImoocSpecification;
import com.kejiang.security.rbac.repository.support.QueryWraper;

/**
 * @author zhailiang
 *
 */
public class AdminSpec extends ImoocSpecification<Admin, AdminCondition> {

	public AdminSpec(AdminCondition condition) {
		super(condition);
	}

	@Override
	protected void addCondition(QueryWraper<Admin> queryWraper) {
		addLikeCondition(queryWraper, "username");
	}

}
