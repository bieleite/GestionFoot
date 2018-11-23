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
public class Classement implements Serializable {

    @ManyToOne
    private Championnat leChampionnat;

    /**
     * Get the value of leChampionnat
     *
     * @return the value of leChampionnat
     */
    public Championnat getLeChampionnat() {
        return leChampionnat;
    }

    /**
     * Set the value of leChampionnat
     *
     * @param leChampionnat new value of leChampionnat
     */
    public void setLeChampionnat(Championnat leChampionnat) {
        this.leChampionnat = leChampionnat;
    }

    @ManyToOne
    private Equipe leEquipe;

    /**
     * Get the value of leEquipe
     *
     * @return the value of leEquipe
     */
    public Equipe getLeEquipe() {
        return leEquipe;
    }

    /**
     * Set the value of leEquipe
     *
     * @param leEquipe new value of leEquipe
     */
    public void setLeEquipe(Equipe leEquipe) {
        this.leEquipe = leEquipe;
    }

    private int Point;

    /**
     * Get the value of Point
     *
     * @return the value of Point
     */
    public int getPoint() {
        return Point;
    }

    /**
     * Set the value of Point
     *
     * @param Point new value of Point
     */
    public void setPoint(int Point) {
        this.Point = Point;
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
        if (!(object instanceof Classement)) {
            return false;
        }
        Classement other = (Classement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entite.Classement[ id=" + id + " ]";
    }
    
}
