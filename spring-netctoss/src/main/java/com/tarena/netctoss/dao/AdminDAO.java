package com.tarena.netctoss.dao;

import java.util.List;

import com.tarena.netctoss.entity.Admin;
import com.tarena.netctoss.entity.Cost;



public interface AdminDAO {

	public Admin findByAdminCode(String adminCode);
	
	
}
