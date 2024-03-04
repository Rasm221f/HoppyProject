package org.example.implementation;



import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.example.repository.GenericDAO;

public class GenericDAOImpl<T, ID> implements GenericDAO<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public GenericDAOImpl() {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T findById(ID id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("SELECT e FROM " + entityClass.getName() + " e", entityClass).getResultList();
    }

    @Override
    public T save(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public void deleteById(ID id) {
        T entity = findById(id);
        if (entity != null) {
            delete(entity);
        }
    }
}

