package tutorial;


import org.apache.log4j.Logger;
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
    protected static Logger logger = Logger.getLogger("service");

    @Resource(name = "ru.lanit.epz.capitalRepairs.sessionFactory")
    private SessionFactory sessionFactory;

    public List<TEST> getAll() {
        logger.debug("Retrieving all persons");
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TEST.class);
        return (List<TEST>) criteria.list();
    }

    public TEST get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TEST.class);
        criteria.add(Restrictions.eq("id",id));
        return (TEST) criteria.uniqueResult();
    }
}
