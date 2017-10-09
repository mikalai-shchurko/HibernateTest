package org.mikalai;

import java.util.List;

import org.mikalai.dao.OrdersDao;
import org.mikalai.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        testWithManyToManyDeletion(context);
    }

    private static void testWithManyToManyDeletion(ApplicationContext context) {

        OrdersDao ordersDao = context.getBean(OrdersDao.class);
        System.out.println(ordersDao.getPersons());

        Person person = new Person();
        person.setId(1);
        person.setName("newname");
        ordersDao.mergeNewPerson(person);

        System.out.println(ordersDao.getPersons());
    }
}
