package com.xuefei.dao;

import java.util.List;

import com.xuefei.entity.StuQuery;
import com.xuefei.entity.Student;

public interface StuDao {
	public abstract List<Student> getlist(int currentPage,int pageSize,StuQuery query);
	public abstract int getcount(StuQuery query);
}
