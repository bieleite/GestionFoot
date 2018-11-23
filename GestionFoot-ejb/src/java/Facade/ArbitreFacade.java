/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Arbitre;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author gabrielleite
 */
@Stateless
public class ArbitreFacade extends AbstractFacade<Arbitre> implements ArbitreFacadeLocal {

    @PersistenceContext(unitName = "GestionFoot-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArbitreFacade() {
        super(Arbitre.class);
    }

    @Override
    public void CreerArbitre(String Nom, String Prenom, String Login, String Pass) {
        Arbitre f = new Arbitre();
        f.setNom(Nom);
        f.setPrenom(Prenom);
        f.setLogin(Login);
        f.setPass(Pass);
        em.persist(f);
    }
        @Override
    public List<Arbitre> listArbitre() {
        List<Arbitre> fo=null;
        String txt="SELECT fo FROM Arbitre AS fo ";
        Query req=getEntityManager().createQuery(txt);
        List<Arbitre> result=req.getResultList();
        return result;
    }

    @Override
    public Arbitre rechercheArbitre(Long id) {
        Arbitre f = null;        
        String txt = "SELECT f FROM Arbitre AS f WHERE f.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);  
        List<Arbitre> res = req.getResultList();
        if (res.size() >= 1)
        {
              f = (Arbitre) res.get(0);
        }
        return f;
    }
    @Override
    public Arbitre authentification(String login, String mdp) {
        Arbitre result=null;
        String txt="SELECT c FROM Arbitre AS c WHERE c.Login=:login and c.MotDePasse=:mdp";
        Query req=getEntityManager().createQuery(txt);
        req=req.setParameter("login",login);
        req=req.setParameter("mdp", mdp);
        List<Arbitre> l=req.getResultList();
        for(Arbitre ag:l){
            result=ag;
        }
        return result;
    }
    
        @Override
    public  Arbitre rechercheArbitreParNom(String nom) {
        Arbitre e = null;        
        String txt = "SELECT e FROM Arbitre AS e WHERE e.Nom=:nom ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("nom", nom);
        List<Arbitre> res = req.getResultList();
        if (res.size() >= 1)
        {
              e = (Arbitre) res.get(0);
        }
        return e;
        
    }
    
    @Override
    public  Arbitre rechercheArbitreParNomEtPrenom(String nom,String prenom) {
        Arbitre e = null;        
        String txt = "SELECT e FROM Arbitre AS e WHERE e.Nom=:nom and e.Prenom=:prenom ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("nom", nom);
        req = req.setParameter("prenom", prenom);
        List<Arbitre> res = req.getResultList();
        if (res.size() >= 1)
        {
              e = (Arbitre) res.get(0);
        }
        return e;
        
    }
    
}
