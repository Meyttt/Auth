package database;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import java.util.*;

/**
 * Created by Meyttt on 16.10.2017.
 */
public class DBClient {
    private static final SessionFactory sessionFactory;
    static {
        Configuration configuration= new Configuration();
        configuration.configure();
        sessionFactory=configuration.buildSessionFactory();
    }
    public static Session getSession(){
        return sessionFactory.openSession();
    }
    public static Long saveOb(Object ob){
        Session session=getSession();
        Transaction transaction= session.beginTransaction();
        Long res= (Long) session.save(ob);
        transaction.commit();
        session.close();
        return res;
    }
    public static<T> T  updateObject(T t){
        Session session= getSession();
        Transaction transaction= session.beginTransaction();
        session.update(t);
        transaction.commit();
        session.close();
        return t;
    }
    public static <T> T refresh(T t){
        Session session= getSession();
        session.refresh(t);
        session.close();
        return t;
    }
    public static void saveOrUpd(Object ob){
        Session session= getSession();
        Transaction transaction=session.beginTransaction();
        session.saveOrUpdate(ob);
        System.out.println(ob);;
        transaction.commit();
        session.close();
    }

    /**
     * Поиск по БД по первичному ключу и классу экземпляра
     * @param id первичный ключ, по которому осуществляется поиск
     * @param tClass класс объекта, который требуется найти
     * @param <T> объект, который требуется найти
     * @return
     */
    public static <T> T  read(long id, Class<T> tClass){
        Session session= getSession();
        Transaction transaction=session.beginTransaction();
        T res=(T) session.get(tClass,id);
        session.getTransaction().commit();
        session.close();
        return res;
    }
    public static <T> void persist(T t){
        Session session = getSession();
        Transaction transaction= session.beginTransaction();
        session.refresh(t);
        transaction.commit();
        session.close();
    }

    /**
     * Поиск по бд по полю класса экземпляра, его значению и классу экземпляра
     * @param fieldName поле класса, соотвествующего таблице, по которой будет осуществлен поиск
     * @param ob значение поля, накладываюшее ограничение
     * @param tClass класс объекта, соответствующего таблице, по которой будет осуществляться поиск
     * @param <T> тип объекта, который необходимо найти
     * @return
     */
    public static <T> T readByColumn(String fieldName, Object ob,Class<T> tClass){
        Session session= getSession();
        Criteria criteria=session.createCriteria(tClass);
        T res= (T) criteria.add(Restrictions.eq(fieldName,ob)).uniqueResult();
        session.close();
        return res;
    }

    /**
     * Поиск по бд списка результатов по полю класса экземпляра, его значению и классу экземпляра
     * @param fieldName поле класса, соотвествующего таблице, по которой будет осуществлен поиск
     * @param ob значение поля, накладываюшее ограничение
     * @param tClass класс объекта, соответствующего таблице, по которой будет осуществляться поиск
     * @param <T> тип объекта, который необходимо найти
     */
    public<T> List<T> readListByColumn(String fieldName,Object ob,Class<T> tClass){
        Session session= getSession();
        Criteria criteria=session.createCriteria(tClass);
        //установка ограниченяи для выбора
        criteria.add(Restrictions.eq(fieldName,ob));
        return criteria.list();
    }
    public<T> void update(T ob){
        Session session= getSession();
        Transaction transaction= session.beginTransaction();
        session.update(ob);
        transaction.commit();
        session.close();
    }
    public static  <T> void delete(long id, Class<T> tClass){
        T ob = read(id, tClass);
        Session session= getSession();
        Transaction transaction= session.beginTransaction();
        session.delete(ob);
        transaction.commit();
        session.close();
    }

    public static  <T> void delete(T t){
        Session session= getSession();
        Transaction transaction= session.beginTransaction();
        session.delete(t);
        transaction.commit();
        session.close();
    }


    public static void main(String[] args) {
        Logger logger = Logger.getLogger(DBClient.class);
        DBClient dbClient= new DBClient();
//        dbClient.insertNewToken();


    }



}
