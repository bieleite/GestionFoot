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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author gabrielleite
 */
@Entity
public class Equipe implements Serializable {

    @OneToMany(mappedBy = "Equipe_Home")
    private List<Match> matchs;

    @OneToMany(mappedBy = "Equipe")
    private List<Contrat_Jouer> contrat_Jouers;

    @OneToMany(mappedBy = "Equipe")
    private List<Buts> butss;

    @OneToMany(mappedBy = "Equipe")
    private List<Jouer> jouers;

    @OneToOne(mappedBy = "Equipe")
    private Entraineur entraineur;

    @OneToMany(mappedBy = "Equipe")
    private List<Contrat_Entraineur> contrat_Entraineurs;

    @OneToMany(mappedBy = "Equipe")
    private List<Composition> compositions;

    @ManyToOne

    private Stade Stade;

    /**
     * Get the value of Stade
     *
     * @return the value of Stade
     */
    public Stade getStade() {
        return Stade;
    }

    /**
     * Set the value of Stade
     *
     * @param Stade new value of Stade
     */
    public void setStade(Stade Stade) {
        this.Stade = Stade;
    }

    private String Adresse_Equipe;

    /**
     * Get the value of Adresse_Equipe
     *
     * @return the value of Adresse_Equipe
     */
    public String getAdresse_Equipe() {
        return Adresse_Equipe;
    }

    /**
     * Set the value of Adresse_Equipe
     *
     * @param Adresse_Equipe new value of Adresse_Equipe
     */
    public void setAdresse_Equipe(String Adresse_Equipe) {
        this.Adresse_Equipe = Adresse_Equipe;
    }

    private String Nom_Equipe;

    /**
     * Get the value of Nom_Equipe
     *
     * @return the value of Nom_Equipe
     */
    public String getNom_Equipe() {
        return Nom_Equipe;
    }

    /**
     * Set the value of Nom_Equipe
     *
     * @param Nom_Equipe new value of Nom_Equipe
     */
    public void setNom_Equipe(String Nom_Equipe) {
        this.Nom_Equipe = Nom_Equipe;
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
        if (!(object instanceof Equipe)) {
            return false;
        }
        Equipe other = (Equipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entite.Equipe[ id=" + id + " ]";
    }
    
}
