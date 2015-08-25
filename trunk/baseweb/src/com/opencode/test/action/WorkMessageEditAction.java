package com.opencode.test.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import com.opencode.bean.TspWorkMessage;
import com.opencode.common.BaseEditAction;
import com.opencode.test.bizlogic.WorkMessageBiz;
import com.opencode.test.form.WorkMessageForm;

public class WorkMessageEditAction extends BaseEditAction
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
    public void get(ActionForm form, HttpServletRequest request) throws Exception
    {
        WorkMessageForm myForm = (WorkMessageForm)form;
        String id = myForm.getId();
        if(id != null && !id.equals(""))
        {
            TspWorkMessage bean = this.getWorkMessageBiz().get(Long.parseLong(id));
            myForm.setValue(bean);
        }
    }
}
