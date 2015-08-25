package com.opencode.test.form;



import com.opencode.bean.TspWorkMessage;
import com.opencode.common.BaseForm;
import com.opencode.common.DateUtil;

public class WorkMessageForm extends BaseForm
{
    private String messId;
    private String messTitle;
    private String messContent;
    private String messFlag;
    private String messIsStaste;
    private String messIncUser;
    private String messAppUser;
    private String messAppDate;
    private String messDeptCode;
    private String messTableCode;
    private String messTableId;
    public void setValue(TspWorkMessage bean)
    {
        messId = bean.getMessId().toString();
        messTitle = bean.getMessTitle();
        messContent = bean.getMessContent();
        messFlag = bean.getMessFlag();
        messIsStaste = bean.getMessIsStaste();
        messIncUser = bean.getMessIncUser();
        messAppUser = bean.getMessAppUser();
        messAppDate = bean.getMessAppDate().toString();
        messDeptCode = bean.getMessDeptCode();
        messTableCode = bean.getMessTableCode();
        messTableId = bean.getMessTableId().toString();
    }
    public TspWorkMessage getValue()
    {
        TspWorkMessage bean = new TspWorkMessage();
        bean.setMessId(Long.valueOf(messId));
        bean.setMessTitle(messTitle);
        bean.setMessContent(messContent);
        bean.setMessFlag(messFlag);
        bean.setMessIsStaste(messIsStaste);
        bean.setMessIncUser(messIncUser);
        bean.setMessAppUser(messAppUser);
        bean.setMessAppDate(DateUtil.getDate(messAppDate));
        bean.setMessDeptCode(messDeptCode);
        bean.setMessTableId(Long.valueOf(messTableId));
        return bean;
    }
    public String getMessAppDate()
    {
        return messAppDate;
    }
    public void setMessAppDate(String messAppDate)
    {
        this.messAppDate = messAppDate;
    }
    public String getMessAppUser()
    {
        return messAppUser;
    }
    public void setMessAppUser(String messAppUser)
    {
        this.messAppUser = messAppUser;
    }
    public String getMessContent()
    {
        return messContent;
    }
    public void setMessContent(String messContent)
    {
        this.messContent = messContent;
    }
    public String getMessDeptCode()
    {
        return messDeptCode;
    }
    public void setMessDeptCode(String messDeptCode)
    {
        this.messDeptCode = messDeptCode;
    }
    public String getMessFlag()
    {
        return messFlag;
    }
    public void setMessFlag(String messFlag)
    {
        this.messFlag = messFlag;
    }
    public String getMessId()
    {
        return messId;
    }
    public void setMessId(String messId)
    {
        this.messId = messId;
    }
    public String getMessIncUser()
    {
        return messIncUser;
    }
    public void setMessIncUser(String messIncUser)
    {
        this.messIncUser = messIncUser;
    }
    public String getMessIsStaste()
    {
        return messIsStaste;
    }
    public void setMessIsStaste(String messIsStaste)
    {
        this.messIsStaste = messIsStaste;
    }
    public String getMessTableCode()
    {
        return messTableCode;
    }
    public void setMessTableCode(String messTableCode)
    {
        this.messTableCode = messTableCode;
    }
    public String getMessTableId()
    {
        return messTableId;
    }
    public void setMessTableId(String messTableId)
    {
        this.messTableId = messTableId;
    }
    public String getMessTitle()
    {
        return messTitle;
    }
    public void setMessTitle(String messTitle)
    {
        this.messTitle = messTitle;
    }
}
