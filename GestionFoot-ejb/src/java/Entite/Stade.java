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
import javax.persistence.OneToMany;

/**
 *
 * @author gabrielleite
 */
@Entity
public class Stade implements Serializable {

    @OneToMany(mappedBy = "Stade")
    private List<Matchs> matchs;

    @OneToMany(mappedBy = "Stade")
    private List<Equipe> equipes;

    private String Adresse_Stade;

    /**
     * Get the value of Adresse_Stade
     *
     * @return the value of Adresse_Stade
     */
    public String getAdresse_Stade() {
        return Adresse_Stade;
    }

    /**
     * Set the value of Adresse_Stade
     *
     * @param Adresse_Stade new value of Adresse_Stade
     */
    public void setAdresse_Stade(String Adresse_Stade) {
        this.Adresse_Stade = Adresse_Stade;
    }


    private int Capacite;

    /**
     * Get the value of Capacite
     *
     * @return the value of Capacite
     */
    public int getCapacite() {
        return Capacite;
    }

    /**
     * Set the value of Capacite
     *
     * @param Capacite new value of Capacite
     */
    public void setCapacite(int Capacite) {
        this.Capacite = Capacite;
    }

    private String Nom_Stade;

    /**
     * Get the value of Nom_Stade
     *
     * @return the value of Nom_Stade
     */
    public String getNom_Stade() {
        return Nom_Stade;
    }

    /**
     * Set the value of Nom_Stade
     *
     * @param Nom_Stade new value of Nom_Stade
     */
    public void setNom_Stade(String Nom_Stade) {
        this.Nom_Stade = Nom_Stade;
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
        if (!(object instanceof Stade)) {
            return false;
        }
        Stade other = (Stade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entite.Stade[ id=" + id + " ]";
    }
    
}
