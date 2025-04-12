package test;

import dao.AdminDao;
import dao.CategorieDao;
import dao.CommentaireRecetteDao;
import dao.IngredientDao;
import dao.RecetteDao;
import dao.UserDao;
import dao.UtilisationQuantiteDao;
import entities.Admin;
import entities.Categorie;
import entities.CommentaireRecette;
import entities.Ingredient;
import entities.Recette;
import entities.User;
import entities.UtilisationQuantite;
import util.HibernateUtil;

public class Test {
    public static void main(String[] args) {
        //RecetteDao rd = new RecetteDao();
        //rd.create(new Recette("cake","caramel"));
        //rd.delete(rd.findById(1));
        //for(Recette f : rd.findAll())
         //   System.out.println(f.getTitre());
        
        /*UserDao ud = new UserDao();
        User user = new User();
        user.setNom("Sara");user.setEmail("sara@gmail.com");user.setPassword("123");
        ud.create(user);
        for (User u : ud.findAll()) {
            System.out.println("Nom: " + u.getNom());
            System.out.println("Email: " + u.getEmail());
            System.out.println("-----------");
        }*/
        //ud.delete(ud.findById(1));
        /*IngredientDao idao = new IngredientDao();
        Ingredient i = new Ingredient();
        i.setNom("Sucre");
        idao.create(i);
        for (Ingredient ing : idao.findAll()) {
            System.out.println("ID: " + ing.getId() + " | Nom: " + ing.getNom());
        }
        // idao.delete(idao.findById(1)); 
        */
        /*
        CategorieDao dao = new CategorieDao();
        Categorie c1 = new Categorie();
        c1.setNom("Desserts");
        dao.create(c1);
        System.out.println("Liste des catégories :");
        for (Categorie c : dao.findAll()) {
            System.out.println("ID: " + c.getId() + " | Nom: " + c.getNom());
        }
        // dao.delete(dao.findById(1));
        */
        /*
        AdminDao dao = new AdminDao();

        Admin a1 = new Admin();
        a1.setNom("Amine");
        a1.setEmail("amine@gmail.com");
        a1.setPassword("admin");
        a1.setMatricule("2025");
        dao.create(a1);

        System.out.println("Liste des admins :");
        for (Admin a : dao.findAll()) {
            System.out.println("Nom: " + a.getNom() + ", Matricule: " + a.getMatricule());
        }
        // dao.delete(dao.findById(1));
        */
        /*
        CommentaireRecetteDao dao = new CommentaireRecetteDao();
        Recette recette = new Recette();
        recette.setTitre("Gateau au chocolat");
        recette.setInstructions("Mélanger les ingrédients et cuire à 180°C.");
        
        User user = new User();
        user.setNom("Ghizlane");
        user.setEmail("Ghizlan@gmail.com");
        user.setPassword("123");
        CommentaireRecette commentaire = new CommentaireRecette();
        commentaire.setRecette(recette);
        commentaire.setUser(user);
        commentaire.setContenu("Cette recette est délicieuse !");

        dao.create(commentaire);
        System.out.println("Liste des commentaires :");
        for (CommentaireRecette c : dao.findAll()) {
            System.out.println("ID: " + c.getId() + " | Recette: " + c.getRecette().getTitre() +
                    " | User: " + c.getUser().getNom() + " | Commentaire: " + c.getContenu());
        }
        // dao.delete(dao.findById(1));
        */
        /*
        UtilisationQuantiteDao uqDao = new UtilisationQuantiteDao();
        Recette recette = new Recette("Salade", "Mélanger tous les ingrédients.");
        Ingredient ingredient = new Ingredient();
        ingredient.setNom("Tomate");
        
        UtilisationQuantite uq = new UtilisationQuantite();
        uq.setRecette(recette);
        uq.setIngredient(ingredient);
        uq.setQuantite("2 Tomates");
        uqDao.create(uq);
        for (UtilisationQuantite uqItem : uqDao.findAll()) {
            System.out.println("Quantité: " + uqItem.getQuantite() + ", Recette: " + uqItem.getRecette().getTitre() + ", Ingrédient: " + uqItem.getIngredient().getNom());
        }
        */
    }
} 
