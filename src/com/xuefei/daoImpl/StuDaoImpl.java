package com.xuefei.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xuefei.dao.StuDao;
import com.xuefei.entity.StuQuery;
import com.xuefei.entity.Student;
import com.xuefei.util.JdbcUtil;

public class StuDaoImpl implements StuDao{
	
	public List<Student> getlist(int currentPage,int pageSize,StuQuery query){
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		//分页+模糊查询sql
		StringBuilder sql=new StringBuilder();
		sql.append("SELECT* FROM student WHERE 1=1");
		if(query!=null){
			if(query.getName()!=null && !query.getName().trim().equals(""))
				sql.append(" AND name like '%"+query.getName()+"%'");
			if(query.getAge()!=null && !query.getAge().trim().equals(""))
				sql.append(" AND age like '%"+query.getAge()+"%'");
			if(query.getGender()!=null && !query.getGender().trim().equals(""))
				sql.append(" AND gender='"+query.getGender()+"'");
			if(query.getBeginservlet()!=0)
				sql.append(" AND servlet>='"+query.getBeginservlet()+"'");
			if(query.getEndservlet()!=0)
				sql.append(" AND servlet<='"+query.getEndservlet()+"'");	
		}
		sql.append(" LIMIT ?,?");		
		int myPage=(currentPage-1)*pageSize;		
		List<Student> list=null;
		try {
			list =(List<Student>)qr.query(sql.toString(),new BeanListHandler(Student.class),new Object[]{myPage,pageSize});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;		
	}
	
	public int getcount(StuQuery query){
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		//分页+模糊查询sql
		StringBuilder sql=new StringBuilder();
		sql.append("SELECT count(*) FROM student WHERE 1=1");
		if(query!=null){
			if(query.getName()!=null && !query.getName().trim().equals(""))
				sql.append(" AND name like '%"+query.getName()+"%'");
			if(query.getAge()!=null && !query.getAge().trim().equals(""))
				sql.append(" AND age like '%"+query.getAge()+"%'");
			if(query.getGender()!=null && !query.getGender().trim().equals(""))
				sql.append(" AND gender='"+query.getGender()+"'");
			if(query.getBeginservlet()!=0)
				sql.append(" AND servlet>='"+query.getBeginservlet()+"'");
			if(query.getEndservlet()!=0)
				sql.append(" AND servlet<='"+query.getEndservlet()+"'");	
		}
		Long count=null;
		try {
			count = (Long)qr.query(sql.toString(),new ScalarHandler());//这里是Long不是long
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		int value = count.intValue();
		return value;
	}
}

