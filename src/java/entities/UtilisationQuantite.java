package entities;

import javax.persistence.*;

@Entity
public class UtilisationQuantite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String quantite;

    @ManyToOne
    @JoinColumn(name = "recette_id")
    private Recette recette;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    public UtilisationQuantite() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public Recette getRecette() {
        return recette;
    }

    public void setRecette(Recette recette) {
        this.recette = recette;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
