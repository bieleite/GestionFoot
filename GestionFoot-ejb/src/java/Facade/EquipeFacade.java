/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Entraineur;
import Entite.Equipe;
import Entite.Jouer;
import Entite.Matchs;
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
    
    @Override
    public  Equipe rechercheEquipeParEntraineur(Entraineur ent) {
        Equipe e = null;        
        String txt = "SELECT e FROM Equipe AS e WHERE e.Entraineur=:ent ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("ent", ent);
        List<Equipe> res = req.getResultList();
        if (res.size() >= 1)
        {
              e = (Equipe) res.get(0);
        }
        return e;
        
    }
    @Override
    public  Equipe rechercheEquipeParNom(String nom) {
        Equipe e = null;        
        String txt = "SELECT e FROM Equipe AS e WHERE e.Nom_Equipe=:nom ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("nom", nom);
        List<Equipe> res = req.getResultList();
        if (res.size() >= 1)
        {
              e = (Equipe) res.get(0);
        }
        return e;
        
    }
    
        @Override
    public  Equipe rechercheEquipeParJouer(Jouer jo) {
        Equipe e = null;        
        String txt = "SELECT e FROM Equipe AS e WHERE e.Jouer=:jo ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("jo", jo);
        List<Equipe> res = req.getResultList();
        if (res.size() >= 1)
        {
              e = (Equipe) res.get(0);
        }
        return e;
        
    }
    

  
    

}
