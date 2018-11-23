/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Fautes;
import Entite.Jouer;
import Entite.OutOfGame;
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
public class OutOfGameFacade extends AbstractFacade<OutOfGame> implements OutOfGameFacadeLocal {

    @PersistenceContext(unitName = "GestionFoot-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OutOfGameFacade() {
        super(OutOfGame.class);
    }
    
    @Override
    public void CreerOutOfGame(Jouer joueur, Date dt_deb, Date dt_fin) {
        OutOfGame o = new OutOfGame();
        o.setLeJouer(joueur);
        o.setDt_DebutOut(dt_deb);
        o.setDt_FinOut(dt_fin);
        em.persist(o);
    }
    @Override
    public List<OutOfGame> listOutOfGame() {
        List<OutOfGame> fo=null;
        String txt="SELECT fo FROM OutOfGame AS fo ";
        Query req=getEntityManager().createQuery(txt);
        List<OutOfGame> result=req.getResultList();
        return result;
    }

    @Override
    public OutOfGame rechercheOutOfGame(Long id) {
        OutOfGame f = null;        
        String txt = "SELECT f FROM OutOfGame AS f WHERE f.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);  
        List<OutOfGame> res = req.getResultList();
        if (res.size() >= 1)
        {
              f = (OutOfGame) res.get(0);
        }
        return f;
    }
    
    @Override
    public List<OutOfGame> listOutOfGameParDate(Date dtD,Date dtF) {
        List<OutOfGame> fo=null;
        String txt="SELECT fo FROM OutOfGame AS fo WHERE fo.Dt_DebutOut BETWEEN :dtD and :dtF ";
        Query req=getEntityManager().createQuery(txt);
        req = req.setParameter("dtD", dtD); 
        req = req.setParameter("dtF", dtF); 
        List<OutOfGame> result=req.getResultList();
        return result;
    }
    
    
}
