package com.xuefei.serviceImpl;

import java.util.List;

import com.xuefei.dao.StuDao;
import com.xuefei.daoImpl.StuDaoImpl;
import com.xuefei.entity.PageBean;
import com.xuefei.entity.StuQuery;
import com.xuefei.entity.Student;
import com.xuefei.service.StuService;

public class StuServiceImpl implements StuService {

	@Override
	public PageBean getPageBean(Integer currentPage,Integer pageSize,StuQuery query) {
		PageBean pagebean=new PageBean();
		pagebean.setCurrentPage(currentPage);
		
		StuDao dao=new StuDaoImpl();
		//总记录数
		pagebean.setTotalCount(dao.getcount(query));
		//每页显示记录数
		pagebean.setPageSize(pageSize);		
				
		List<Student> list = dao.getlist(pagebean.getCurrentPage(), pagebean.getPageSize(),query);
		pagebean.setList(list);
		return pagebean;
	}

}
