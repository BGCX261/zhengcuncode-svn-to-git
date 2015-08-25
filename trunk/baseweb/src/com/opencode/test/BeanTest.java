package com.opencode.test;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

public class BeanTest 
{
	public static void main(String[] args)
	{
		BeanA a = new BeanA();
		a.setId(1);
		a.setName("zc");
		a.setSex("male");
		BeanB b = new BeanB();
//		try
//		{
//			BeanUtils.copyProperties(a, b);
//		} catch (BeansException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try
		{
			org.apache.commons.beanutils.BeanUtils.copyProperties(a, b);
		} catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("id of b is:" + b.getId());
		System.out.println("name of b is:" + b.getName());
		System.out.println("male of b is:" + b.getSex());
	}
}
class BeanA
{
	private int id;
	private String name;
	private String sex;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	
}
class BeanB
{
	private int id;
	private int name;
	private String sex;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getName()
	{
		return name;
	}
	public void setName(int name)
	{
		this.name = name;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	
}