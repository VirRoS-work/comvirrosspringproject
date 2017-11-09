package dao;

import model.Human;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HumanDAO implements GenericDAO <Human, Integer>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Human object) {
        entityManager.persist(object);
    }

    @Override
    public void update(Human object) {
        entityManager.refresh(object);
    }

    @Override
    public void delete(Integer key) {

        if(getObjectById(key) != null)entityManager.remove(getObjectById(key));
    }

    @Override
    public Human getObjectById(Integer key) {

        Human object = entityManager.find(Human.class, key);
        return object;
    }

    @Override
    public List<Human> getAllObjects() {

        List<Human> objects = entityManager.createQuery("from Human").getResultList();
        return objects;
    }
}
