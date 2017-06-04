package com.tarena.netctoss.dao;

import java.sql.SQLException;
import java.util.List;

import com.tarena.netctoss.entity.Cost;



public interface CostDAO {
	public List<Cost> findAll() ;
}
