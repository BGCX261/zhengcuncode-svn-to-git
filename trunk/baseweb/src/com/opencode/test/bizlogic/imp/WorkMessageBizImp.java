package com.opencode.test.bizlogic.imp;

import java.util.List;
import com.opencode.bean.TspWorkMessage;
import com.opencode.common.BaseException;
import com.opencode.test.bizlogic.WorkMessageBiz;
import com.opencode.test.dao.WorkMessageDao;

public class WorkMessageBizImp implements WorkMessageBiz
{
    private WorkMessageDao workMessageDao;

    public void saveOrUpdate(TspWorkMessage bean) throws BaseException
    {
        this.getWorkMessageDao().saveOrUpdate(bean);
    }

    public TspWorkMessage get(long id) throws BaseException
    {
        return this.getWorkMessageDao().get(id);
    }

    public void delete(TspWorkMessage bean) throws BaseException
    {
        this.getWorkMessageDao().delete(bean);
    }

    public List findAll() throws BaseException
    {
        return this.getWorkMessageDao().findAll();
    }

    public WorkMessageDao getWorkMessageDao()
    {
        return workMessageDao;
    }
    public void setWorkMessageDao(WorkMessageDao workMessageDao)
    {
        this.workMessageDao = workMessageDao;
    }
}