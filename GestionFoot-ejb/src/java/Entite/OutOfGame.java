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
public class OutOfGame implements Serializable {

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Dt_FinOut;

    /**
     * Get the value of Dt_FinOut
     *
     * @return the value of Dt_FinOut
     */
    public Date getDt_FinOut() {
        return Dt_FinOut;
    }

    /**
     * Set the value of Dt_FinOut
     *
     * @param Dt_FinOut new value of Dt_FinOut
     */
    public void setDt_FinOut(Date Dt_FinOut) {
        this.Dt_FinOut = Dt_FinOut;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Dt_DebutOut;

    /**
     * Get the value of Dt_DebutOut
     *
     * @return the value of Dt_DebutOut
     */
    public Date getDt_DebutOut() {
        return Dt_DebutOut;
    }

    /**
     * Set the value of Dt_DebutOut
     *
     * @param Dt_DebutOut new value of Dt_DebutOut
     */
    public void setDt_DebutOut(Date Dt_DebutOut) {
        this.Dt_DebutOut = Dt_DebutOut;
    }

    @ManyToOne
    private Jouer leJouer;

    /**
     * Get the value of leJouer
     *
     * @return the value of leJouer
     */
    public Jouer getLeJouer() {
        return leJouer;
    }

    /**
     * Set the value of leJouer
     *
     * @param leJouer new value of leJouer
     */
    public void setLeJouer(Jouer leJouer) {
        this.leJouer = leJouer;
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
        if (!(object instanceof OutOfGame)) {
            return false;
        }
        OutOfGame other = (OutOfGame) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entite.OutOfGame[ id=" + id + " ]";
    }
    
}
