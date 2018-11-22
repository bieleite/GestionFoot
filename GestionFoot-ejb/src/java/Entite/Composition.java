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
import javax.persistence.Temporal;

/**
 *
 * @author gabrielleite
 */
@Entity
public class Composition implements Serializable {

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Date_Comp;

    /**
     * Get the value of Date_Comp
     *
     * @return the value of Date_Comp
     */
    public Date getDate_Comp() {
        return Date_Comp;
    }

    /**
     * Set the value of Date_Comp
     *
     * @param Date_Comp new value of Date_Comp
     */
    public void setDate_Comp(Date Date_Comp) {
        this.Date_Comp = Date_Comp;
    }

    @ManyToOne
    private Equipe Equipe;

    /**
     * Get the value of Equipe
     *
     * @return the value of Entraineur
     */
    public Equipe getEquipe() {
        return Equipe;
    }

    /**
     * Set the value of Equipe
     *
     * @param Equipe new value of Entraineur
     */
    public void setEquipe(Equipe Equipe) {
        this.Equipe = Equipe;
    }

    @ManyToOne
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
        if (!(object instanceof Composition)) {
            return false;
        }
        Composition other = (Composition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entite.Composition[ id=" + id + " ]";
    }
    
}
