package service;

import dao.GenericDAO;
import model.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HumanService implements GenericService<Human, Integer>{

    public HumanService() {
    }

    @Autowired
    private GenericDAO dao;

    @Override
    @Transactional
    public void create(Human object) {
        dao.create(object);
    }

    @Override
    @Transactional
    public void update(Human object) {
        dao.update(object);
    }

    @Override
    @Transactional
    public void delete(Integer key) {
        dao.delete(key);
    }

    @Override
    @Transactional
    public Human getObjectById(Integer key) {
        return (Human) dao.getObjectById(key);
    }

    @Override
    @Transactional
    public List<Human> getAllObjects() {
        return dao.getAllObjects();
    }
}
