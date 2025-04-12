package dao;

import entities.UtilisationQuantite;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class UtilisationQuantiteDao implements IDao<UtilisationQuantite> {

    @Override
    public boolean create(UtilisationQuantite o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            if (session != null) session.close();
        }
        return etat;
    }

    @Override
    public boolean delete(UtilisationQuantite o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            if (session != null) session.close();
        }
        return etat;
    }

    @Override
    public boolean update(UtilisationQuantite o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            if (session != null) session.close();
        }
        return etat;
    }

    @Override
    public List<UtilisationQuantite> findAll() {
        Session session = null;
        Transaction tx = null;
        List<UtilisationQuantite> utilisations = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            utilisations = session.createQuery("from UtilisationQuantite").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            if (session != null) session.close();
        }
        return utilisations;
    }

    @Override
    public UtilisationQuantite findById(int id) {
        Session session = null;
        Transaction tx = null;
        UtilisationQuantite utilisation = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            utilisation = (UtilisationQuantite) session.get(UtilisationQuantite.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            if (session != null) session.close();
        }
        return utilisation;
    }
}
