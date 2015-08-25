package com.opencode.test.dao.hibernate;

import java.util.List;
import com.opencode.bean.TspWorkMessage;
import com.opencode.test.dao.WorkMessageDao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class WorkMessageHibernateDao extends HibernateDaoSupport implements WorkMessageDao
{
    public void saveOrUpdate(TspWorkMessage bean)
    {
        this.getHibernateTemplate().saveOrUpdate(bean);
    }

    public TspWorkMessage get(long id)
    {
        TspWorkMessage bean = (TspWorkMessage) this.getHibernateTemplate().get(TspWorkMessage.class, id);
        return bean;
    }

    public void delete(TspWorkMessage bean)
    {
        this.getHibernateTemplate().delete(bean);
    }

    public List findAll()
    {
        String sql = "From TspWorkMessage";
        List list = this.getHibernateTemplate().find(sql);
        return list;
    }
}