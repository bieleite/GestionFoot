/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Equipe;
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
public class EquipeFacade extends AbstractFacade<Equipe> implements EquipeFacadeLocal {

    @PersistenceContext(unitName = "GestionFoot-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipeFacade() {
        super(Equipe.class);
    }
    
    @Override
    public void CreerEquipe(String Nom, String Adresse, Stade stade) {
        Equipe f = new Equipe();
        f.setNom_Equipe(Nom);
        f.setAdresse_Equipe(Adresse);
        f.setStade(stade);
        em.persist(f);
    }
    
    @Override
    public List<Equipe> listEquipe() {
        List<Equipe> fo=null;
        String txt="SELECT fo FROM Equipe AS fo ";
        Query req=getEntityManager().createQuery(txt);
        List<Equipe> result=req.getResultList();
        return result;
    }

    @Override
    public Equipe rechercheEquipe(Long id) {
        Equipe f = null;        
        String txt = "SELECT f FROM Equipe AS f WHERE f.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);  
        List<Equipe> res = req.getResultList();
        if (res.size() >= 1)
        {
              f = (Equipe) res.get(0);
        }
        return f;
    }
}
