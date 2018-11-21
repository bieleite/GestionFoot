/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Stade;
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
public class StadeFacade extends AbstractFacade<Stade> implements StadeFacadeLocal {

    @PersistenceContext(unitName = "GestionFoot-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StadeFacade() {
        super(Stade.class);
    }
    
    @Override
    public void CreerStade(String Nom, String Adresse, int capacite) {
        Stade f = new Stade();
        f.setNom_Stade(Nom);
        f.setAdresse_Stade(Adresse);
        f.setCapacite(capacite);
        em.persist(f);
    }
    
    @Override
    public List<Stade> listStade() {
        List<Stade> fo=null;
        String txt="SELECT fo FROM Stade AS fo ";
        Query req=getEntityManager().createQuery(txt);
        List<Stade> result=req.getResultList();
        return result;
    }

    @Override
    public Stade rechercheStade(Long id) {
        Stade f = null;        
        String txt = "SELECT f FROM Stade AS f WHERE f.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);  
        List<Stade> res = req.getResultList();
        if (res.size() >= 1)
        {
              f = (Stade) res.get(0);
        }
        return f;
    }
}
