package com.tarena.netctoss.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tarena.netctoss.entity.Admin;



@Repository
public interface AdminDAO {

	public Admin findByAdminCode(String adminCode);
	
	
}
