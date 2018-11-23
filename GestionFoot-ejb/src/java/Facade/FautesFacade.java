/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Arbitre;
import Entite.Carton;
import Entite.Fautes;
import Entite.Jouer;
import Entite.Matchs;
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
public class FautesFacade extends AbstractFacade<Fautes> implements FautesFacadeLocal {

    @PersistenceContext(unitName = "GestionFoot-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FautesFacade() {
        super(Fautes.class);
    }
    
        @Override
    public void CreerFautes(Carton carton,Matchs match, Arbitre arbitre, Jouer jouer) {
        Fautes f = new Fautes();
        f.setCarton(carton);
        f.setMatch(match);
        f.setArbitre(arbitre);
        f.setJoeur(jouer);
        em.persist(f);
    }
    
    @Override
    public List<Fautes> listFautes() {
        List<Fautes> fo=null;
        String txt="SELECT fo FROM Fautes AS fo ";
        Query req=getEntityManager().createQuery(txt);
        List<Fautes> result=req.getResultList();
        return result;
    }

    @Override
    public Fautes rechercheFautes(Long id) {
        Fautes f = null;        
        String txt = "SELECT f FROM Fautes AS f WHERE f.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);  
        List<Fautes> res = req.getResultList();
        if (res.size() >= 1)
        {
              f = (Fautes) res.get(0);
        }
        return f;
    }
}
