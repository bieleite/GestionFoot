/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author gabrielleite
 */
@Entity
public class Arbitre implements Serializable {

    @OneToMany(mappedBy = "Arbitre")
    private List<Matchs> matchs;

    @OneToMany(mappedBy = "Arbitre")
    private List<Fautes> fautess;
    @Column(nullable=false)
    private String Pass;

    /**
     * Get the value of Pass
     *
     * @return the value of Pass
     */
    public String getPass() {
        return Pass;
    }

    /**
     * Set the value of Pass
     *
     * @param Pass new value of Pass
     */
    public void setPass(String Pass) {
        this.Pass = Pass;
    }
    @Column(nullable=false, unique=true)
    private String Login;

    /**
     * Get the value of Login
     *
     * @return the value of Login
     */
    public String getLogin() {
        return Login;
    }

    /**
     * Set the value of Login
     *
     * @param Login new value of Login
     */
    public void setLogin(String Login) {
        this.Login = Login;
    }
    @Column(nullable=false)
    private String Prenom;

    /**
     * Get the value of Prenom
     *
     * @return the value of Prenom
     */
    public String getPrenom() {
        return Prenom;
    }

    /**
     * Set the value of Prenom
     *
     * @param Prenom new value of Prenom
     */
    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }
    @Column(nullable=false)
    private String Nom;

    /**
     * Get the value of Nom
     *
     * @return the value of Nom
     */
    public String getNom() {
        return Nom;
    }

    /**
     * Set the value of Nom
     *
     * @param Nom new value of Nom
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
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
        if (!(object instanceof Arbitre)) {
            return false;
        }
        Arbitre other = (Arbitre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entite.Arbitres[ id=" + id + " ]";
    }
    
}
