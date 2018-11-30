/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Arbitre;
import Entite.Buts;
import Entite.Championnat;
import Entite.Composition;
import Entite.Equipe;
import Entite.Stade;
import Entite.Matchs;
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
public class MatchFacade extends AbstractFacade<Matchs> implements MatchFacadeLocal {

    @PersistenceContext(unitName = "GestionFoot-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MatchFacade() {
        super(Matchs.class);
    }

    @Override
    public void CreerMatch(Date date,Stade stade, Equipe equipea,Equipe equipeb,Arbitre arbitre,Championnat champ) {
        Matchs m = new Matchs();
        m.setDate(date);
        m.setStade(stade);
        m.setEquipe_Home(equipeb);
        m.setEquipe_Away(equipea);
        m.setArbitre(arbitre);
        m.setLeChampionnat(champ);
        em.persist(m);
    }
    
    @Override
    public List<Matchs> listMatch() {
        List<Matchs> fo=null;
        String txt="SELECT fo FROM Matchs AS fo ";
        Query req=getEntityManager().createQuery(txt);
        List<Matchs> result=req.getResultList();
        return result;
    }

    @Override
    public Matchs rechercheMatch(Long id) {
        Matchs f = null;        
        String txt = "SELECT f FROM Matchs AS f WHERE f.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);  
        List<Matchs> res = req.getResultList();
        if (res.size() >= 1)
        {
              f = (Matchs) res.get(0);
        }
        return f;
    }
    
    @Override
    public List<Matchs> rechercheMatchStadeDate(Stade stad,Date dt) {
        String txt = "SELECT mat FROM Matchs AS mat WHERE mat.Stade=:stad and mat.Dt_Match=:dt";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("stad", stad);
        req = req.setParameter("dt", dt);
        List<Matchs> res = req.getResultList();
        return res;
        
    }
    
    @Override
    public List<Matchs> rechercheMatchArbitreDate(Arbitre arb,Date dt) {
        String txt = "SELECT mat FROM Matchs AS mat WHERE mat.Arbitre=:arb and mat.Dt_Match=:dt";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("arb", arb);
        req = req.setParameter("dt", dt);
        List<Matchs> res = req.getResultList();
        return res;
        
    }
    
    @Override
    public List<Matchs> rechercheMatchArbitre(Arbitre arb) {
        String txt = "SELECT mat FROM Matchs AS mat WHERE mat.Arbitre=:arb";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("arb", arb);
        List<Matchs> res = req.getResultList();
        return res;
        
    }
    
    @Override
    public List<Matchs> rechercheMatchEquipe(Equipe equ) {
        String txt = "SELECT mat FROM Matchs AS mat WHERE mat.Equipe_Home=:equ OR mat.Equipe_Away=:equ ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("equ", equ);
        List<Matchs> res = req.getResultList();
        return res;
        
    }
    
    @Override
    public Matchs rechercheMatchArbitreEtId(Arbitre arb,long id) {
        Matchs mat = null;
        String txt = "SELECT mat FROM Matchs AS mat WHERE mat.Arbitre=:arb and mat.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("arb", arb);
        req = req.setParameter("id", id);
        List<Matchs> res = req.getResultList();
        if (res.size() >= 1)
        {
              mat = (Matchs) res.get(0);
        }
        return mat;
        }
        
    
    
    @Override
    public void modifCompositionAway(Composition Com, Equipe equi) { 
            Matchs ent = null;
            String txt = "SELECT ent FROM Matchs AS ent WHERE ent.Equipe_Away=:nom";
            Query req = getEntityManager().createQuery(txt);
            req = req.setParameter("nom", equi);
            List<Matchs> res = req.getResultList();
            if (res.size() >= 1)
            {
                  ent = (Matchs) res.get(0);
                  ent.setComposition_Away(Com);
                  em.merge(ent);
            }
    }
    @Override
    public void modifCompositionHome(Composition Com, Equipe equi) { 
        Matchs ent = null;
        String txt = "SELECT ent FROM Matchs AS ent WHERE ent.Equipe_Home=:nom";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("nom", equi);
        List<Matchs> res = req.getResultList();
        if (res.size() >= 1)
        {
              ent = (Matchs) res.get(0);
              ent.setComposition_Home(Com);
              em.merge(ent);
        }
    }
        
    @Override
    public Matchs rechercheMatchParArbitreEtDate(Arbitre arb, Date dt_match) {
    Matchs f = null;        
    String txt = "SELECT f FROM Matchs AS f WHERE f.Arbitre=:arb and f.Dt_Match=:dt";
    Query req = getEntityManager().createQuery(txt);
    req = req.setParameter("arb", arb);
    req = req.setParameter("dt", dt_match);
    List<Matchs> res = req.getResultList();
    if (res.size() >= 1)
    {
          f = (Matchs) res.get(0);
    }
    return f;
    }
    
    @Override
    public Matchs rechercheMatchParDate(Date dt_match) {
    Matchs f = null;        
    String txt = "SELECT f FROM Matchs AS f WHERE f.Dt_Match=:dt";
    Query req = getEntityManager().createQuery(txt);
    req = req.setParameter("dt", dt_match);
    List<Matchs> res = req.getResultList();
    if (res.size() >= 1)
    {
          f = (Matchs) res.get(0);
    }
    return f;
    }
    
    @Override
    public void setResultat_Away(Arbitre arb, Date dt_match,Resultat resul) { 
        Matchs m=null;
        String txt = "SELECT m FROM Matchs AS m WHERE m.Arbitre=:arb and m.Dt_Match=:dt ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("arb", arb);
        req = req.setParameter("dt", dt_match);
        List<Matchs> res = req.getResultList();
        if (res.size() >= 1)
        {
              m = (Matchs) res.get(0);
              m.setResultat_away(resul);
              em.merge(m);
        }
    }
        
    @Override
    public void setResultat_Home(Arbitre arb, Date dt_match,Resultat resul) { 
        Matchs m=null;
        String txt = "SELECT m FROM Matchs AS m WHERE m.Arbitre=:arb and m.Dt_Match=:dt ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("arb", arb);
        req = req.setParameter("dt", dt_match);
        List<Matchs> res = req.getResultList();
        if (res.size() >= 1)
        {
              m = (Matchs) res.get(0);
              m.setResultat_home(resul);
              em.merge(m);
        }
    }

    @Override
    public void setScore_Away(Arbitre arb, Date dt_match,int buts) { 
        Matchs m=null;
        String txt = "SELECT m FROM Matchs AS m WHERE m.Arbitre=:arb and m.Dt_Match=:dt ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("arb", arb);
        req = req.setParameter("dt", dt_match);
        List<Matchs> res = req.getResultList();
        if (res.size() >= 1)
        {
              m = (Matchs) res.get(0);
              m.setScore_Away(m.getScore_Away()+1);
              em.merge(m);
        }
    }

    @Override
    public void setScore_Home(Arbitre arb, Date dt_match,int buts) { 
        Matchs m=null;
        String txt = "SELECT m FROM Matchs AS m WHERE m.Arbitre=:arb and m.Dt_Match=:dt ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("arb", arb);
        req = req.setParameter("dt", dt_match);
        List<Matchs> res = req.getResultList();
        if (res.size() >= 1)
        {
              m = (Matchs) res.get(0);
              m.setScore_Home(buts);
              em.merge(m);
        }
    }

    @Override
    public List<Matchs> rechercheMatchEquipe_Away(Equipe eq,Date dt) {
    String txt = "SELECT mat FROM Matchs AS mat WHERE mat.Equipe_Away=:equi and mat.Dt_Match=:dt";
    Query req = getEntityManager().createQuery(txt);
    req = req.setParameter("equi", eq);
    req = req.setParameter("dt", dt);
    List<Matchs> res = req.getResultList();
    return res;
     }

    @Override
    public List<Matchs> rechercheMatchEquipe_Home(Equipe eq,Date dt) {
    String txt = "SELECT mat FROM Matchs AS mat WHERE mat.Equipe_Home=:equi and mat.Dt_Match=:dt";
    Query req = getEntityManager().createQuery(txt);
    req = req.setParameter("equi", eq);
    req = req.setParameter("dt", dt);
    List<Matchs> res = req.getResultList();
    return res;
     }
        
    @Override
    public Matchs rechercheProxMatchParIdEtNum(long id,int num) {
    Matchs f = null;        
    String txt = "SELECT f FROM Matchs AS f WHERE f.id=:id";
    Query req = getEntityManager().createQuery(txt);
    req = req.setParameter("id", id);
    List<Matchs> res = req.getResultList();
    if (res.size() >= 1)
    {
          f = (Matchs) res.get(num);
    }
    return f;
    }
    
    @Override
    public Matchs rechercheProxMatchParDateEtNum(Date dt,int num) {
    Matchs f = null;        
    String txt = "SELECT f FROM Matchs AS f WHERE f.Dt_Match>=:dt";
    Query req = getEntityManager().createQuery(txt);
    req = req.setParameter("dt", dt);
    List<Matchs> res = req.getResultList();
    if (res.size() >= 1)
    {
          f = (Matchs) res.get(num);
    }
    return f;
    }
    
    @Override
    public List<Matchs> listMatchSansResultat() {
        List<Matchs> fo=null;
        String txt="SELECT fo FROM Matchs AS fo WHERE fo.Resultat_away=null and fo.Resultat_home=null";
        Query req=getEntityManager().createQuery(txt);
        List<Matchs> result=req.getResultList();
        return result;
    }
    
    @Override
    public List<Matchs> listMatchSansAvantAuj() {
        List<Matchs> fo=null;
        String txt="SELECT fo FROM Matchs AS fo WHERE fo.Dt_Match>=getDate()";
        Query req=getEntityManager().createQuery(txt);
        List<Matchs> result=req.getResultList();
        return result;
    }
}
