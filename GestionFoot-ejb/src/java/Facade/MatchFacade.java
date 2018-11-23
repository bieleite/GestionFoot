/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Arbitre;
import Entite.Buts;
import Entite.Composition;
import Entite.Equipe;
import Entite.Stade;
import Entite.Match;
import Entite.Resultat;
import java.util.Date;
import java.util.HashSet;
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
public class MatchFacade extends AbstractFacade<Match> implements MatchFacadeLocal {

    @PersistenceContext(unitName = "GestionFoot-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MatchFacade() {
        super(Match.class);
    }

    @Override
    public void CreerMatch(Date date,Stade stade, Equipe equipea,Equipe equipeb,Arbitre arbitre) {
        Match m = new Match();
        m.setDate(date);
        m.setStade(stade);
        m.setEquipe_Home(equipeb);
        m.setEquipe_Away(equipea);
        m.setArbitre(arbitre);
        em.persist(m);
    }
    
    @Override
    public List<Match> listMatch() {
        List<Match> fo=null;
        String txt="SELECT fo FROM Match AS fo ";
        Query req=getEntityManager().createQuery(txt);
        List<Match> result=req.getResultList();
        return result;
    }

    @Override
    public Match rechercheMatch(Long id) {
        Match f = null;        
        String txt = "SELECT f FROM Match AS f WHERE f.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);  
        List<Match> res = req.getResultList();
        if (res.size() >= 1)
        {
              f = (Match) res.get(0);
        }
        return f;
    }
    
    @Override
    public List<Match> rechercheMatchStadeDate(Stade stad,Date dt) {
        String txt = "SELECT mat FROM Match AS mat WHERE mat.Stade=:stad and mat.Date=:dt";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("stad", stad);
        req = req.setParameter("dt", dt);
        List<Match> res = req.getResultList();
        return res;
        
    }
    @Override
    public List<Match> rechercheMatchArbitreDate(Arbitre arb,Date dt) {
        String txt = "SELECT mat FROM Match AS mat WHERE mat.Arbitre=:arb and mat.Date=:dt";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("stad", arb);
        req = req.setParameter("dt", dt);
        List<Match> res = req.getResultList();
        return res;
        
    }
    
    @Override
    public void modifCompositionAway(Composition Com, Equipe equi) { 
            Match ent = null;
            String txt = "SELECT ent FROM Match AS det WHERE ent.Equipe=:nom";
            Query req = getEntityManager().createQuery(txt);
            req = req.setParameter("nom", equi);
            List<Match> res = req.getResultList();
            if (res.size() >= 1)
            {
                  ent = (Match) res.get(0);
                  ent.setComposition_Away(Com);
                  em.merge(ent);
            }
        }
        @Override
        public void modifCompositionHome(Composition Com, Equipe equi) { 
            Match ent = null;
            String txt = "SELECT ent FROM Match AS det WHERE ent.Equipe=:nom";
            Query req = getEntityManager().createQuery(txt);
            req = req.setParameter("nom", equi);
            List<Match> res = req.getResultList();
            if (res.size() >= 1)
            {
                  ent = (Match) res.get(0);
                  ent.setComposition_Home(Com);
                  em.merge(ent);
            }
        }
        
        @Override
        public Match rechercheMatchParArbitreEtDate(Arbitre arb, Date dt_match) {
        Match f = null;        
        String txt = "SELECT f FROM Match AS f WHERE f.Arbitre=:arb and f.Dt_Match=:dt";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("arb", arb);
        req = req.setParameter("dt", dt_match);
        List<Match> res = req.getResultList();
        if (res.size() >= 1)
        {
              f = (Match) res.get(0);
        }
        return f;
    }
        @Override
        public void setResultat_Away(Arbitre arb, Date dt_match,Resultat resul) { 
            Match m=null;
            String txt = "SELECT m FROM Match AS m WHERE m.Arbitre=:arb and m.Dt_Match=:dt ";
            Query req = getEntityManager().createQuery(txt);
            req = req.setParameter("arb", arb);
            req = req.setParameter("dt", dt_match);
            List<Match> res = req.getResultList();
            if (res.size() >= 1)
            {
                  m = (Match) res.get(0);
                  m.setResultat_away(resul);
                  em.merge(m);
            }
        }
        
        @Override
        public void setResultat_Home(Arbitre arb, Date dt_match,Resultat resul) { 
            Match m=null;
            String txt = "SELECT m FROM Match AS m WHERE m.Arbitre=:arb and m.Dt_Match=:dt ";
            Query req = getEntityManager().createQuery(txt);
            req = req.setParameter("arb", arb);
            req = req.setParameter("dt", dt_match);
            List<Match> res = req.getResultList();
            if (res.size() >= 1)
            {
                  m = (Match) res.get(0);
                  m.setResultat_home(resul);
                  em.merge(m);
            }
        }
        
        @Override
        public void setScore_Away(Arbitre arb, Date dt_match,int buts) { 
            Match m=null;
            String txt = "SELECT m FROM Match AS m WHERE m.Arbitre=:arb and m.Dt_Match=:dt ";
            Query req = getEntityManager().createQuery(txt);
            req = req.setParameter("arb", arb);
            req = req.setParameter("dt", dt_match);
            List<Match> res = req.getResultList();
            if (res.size() >= 1)
            {
                  m = (Match) res.get(0);
                  m.setScore_Away(buts);
                  em.merge(m);
            }
        }
        
        @Override
        public void setScore_Home(Arbitre arb, Date dt_match,int buts) { 
            Match m=null;
            String txt = "SELECT m FROM Match AS m WHERE m.Arbitre=:arb and m.Dt_Match=:dt ";
            Query req = getEntityManager().createQuery(txt);
            req = req.setParameter("arb", arb);
            req = req.setParameter("dt", dt_match);
            List<Match> res = req.getResultList();
            if (res.size() >= 1)
            {
                  m = (Match) res.get(0);
                  m.setScore_Home(buts);
                  em.merge(m);
            }
        }
        
        @Override
        public List<Match> rechercheMatchEquipe_Away(Equipe eq,Date dt) {
        String txt = "SELECT mat FROM Match AS mat WHERE mat.Equipe=:equi and mat.Date=:dt";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("equi", eq);
        req = req.setParameter("dt", dt);
        List<Match> res = req.getResultList();
        return res;
         }
        
        @Override
        public List<Match> rechercheMatchEquipe_Home(Equipe eq,Date dt) {
        String txt = "SELECT mat FROM Match AS mat WHERE mat.Equipe=:equi and mat.Date=:dt";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("equi", eq);
        req = req.setParameter("dt", dt);
        List<Match> res = req.getResultList();
        return res;
         }
}
