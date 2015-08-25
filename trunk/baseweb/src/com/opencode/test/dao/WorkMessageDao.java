package com.opencode.test.dao;

import java.util.List;
import com.opencode.bean.TspWorkMessage;

public interface WorkMessageDao
{
    public void saveOrUpdate(TspWorkMessage bean);

    public TspWorkMessage get(long id);

    public void delete(TspWorkMessage bean);

    public List findAll();
}