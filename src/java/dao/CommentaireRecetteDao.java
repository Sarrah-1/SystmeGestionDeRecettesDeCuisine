package dao;

import entities.CommentaireRecette;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class CommentaireRecetteDao implements IDao<CommentaireRecette> {

    @Override
    public boolean create(CommentaireRecette o) {
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
    public boolean delete(CommentaireRecette o) {
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
    public boolean update(CommentaireRecette o) {
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
    public List<CommentaireRecette> findAll() {
        Session session = null;
        Transaction tx = null;
        List<CommentaireRecette> commentaires = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            commentaires = session.createQuery("from CommentaireRecette").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            if (session != null) session.close();
        }
        return commentaires;
    }

    @Override
    public CommentaireRecette findById(int id) {
        Session session = null;
        Transaction tx = null;
        CommentaireRecette commentaire = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            commentaire = (CommentaireRecette) session.get(CommentaireRecette.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            if (session != null) session.close();
        }
        return commentaire;
    }
}
