package com.xuefei.service;

import com.xuefei.entity.PageBean;
import com.xuefei.entity.StuQuery;

public interface StuService {
	public abstract PageBean getPageBean(Integer currentPage,Integer pageSize,StuQuery query);
}
