package com.opencode.test.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import com.opencode.bean.TspWorkMessage;
import com.opencode.common.BaseSaveAction;
import com.opencode.test.bizlogic.WorkMessageBiz;
import com.opencode.test.form.WorkMessageForm;

public class WorkMessageSaveAction extends BaseSaveAction
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
    
    public void save(ActionForm form, HttpServletRequest request) throws Exception
    {
        WorkMessageForm myForm = (WorkMessageForm)form;
        TspWorkMessage bean = myForm.getValue();
        this.getWorkMessageBiz().saveOrUpdate(bean);
    }
}
