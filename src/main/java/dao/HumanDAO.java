package dao;

import model.Human;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HumanDAO implements GenericDAO <Human, Integer>{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Human object) {

        Session session = sessionFactory.getCurrentSession();
        session.persist(object);
    }

    @Override
    public void update(Human object) {

        Session session = sessionFactory.getCurrentSession();
        session.update(object);
    }

    @Override
    public void delete(Integer key) {

        Session session = sessionFactory.getCurrentSession();
        if(getObjectById(key) != null)session.delete(key);
    }

    public Human getObjectById(Integer key) {

        Session session = sessionFactory.getCurrentSession();
        Human object = (Human) session.load(Human.class, key);
        return object;
    }

    public List<Human> getAllObjects() {

        Session session = sessionFactory.getCurrentSession();
        List<Human> objects = session.createQuery("from Humans").list();
        return objects;
    }
}
