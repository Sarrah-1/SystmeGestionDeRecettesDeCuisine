package entities;

import javax.persistence.*;

@Entity
@Table(name = "CommentairesRecette")
public class CommentaireRecette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "recette_id")
    private Recette recette;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String contenu;

    public CommentaireRecette() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Recette getRecette() {
        return recette;
    }

    public void setRecette(Recette recette) {
        this.recette = recette;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}
