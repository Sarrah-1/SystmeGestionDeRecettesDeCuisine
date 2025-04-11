package entities;

import javax.persistence.Entity;

@Entity
public class Admin extends User{
    
    private String matricule;

    public Admin() {
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    
}
