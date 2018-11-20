/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author gabrielleite
 */
@Entity
public class Contrat_Jouer implements Serializable {

    private double Salaire;

    /**
     * Get the value of Salaire
     *
     * @return the value of Salaire
     */
    public double getSalaire() {
        return Salaire;
    }

    /**
     * Set the value of Salaire
     *
     * @param Salaire new value of Salaire
     */
    public void setSalaire(double Salaire) {
        this.Salaire = Salaire;
    }

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

    private Jouer Joeur;

    /**
     * Get the value of Joeur
     *
     * @return the value of Joeur
     */
    public Jouer getJoeur() {
        return Joeur;
    }

    /**
     * Set the value of Joeur
     *
     * @param Joeur new value of Joeur
     */
    public void setJoeur(Jouer Joeur) {
        this.Joeur = Joeur;
    }

    private Date Date_fin;

    /**
     * Get the value of Date_fin
     *
     * @return the value of Date_fin
     */
    public Date getDate_fin() {
        return Date_fin;
    }

    /**
     * Set the value of Date_fin
     *
     * @param Date_fin new value of Date_fin
     */
    public void setDate_fin(Date Date_fin) {
        this.Date_fin = Date_fin;
    }

    private Date Date_Debut;

    /**
     * Get the value of Date_Debut
     *
     * @return the value of Date_Debut
     */
    public Date getDate_Debut() {
        return Date_Debut;
    }

    /**
     * Set the value of Date_Debut
     *
     * @param Date_Debut new value of Date_Debut
     */
    public void setDate_Debut(Date Date_Debut) {
        this.Date_Debut = Date_Debut;
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
        if (!(object instanceof Contrat_Jouer)) {
            return false;
        }
        Contrat_Jouer other = (Contrat_Jouer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entite.Contrat_Jouer[ id=" + id + " ]";
    }
    
}
