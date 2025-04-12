/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Recette;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class RecetteDao implements IDao<Recette>{

    @Override
    public boolean create(Recette o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            etat = true;
        }catch(HibernateException e){
            if(tx != null)
                tx.rollback();
        }finally{
            if(session != null)
                session.close();
        }
        return etat;
    }

    @Override
    public boolean delete(Recette o) {
       Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            etat = true;
        }catch(HibernateException e){
            if(tx != null)
                tx.rollback();
        }finally{
            if(session != null)
                session.close();
        }
        return etat;
    }

    @Override
    public boolean update(Recette o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            etat = true;
        }catch(HibernateException e){
            if(tx != null)
                tx.rollback();
        }finally{
            if(session != null)
                session.close();
        }
        return etat;
    }

    @Override
    public List<Recette> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Recette> Recettes = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Recettes = session.createQuery("from Recette").list();
            tx.commit();
        }catch(HibernateException e){
            if(tx != null)
                tx.rollback();
        }finally{
            if(session != null)
                session.close();
        }
        return Recettes;
    }

    @Override
    public Recette findById(int id) {
        Session session = null;
        Transaction tx = null;
        Recette Recette = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Recette = (Recette) session.get(Recette.class, id);
            tx.commit();
        }catch(HibernateException e){
            if(tx != null)
                tx.rollback();
        }finally{
            if(session != null)
                session.close();
        }
        return Recette;
    }
    
}
