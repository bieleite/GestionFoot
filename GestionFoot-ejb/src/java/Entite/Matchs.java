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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author gabrielleite
 */
@Entity
public class Matchs implements Serializable {

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

    private Resultat Resultat_home;

    /**
     * Get the value of Resultat_home
     *
     * @return the value of Resultat_home
     */
    public Resultat getResultat_home() {
        return Resultat_home;
    }

    /**
     * Set the value of Resultat_home
     *
     * @param Resultat_home new value of Resultat_home
     */
    public void setResultat_home(Resultat Resultat_home) {
        this.Resultat_home = Resultat_home;
    }

    private Resultat Resultat_away;

    /**
     * Get the value of Resultat_away
     *
     * @return the value of Resultat_away
     */
    public Resultat getResultat_away() {
        return Resultat_away;
    }

    /**
     * Set the value of Resultat_away
     *
     * @param Resultat_away new value of Resultat_away
     */
    public void setResultat_away(Resultat Resultat_away) {
        this.Resultat_away = Resultat_away;
    }

    @OneToMany(mappedBy = "leMatch")
    private List<Buts> butss;

    @OneToMany(mappedBy = "Match")
    private List<Fautes> fautess;

    private int Score_Away;

    /**
     * Get the value of Score_Away
     *
     * @return the value of Score_Away
     */
    public int getScore_Away() {
        return Score_Away;
    }

    /**
     * Set the value of Score_Away
     *
     * @param Score_Away new value of Score_Away
     */
    public void setScore_Away(int Score_Away) {
        this.Score_Away = Score_Away;
    }

    private int Score_Home;

    /**
     * Get the value of Score_Home
     *
     * @return the value of Score_Home
     */
    public int getScore_Home() {
        return Score_Home;
    }

    /**
     * Set the value of Score_Home
     *
     * @param Score_Home new value of Score_Home
     */
    public void setScore_Home(int Score_Home) {
        this.Score_Home = Score_Home;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Dt_Match;

    /**
     * Get the value of Dt_Match
     *
     * @return the value of Dt_Match
     */
    public Date getDate() {
        return Dt_Match;
    }

    /**
     * Set the value of Dt_Match
     *
     * @param Date new value of Dt_Match
     */
    public void setDate(Date Date) {
        this.Dt_Match = Date;
    }

    @ManyToOne
    private Composition Composition_Away;

    /**
     * Get the value of Composition_Away
     *
     * @return the value of Composition_Away
     */
    public Composition getComposition_Away() {
        return Composition_Away;
    }

    /**
     * Set the value of Composition_Away
     *
     * @param Composition_Away new value of Composition_Away
     */
    public void setComposition_Away(Composition Composition_Away) {
        this.Composition_Away = Composition_Away;
    }

    @ManyToOne
    private Composition Composition_Home;

    /**
     * Get the value of Composition_Home
     *
     * @return the value of Composition_Home
     */
    public Composition getComposition_Home() {
        return Composition_Home;
    }

    /**
     * Set the value of Composition_Home
     *
     * @param Composition_Home new value of Composition_Home
     */
    public void setComposition_Home(Composition Composition_Home) {
        this.Composition_Home = Composition_Home;
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
    private Equipe Equipe_Home;

    /**
     * Get the value of Equipe_Home
     *
     * @return the value of Equipe_Home
     */
    public Equipe getEquipe_Home() {
        return Equipe_Home;
    }

    /**
     * Set the value of Equipe_Home
     *
     * @param Equipe_Home new value of Equipe_Home
     */
    public void setEquipe_Home(Equipe Equipe_Home) {
        this.Equipe_Home = Equipe_Home;
    }


    @ManyToOne
    private Equipe Equipe_Away;

    /**
     * Get the value of Equipe_Away
     *
     * @return the value of Equipe_Away
     */
    public Equipe getEquipe_Away() {
        return Equipe_Away;
    }

    /**
     * Set the value of Equipe_Away
     *
     * @param Equipe_Away new value of Equipe_Away
     */
    public void setEquipe_Away(Equipe Equipe_Away) {
        this.Equipe_Away = Equipe_Away;
    }

    @ManyToOne
    private Stade Stade;

    /**
     * Get the value of Stade
     *
     * @return the value of Stade
     */
    public Stade getStade() {
        return Stade;
    }

    /**
     * Set the value of Stade
     *
     * @param Stade new value of Stade
     */
    public void setStade(Stade Stade) {
        this.Stade = Stade;
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
        if (!(object instanceof Matchs)) {
            return false;
        }
        Matchs other = (Matchs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entite.Match[ id=" + id + " ]";
    }
    
}
