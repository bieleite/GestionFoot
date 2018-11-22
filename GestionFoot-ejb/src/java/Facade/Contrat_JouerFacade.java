/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Contrat_Jouer;
import Entite.Entraineur;
import Entite.Equipe;
import Entite.Jouer;
import Entite.Statut;
import java.util.Date;
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
public class Contrat_JouerFacade extends AbstractFacade<Contrat_Jouer> implements Contrat_JouerFacadeLocal {

    @PersistenceContext(unitName = "GestionFoot-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Contrat_JouerFacade() {
        super(Contrat_Jouer.class);
    }
    
    @Override
    public void CreerContrat_Jouer(Statut status,double salaire, Equipe equipe,Jouer jouer, Date dt_fin, Date dt_debut) {
        Contrat_Jouer f = new Contrat_Jouer();
        f.setStatus(status);
        f.setSalaire(salaire);
        f.setEquipe(equipe);
        f.setJoeur(jouer);
        f.setDate_fin(dt_fin);
        f.setDate_Debut(dt_debut);
        em.persist(f);
    }
    
    @Override
    public List<Contrat_Jouer> listContrat_Jouer() {
        List<Contrat_Jouer> fo=null;
        String txt="SELECT fo FROM Contrat_Jouer AS fo ";
        Query req=getEntityManager().createQuery(txt);
        List<Contrat_Jouer> result=req.getResultList();
        return result;
    }

    @Override
    public Contrat_Jouer rechercheContrat_Jouer(Long id) {
        Contrat_Jouer f = null;        
        String txt = "SELECT f FROM Contrat_Jouer AS f WHERE f.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);  
        List<Contrat_Jouer> res = req.getResultList();
        if (res.size() >= 1)
        {
              f = (Contrat_Jouer) res.get(0);
        }
        return f;
    }
    @Override
    public Contrat_Jouer rechercheContrat_JouerParJouer(Jouer jouer) {
        Contrat_Jouer f = null;        
        String txt = "SELECT f FROM Contrat_Jouer AS f WHERE f.Jouer=:joeur";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("joeur", jouer);  
        List<Contrat_Jouer> res = req.getResultList();
        if (res.size() >= 1)
        {
              f = (Contrat_Jouer) res.get(0);
        }
        return f;
    }
    
    @Override
    public void modifStatutInactif(Jouer jo, Contrat_Jouer con) { 
            String txt = "SELECT con FROM Contrat_Jouer AS con WHERE con.Jouer=:jo";
            Query req = getEntityManager().createQuery(txt);
            req = req.setParameter("jo", jo);
            List<Contrat_Jouer> res = req.getResultList();
            if (res.size() >= 1)
            {
                  con = (Contrat_Jouer) res.get(0);
                  con.setStatus(Statut.In);
                  em.merge(con);
            }
        }
    @Override
    public void modifStatutActif(Jouer jo) { 
            Contrat_Jouer con= null;
            String txt = "SELECT con FROM Contrat_Jouer AS con WHERE con.Jouer=:jo";
            Query req = getEntityManager().createQuery(txt);
            req = req.setParameter("jo", jo);
            List<Contrat_Jouer> res = req.getResultList();
            if (res.size() >= 1)
            {
                  con = (Contrat_Jouer) res.get(0);
                  con.setStatus(Statut.Ac);
                  em.merge(con);
            }
        }
}
