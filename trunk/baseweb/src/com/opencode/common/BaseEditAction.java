package com.opencode.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public abstract class BaseEditAction extends Action
{
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ActionForward forward = mapping.findForward("success");
        try
        {
            get(form, request);
        }
        catch (Exception e)
        {
            request.setAttribute("error", e.getMessage());
            forward = mapping.findForward("error");
            e.printStackTrace();
        }
        return forward;
    }
    
    public abstract void get(ActionForm form, HttpServletRequest request) throws Exception;
}
