package com.snocal.sms.conf.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snocal.sms.conf.core.entity.AppApisEntity;

@Repository
public interface AppApisRepository extends JpaRepository<AppApisEntity, Integer> {

}
