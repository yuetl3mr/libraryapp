package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.template.AbstractHibernateDao;
import persistence.Reader;
import persistence.User;

public class HibernateUserDao extends AbstractHibernateDao implements UserDao {

    private static final String getAll = "SELECT * FROM user";
    private static final String getMaxId = "SELECT MAX(userId) FROM user";
    private static final String getId = "SELECT * FROM user WHERE userId = :pId";
    private static final String getAllReader = "SELECT `user`.*\n"
            + "FROM reader\n"
            + "JOIN `user`\n"
            + "ON reader.userId = `user`.userId";
    private static final String getAllFindNameReader = "SELECT `user`.*\n"
            + "FROM reader\n"
            + "JOIN `user`\n"
            + "ON reader.userId = `user`.userId\n"
            + "WHERE `user`.`name` LIKE :pName";
    
    private static final String isEmptyEmail = "SELECT `user`.*\n"
            + "FROM reader\n"
            + "Where phoneNumber = :pEmail\n";
    

    public boolean isEmptyEmail(String string) {
        List<User> users = openSession().createNativeQuery(isEmptyEmail, User.class).setParameter("pEmail", string).getResultList();
        if (users.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<User> getAll() {
        return openSession().createNativeQuery(getAll, User.class).getResultList();
    }

    @Override
    public void save(User user) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Integer maxId() {
        return (Integer) openSession().createNativeQuery(getMaxId).getResultList().get(0);
    }

    @Override
    public User get(Integer id) {
        List<User> users = openSession().createNativeQuery(getId, User.class).setParameter("pId", id).getResultList();
        if (users.isEmpty()) {
            return null;
        } else {
            return users.get(0);
        }
    }

    public List<User> getUserId(Integer id) {
        return openSession().createNativeQuery(getId, User.class).setParameter("pId", id).getResultList();
    }

    @Override
    public void delete(Integer integer) {
        User user = get(integer);
        if (user == null) {
            System.exit(0);
        }
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer userId, String name, String address, String phoneNumber) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        try {
            User user = get(userId);
            user.setName(name);
            user.setAddress(address);
            user.setPhoneNumber(phoneNumber);
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllReader() {
        return openSession().createNativeQuery(getAllReader, User.class).getResultList();
    }

    public List<User> getAllFindNameReader(String Name) {
        return openSession().createNativeQuery(getAllFindNameReader, User.class).setParameter("pName", "%" + Name + "%").getResultList();
    }

}
