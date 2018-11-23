/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author gabrielleite
 */
@Entity
public class Championnat implements Serializable {

    @OneToMany(mappedBy = "leChampionnat")
    private List<Classement> classements;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Dt_Fin_Champio;

    /**
     * Get the value of Dt_Fin_Champio
     *
     * @return the value of Dt_Fin_Champio
     */
    public Date getDt_Fin_Champio() {
        return Dt_Fin_Champio;
    }

    /**
     * Set the value of Dt_Fin_Champio
     *
     * @param Dt_Fin_Champio new value of Dt_Fin_Champio
     */
    public void setDt_Fin_Champio(Date Dt_Fin_Champio) {
        this.Dt_Fin_Champio = Dt_Fin_Champio;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Dt_debut_champio;

    /**
     * Get the value of Dt_debut_champio
     *
     * @return the value of Dt_debut_champio
     */
    public Date getDt_debut_champio() {
        return Dt_debut_champio;
    }

    /**
     * Set the value of Dt_debut_champio
     *
     * @param Dt_debut_champio new value of Dt_debut_champio
     */
    public void setDt_debut_champio(Date Dt_debut_champio) {
        this.Dt_debut_champio = Dt_debut_champio;
    }

    private String Nom_Championnat;

    /**
     * Get the value of Nom_Championnat
     *
     * @return the value of Nom_Championnat
     */
    public String getNom_Championnat() {
        return Nom_Championnat;
    }

    /**
     * Set the value of Nom_Championnat
     *
     * @param Nom_Championnat new value of Nom_Championnat
     */
    public void setNom_Championnat(String Nom_Championnat) {
        this.Nom_Championnat = Nom_Championnat;
    }

    @OneToMany(mappedBy = "leChampionnat")
    private List<Matchs> matchss;

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
        if (!(object instanceof Championnat)) {
            return false;
        }
        Championnat other = (Championnat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entite.Championnat[ id=" + id + " ]";
    }
    
}
