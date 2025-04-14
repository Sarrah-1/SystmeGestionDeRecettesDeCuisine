package entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name = "Recette.findByCategorie", query = "FROM Recette r WHERE r.categorie = :categorie"),
    @NamedQuery(name = "Recette.findByUtilisateur", query = "FROM Recette r WHERE r.utilisateur = :utilisateur"),
    @NamedQuery(name = "Recette.searchByTitre", query = "FROM Recette r WHERE LOWER(r.titre) LIKE LOWER(CONCAT('%', :keyword, '%'))")
})

@Table(name = "Recettes")
public class Recette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "titre")
    private String titre;
    private String instructions;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "categorie")
    private List<Recette> recettes;

    @OneToMany(mappedBy = "recette", cascade = CascadeType.ALL)
    private List<CommentaireRecette> commentaires;

    @OneToMany(mappedBy = "recette", cascade = CascadeType.ALL)
    private List<UtilisationQuantite> utilisations;

    public Recette() {
    }

    public Recette(String titre, String instructions) {
        this.titre = titre;
        this.instructions = instructions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Categorie getCategorie() {
        return categorie;
    }

}
