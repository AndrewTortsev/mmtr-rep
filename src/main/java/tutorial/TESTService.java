package tutorial;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        session.beginTransaction();
        Criteria criteria = session.createCriteria(TEST.class);
        criteria.add(Restrictions.eq("id", id));
        TEST result = (TEST) criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public void create(TEST row) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(row);
        session.getTransaction().commit();
        session.close();
    }

    public void update(TEST test) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(test);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(TEST.class);
        criteria.add(Restrictions.eq("id", id));
        TEST row = (TEST) criteria.uniqueResult();
        session.delete(row);
        session.getTransaction().commit();
        session.close();
    }
}
