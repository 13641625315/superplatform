package com.cris.superplatform.provider.user.dao;

import com.cris.superplatform.provider.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 *
 * @author cris.zhu
 * @date 2019/11/18
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
