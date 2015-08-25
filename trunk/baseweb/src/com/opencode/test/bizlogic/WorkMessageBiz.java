package com.opencode.test.bizlogic;

import java.util.List;
import com.opencode.bean.TspWorkMessage;
import com.opencode.common.BaseException;

public interface WorkMessageBiz
{
    public void saveOrUpdate(TspWorkMessage bean) throws BaseException;

    public TspWorkMessage get(long id) throws BaseException;

    public void delete(TspWorkMessage bean) throws BaseException;

    public List findAll() throws BaseException;
}