package test;

import entities.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Création d'une catégorie
            Categorie cat = new Categorie("Desserts");
            session.save(cat);
            System.out.println("Catégorie créée : " + cat.getNom());

            // Création d'un utilisateur
            User user = new User("Sara", "sara@gmail.com", "123");
            session.save(user);
            System.out.println("Utilisateur créé : " + user.getNom());

            // Création d'une recette
            Recette recette = new Recette("Cake au chocolat", "Mélanger et cuire 30 min");
            recette.setCategorie(cat);
            session.save(recette);
            System.out.println("Recette créée : " + recette.getTitre());

            // Ajout d'ingrédients via UtilisationQuantite
            Ingredient i1 = new Ingredient("Chocolat");
            Ingredient i2 = new Ingredient("Farine");
            session.save(i1);
            session.save(i2);

            UtilisationQuantite uq1 = new UtilisationQuantite();
            uq1.setRecette(recette);
            uq1.setIngredient(i1);
            uq1.setQuantite("200g");

            UtilisationQuantite uq2 = new UtilisationQuantite();
            uq2.setRecette(recette);
            uq2.setIngredient(i2);
            uq2.setQuantite("250g");

            session.save(uq1);
            session.save(uq2);
            System.out.println("Ingrédients ajoutés à la recette.");

            // Ajout d'un commentaire
            CommentaireRecette commentaire = new CommentaireRecette();
            commentaire.setRecette(recette);
            commentaire.setUser(user);
            commentaire.setContenu("Très bonne recette, facile à faire !");

            session.save(commentaire);
            System.out.println("Commentaire ajouté par " + user.getNom());

            tx.commit();

            //List<Recette> recettes;
            //recettes = session.createQuery("FROM Recette r JOIN FETCH r.categorie", Recette.class).list();
            //for (Recette r : recettes) {
            //  System.out.println("Recette : " + r.getTitre() + " | Catégorie : " + r.getCategorie().getNom());
            //}
            /*System.out.println("\n--- VÉRIFICATION DES RECETTES ---");
            List<Recette> recettes = session.createQuery("FROM Recette r JOIN FETCH r.categorie", Recette.class).list();
            for (Recette r : recettes) {
                System.out.println("Recette : " + r.getTitre() + " | Catégorie : " + r.getCategorie().getNom());
            */
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}
