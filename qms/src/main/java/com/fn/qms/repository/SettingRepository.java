package com.fn.qms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.ERole;
import com.fn.qms.models.Role;
import com.fn.qms.models.Setting;

@Repository
public interface SettingRepository extends JpaRepository<Setting, Long> {
	
}
