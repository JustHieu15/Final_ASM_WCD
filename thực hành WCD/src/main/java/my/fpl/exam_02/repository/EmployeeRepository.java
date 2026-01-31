package my.fpl.exam_02.repository;

import my.fpl.exam_02.model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeRepository {

    private Session session;

    public EmployeeRepository() {
        session = HibernateUtil.getFACTORY().openSession();
    }

    public List<Employee> getAll() {
        return session.createQuery("FROM Employee ").getResultList();
    }

    public List<Employee> findByIdOrName(String keyword) {
        String hql = "FROM Employee e " +
                "WHERE e.employeeId LIKE :kw " +
                "OR e.employeeName LIKE :kw";

        return session.createQuery(hql, Employee.class)
                .setParameter("kw", "%" + keyword + "%")
                .getResultList();
    }

    public Employee findById(String employeeId) {
        return session.find(Employee.class, employeeId);
    }

    public Employee findByEmployeeId(String employeeId) {
        return session.createQuery(
                        "FROM Employee e WHERE e.employeeId = :employeeId",
                        Employee.class
                )
                .setParameter("employeeId", employeeId)
                .uniqueResult();
    }

    public void create(Employee objInput) {
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(objInput);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(Employee objInput) {
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.merge(objInput);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(Employee objInput) {
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.remove(objInput);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
