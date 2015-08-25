package com.opencode.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public abstract class BaseListAction extends Action
{
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ActionForward forward = mapping.findForward("success");
        BaseForm myForm = (BaseForm)form;
        String method = myForm.getMethod();
        
        try
        {
        	if(method != null && method.equals("delete"))
        	{
        		delete(form, request);
        	}
            list(form, request);
        }
        catch (Exception e)
        {
            request.setAttribute("error", e.getMessage());
            forward = mapping.findForward("error");
            e.printStackTrace();
        }
        return forward;
    }
    public void delete(ActionForm form, HttpServletRequest request) throws Exception
    {
    	String[] checkIds = request.getParameterValues("recordCheckBox");
    	String ids = "";
    	for(int i=0;i<checkIds.length;i++)
    	{
    		if(i==checkIds.length - 1)
    		{
    			ids = ids + checkIds[i];
    		}
    		else
    		{
    			ids = ids + checkIds[i] + ",";
    		}
    	}
    	delete(form, request, ids);
    }
    public abstract void list(ActionForm form, HttpServletRequest request) throws Exception;
    public abstract void delete(ActionForm form, HttpServletRequest request,String ids) throws Exception;
}
