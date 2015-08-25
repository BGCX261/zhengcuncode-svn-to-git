package com.opencode.test.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import com.opencode.common.BaseListAction;
import com.opencode.test.bizlogic.WorkMessageBiz;

public class WorkMessageListAction extends BaseListAction
{
    private WorkMessageBiz workMessageBiz;
    
    public WorkMessageBiz getWorkMessageBiz()
    {
        return workMessageBiz;
    }
    public void setWorkMessageBiz(WorkMessageBiz workMessageBiz)
    {
        this.workMessageBiz = workMessageBiz;
    }
    
    public void list(ActionForm form, HttpServletRequest request) throws Exception
    {
        List list = this.getWorkMessageBiz().findAll();
        request.setAttribute("resultSet", list);
    }
    
}
