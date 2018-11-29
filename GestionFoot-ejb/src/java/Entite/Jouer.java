/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author gabrielleite
 */
@Entity
public class Jouer implements Serializable {

    @OneToMany(mappedBy = "leJouer")
    private List<OutOfGame> outOfGames;

    @OneToMany(mappedBy = "Joeur")
    private List<Fautes> fautess;

    @OneToMany(mappedBy = "Joeur")
    private List<Contrat_Jouer> contrat_Jouers;

    @OneToMany(mappedBy = "Jouer")
    private List<Buts> butss;

    @ManyToMany(mappedBy = "jouers")
    private List<Composition> compositions;

    @ManyToOne
    private Equipe Equipe;

    /**
     * Get the value of Equipe
     *
     * @return the value of Equipe
     */
    public Equipe getEquipe() {
        return Equipe;
    }

    /**
     * Set the value of Equipe
     *
     * @param Equipe new value of Equipe
     */
    public void setEquipe(Equipe Equipe) {
        this.Equipe = Equipe;
    }

    private String Prenom;

    /**
     * Get the value of Prenom
     *
     * @return the value of Prenom
     */
    public String getPrenom() {
        return Prenom;
    }

    /**
     * Set the value of Prenom
     *
     * @param Prenom new value of Prenom
     */
    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    private String Nom;

    /**
     * Get the value of Nom
     *
     * @return the value of Nom
     */
    public String getNom() {
        return Nom;
    }

    /**
     * Set the value of Nom
     *
     * @param Nom new value of Nom
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jouer)) {
            return false;
        }
        Jouer other = (Jouer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entite.Jouer[ id=" + id + " ]";
    }
    
}
