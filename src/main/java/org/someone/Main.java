package org.someone;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.someone.dao.PersonDao;
import org.someone.model.Person;

public class Main {
    private SqlSessionFactory sessionFactory;

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public Main() throws IOException {
        initialize();
    }

    private void initialize() throws IOException {
        String resource = "org/someone/db/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public void run() {
        SqlSession session = sessionFactory.openSession();
        try {
            PersonDao personDao = session.getMapper(PersonDao.class);
            Person axel = personDao.find(1);

            System.out.println("Found person " + axel);

            System.out.println("There are " + personDao.count() + " people");

            Person slash = new Person();
            slash.setName("Slash");
            slash.setLastName("Bang");
            personDao.insert(slash);

            slash = personDao.findByName("Slash");
            System.out.println("Found person " + slash);

            System.out.println("After adding slash, there are " + personDao.count() + " people");

            personDao.delete(slash);

            System.out.println("After deleting slash, there are " + personDao.count() + " people");

            List<Person> people = personDao.findAll();

            for (Person person : people) {
                System.out.println("Found person " + person);
            }

            // session.commit();
        } finally {
            session.close();
        }
    }
}
