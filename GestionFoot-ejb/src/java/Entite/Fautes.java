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
public class Fautes implements Serializable {

    private Carton Carton;

    /**
     * Get the value of Carton
     *
     * @return the value of Carton
     */
    public Carton getCarton() {
        return Carton;
    }

    /**
     * Set the value of Carton
     *
     * @param Carton new value of Carton
     */
    public void setCarton(Carton Carton) {
        this.Carton = Carton;
    }

    @ManyToOne
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

    @ManyToOne
    private Arbitre Arbitre;

    /**
     * Get the value of Arbitre
     *
     * @return the value of Arbitre
     */
    public Arbitre getArbitre() {
        return Arbitre;
    }

    /**
     * Set the value of Arbitre
     *
     * @param Arbitre new value of Arbitre
     */
    public void setArbitre(Arbitre Arbitre) {
        this.Arbitre = Arbitre;
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
        if (!(object instanceof Fautes)) {
            return false;
        }
        Fautes other = (Fautes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entite.Fautes[ id=" + id + " ]";
    }
    
}
