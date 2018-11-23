/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.io.Serializable;
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
public class Buts implements Serializable {

    @ManyToOne
    private Match leMatch;

    /**
     * Get the value of leMatch
     *
     * @return the value of leMatch
     */
    public Match getLeMatch() {
        return leMatch;
    }

    /**
     * Set the value of leMatch
     *
     * @param leMatch new value of leMatch
     */
    public void setLeMatch(Match leMatch) {
        this.leMatch = leMatch;
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

    @ManyToOne
    private Jouer Jouer;

    /**
     * Get the value of Jouer
     *
     * @return the value of Jouer
     */
    public Jouer getJouer() {
        return Jouer;
    }

    /**
     * Set the value of Jouer
     *
     * @param Jouer new value of Jouer
     */
    public void setJouer(Jouer Jouer) {
        this.Jouer = Jouer;
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
        if (!(object instanceof Buts)) {
            return false;
        }
        Buts other = (Buts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entite.Buts[ id=" + id + " ]";
    }
    
}
