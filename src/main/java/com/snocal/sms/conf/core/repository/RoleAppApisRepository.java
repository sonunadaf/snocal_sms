package com.snocal.sms.conf.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snocal.sms.conf.core.entity.RoleAppApisEntity;

@Repository
public interface RoleAppApisRepository extends JpaRepository<RoleAppApisEntity, Long> {

}
