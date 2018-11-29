/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Equipe;
import Entite.Jouer;
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
public class JouerFacade extends AbstractFacade<Jouer> implements JouerFacadeLocal {

    @PersistenceContext(unitName = "GestionFoot-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JouerFacade() {
        super(Jouer.class);
    }
    
    @Override
    public void CreerJouer(String Nom, String Prenom) {
        Jouer f = new Jouer();
        f.setNom(Nom);
        f.setPrenom(Prenom);
        em.persist(f);
    }
    
    @Override
    public List<Jouer> listJouer() {
        List<Jouer> fo=null;
        String txt="SELECT fo FROM Jouer AS fo ";
        Query req=getEntityManager().createQuery(txt);
        List<Jouer> result=req.getResultList();
        return result;
    }
    
    @Override
    public List<Jouer> listJouerEquipe(Equipe e) {
        List<Jouer> fo=null;
        String txt="SELECT fo FROM Jouer AS fo WHERE fo.Equipe=:eq ";
        Query req=getEntityManager().createQuery(txt);
        req = req.setParameter("eq", e);
        List<Jouer> result=req.getResultList();
        return result;
    }
 
    @Override
    public Jouer rechercheJouer(Long id) {
        Jouer f = null;        
        String txt = "SELECT f FROM Jouer AS f WHERE f.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);  
        List<Jouer> res = req.getResultList();
        if (res.size() >= 1)
        {
              f = (Jouer) res.get(0);
        }
        return f;
    }
    
        @Override
        public  Jouer rechercheJouerParEquipe(Equipe equi) {
        Jouer j = null;        
        String txt = "SELECT j FROM Jouer AS j WHERE j.Equipe=:equi ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("equi", equi);
        List<Jouer> res = req.getResultList();
        if (res.size() >= 1)
        {
              j = (Jouer) res.get(0);
        }
        return j;
        
    }
        @Override
        public  Jouer rechercheJouerParNom(String nom) {
        Jouer j = null;        
        String txt = "SELECT j FROM Jouer AS j WHERE j.Nom=:nom ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("nom", nom);
        List<Jouer> res = req.getResultList();
        if (res.size() >= 1)
        {
              j = (Jouer) res.get(0);
        }
        return j;
        }
        
        @Override
        public  Jouer rechercheJouerSansEquipeParNom(String nom) {
        Jouer j = null;        
        String txt = "SELECT j FROM Jouer AS j WHERE j.Nom=:nom AND j.Equipe IS EMPTY";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("nom", nom);
        List<Jouer> res = req.getResultList();
        if (res.size() >= 1)
        {
              j = (Jouer) res.get(0);
        }
        return j;
        }
        
        @Override
        public void modifEquipe(long Nom, Equipe equi) { 
            Jouer jo = null;
            String txt = "SELECT jo FROM Jouer AS jo WHERE jo.id=:nom";
            Query req = getEntityManager().createQuery(txt);
            req = req.setParameter("nom", Nom);
            List<Jouer> res = req.getResultList();
            if (res.size() >= 1)
            {
                  jo = (Jouer) res.get(0);
                  jo.setEquipe(equi);
                  em.merge(jo);
            }
        }
        
        @Override
        public Jouer supprimerJouer(Jouer c) {
        Jouer co=null;
        String txt="SELECT co FROM Jouer AS co WHERE co.numero=:numcompte" ;
        Query req=getEntityManager().createQuery(txt);
        req=req.setParameter("numclient", c);
        List<Jouer> result=req.getResultList();
        if(result.size()==1){
                em.remove(co);
        }
        return co;
    }
}
