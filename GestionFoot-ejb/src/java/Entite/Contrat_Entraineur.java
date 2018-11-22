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
import javax.persistence.ManyToOne;

/**
 *
 * @author gabrielleite
 */
@Entity
public class Contrat_Entraineur implements Serializable {

    private Statut Status;

    /**
     * Get the value of Status
     *
     * @return the value of Status
     */
    public Statut getStatus() {
        return Status;
    }

    /**
     * Set the value of Status
     *
     * @param Status new value of Status
     */
    public void setStatus(Statut Status) {
        this.Status = Status;
    }

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

    private Entraineur Entraineur;

    /**
     * Get the value of Entraineur
     *
     * @return the value of Entraineur
     */
    public Entraineur getEntraineur() {
        return Entraineur;
    }

    /**
     * Set the value of Entraineur
     *
     * @param Entraineur new value of Entraineur
     */
    public void setEntraineur(Entraineur Entraineur) {
        this.Entraineur = Entraineur;
    }

    private Date Date_Fin;

    /**
     * Get the value of Date_Fin
     *
     * @return the value of Date_Fin
     */
    public Date getDate_Fin() {
        return Date_Fin;
    }

    /**
     * Set the value of Date_Fin
     *
     * @param Date_Fin new value of Date_Fin
     */
    public void setDate_Fin(Date Date_Fin) {
        this.Date_Fin = Date_Fin;
    }

    private Date Date_debut;

    /**
     * Get the value of Date_debut
     *
     * @return the value of Date_debut
     */
    public Date getDate_debut() {
        return Date_debut;
    }

    /**
     * Set the value of Date_debut
     *
     * @param Date_debut new value of Date_debut
     */
    public void setDate_debut(Date Date_debut) {
        this.Date_debut = Date_debut;
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
        if (!(object instanceof Contrat_Entraineur)) {
            return false;
        }
        Contrat_Entraineur other = (Contrat_Entraineur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entite.Contrat_Entraineur[ id=" + id + " ]";
    }
    
}
