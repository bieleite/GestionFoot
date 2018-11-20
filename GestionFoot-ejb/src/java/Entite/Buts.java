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

/**
 *
 * @author gabrielleite
 */
@Entity
public class Buts implements Serializable {

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

    private Match Match;

    /**
     * Get the value of Match
     *
     * @return the value of Match
     */
    public Match getMatch() {
        return Match;
    }

    /**
     * Set the value of Match
     *
     * @param Match new value of Match
     */
    public void setMatch(Match Match) {
        this.Match = Match;
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