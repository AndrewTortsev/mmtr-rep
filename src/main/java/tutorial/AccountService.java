package tutorial;


import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AccountService {
    protected static Logger logger = Logger.getLogger("service");

    @Resource(name = "ru.lanit.epz.capitalRepairs.sessionFactory")
    private SessionFactory sessionFactory;

    public List getAll() {
        logger.debug("Retrieving all persons");
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select b.id from Account b").list();
    }

    public Account get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Account person = (Account) session.get(Account.class, id);

        return person;
    }
}
