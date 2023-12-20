package com.spring.utility.scheduler;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SchedularDAO {

	public List<Map<String,Object>> selectListProduct();
	public List<Map<String,Object>> selectListBrand();
	
}
