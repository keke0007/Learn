
package com.kejiang.security.rbac.repository;

import org.springframework.stereotype.Repository;

import com.kejiang.security.rbac.domain.Resource;

/**
 * @author zhailiang
 *
 */
@Repository
public interface ResourceRepository extends ImoocRepository<Resource> {

	Resource findByName(String name);

}
