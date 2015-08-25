package com.opencode.common;

import org.apache.struts.action.ActionForm;

public class BaseForm extends ActionForm
{
    private String id;
    private String method;
    //分页
    private int totalNum;
    private String page = "1";
    private int pageSize = 6;
    private String pageString;
    private int showPageURL = 5;
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
	public String getMethod()
	{
		return method;
	}
	public void setMethod(String method)
	{
		this.method = method;
	}
	public int getTotalNum()
	{
		return totalNum;
	}
	public void setTotalNum(int totalNum)
	{
		this.totalNum = totalNum;
	}
	
	public int getPageSize()
	{
		return pageSize;
	}
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}
	
	public int getShowPageURL()
	{
		return showPageURL;
	}
	public void setShowPageURL(int showPageURL)
	{
		this.showPageURL = showPageURL;
	}
	
	public String getPage()
	{
		return page;
	}
	public void setPage(String page)
	{
		this.page = page;
	}
	
	public String getPageString()
	{		
		return pageString;
	}
	
	public void calculate()
	{
		int page = 1;
		try
		{
			page = Integer.parseInt(getPage());
		} catch (NumberFormatException e)
		{
			e.printStackTrace();
		}		
		int pageNum = (totalNum-1)/pageSize + 1;
		if(page < 1)
		{
			page = 1;
		}
		else if(page > pageNum)
		{
			page = pageNum;
		}
		setPage(page+"");
		StringBuffer sb = new StringBuffer();
		sb.append("<table class=\"tablePage\"><tr class=\"trPage\"><td class=\"tdPage\">");
		sb.append("共" + totalNum + "条 共" + pageNum + "页 当前第" + page + "页 ");
		if(page < (showPageURL + 1))
		{
			sb.append("上" + showPageURL + "页 ");
		}
		else
		{
			sb.append("<a href=\"#\" onclick=\"changePage('" + (((page-1)/showPageURL-1)*showPageURL+1)  + "')\">上" + showPageURL + "页</a> ");
		}
		for(int i=((page-1)/showPageURL*showPageURL+1);i<=((page-1)/showPageURL*showPageURL+showPageURL)&&i<=pageNum;i++)
		{
			if(i == page)
			{
				sb.append(i + " ");
			}
			else
			{
				sb.append("<a href=\"#\" onclick=\"changePage('" + i + "')\">" + i + "</a> ");
			}			
		}
		if(((page-1)/showPageURL*showPageURL+showPageURL) >=  pageNum)
		{
			sb.append("下" + showPageURL + "页");
		}
		else
		{
			sb.append("<a href=\"#\" onclick=\"changePage('" + (((page-1)/showPageURL+1)*showPageURL+1)  + "')\">下" + showPageURL + "页</a>");
		}
		sb.append("</td></tr></table>");
		
		pageString = sb.toString();
	}	
	
	
}
