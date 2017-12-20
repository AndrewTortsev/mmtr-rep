package tutorial;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class TESTService {


    @Resource(name = "ru.lanit.epz.capitalRepairs.sessionFactory")
    private SessionFactory sessionFactory;

    public List<TEST> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TEST.class);
        return (List<TEST>) criteria.list();
    }

    public TEST getByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(TEST.class);
        criteria.add(Restrictions.eq("id", id));
        TEST result = (TEST) criteria.uniqueResult();
        return result;
    }

    public AjaxResponseBody create(TEST row) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(row);
            return new AjaxResponseBody("", 1);
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            return new AjaxResponseBody(e.getStackTrace().toString(), -1);
        }
    }

    public AjaxResponseBody update(TEST test) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(test);
            return new AjaxResponseBody("", 1);
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            return new AjaxResponseBody(e.getStackTrace().toString(), -1);
        }
    }

    public AjaxResponseBody delete(int id) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(TEST.class);
        criteria.add(Restrictions.eq("id", id));
        TEST row = (TEST) criteria.uniqueResult();
        try {
            session.delete(row);
            return new AjaxResponseBody("", 1);
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            return new AjaxResponseBody(e.getStackTrace().toString(), -1);
        }
    }
}
