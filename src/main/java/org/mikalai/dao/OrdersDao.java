package org.mikalai.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.mikalai.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OrdersDao {
    private SessionFactory sessionFactory;

    @Autowired
    public OrdersDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Person> getPersons() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            return session.createCriteria(Person.class).setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
        } finally {
            session.close();
        }
    }

    public void mergeNewPerson(Person person) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.merge(person);
        } finally {
            session.close();
        }
    }
}
