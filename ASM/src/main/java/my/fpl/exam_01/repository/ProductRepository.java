package my.fpl.exam_01.repository;

import my.fpl.exam_01.model.User;
import my.fpl.exam_01.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProductRepository {

    private Session session;

    public ProductRepository() {
        session = HibernateUtil.getFACTORY().openSession();
    }

    public List<User> getAll() {
        return session.createQuery("FROM Product").getResultList();
    }

    public User findById(String username) {
        return session.find(User.class, username);
    }
}
