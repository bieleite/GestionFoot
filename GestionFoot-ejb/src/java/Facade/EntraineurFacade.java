/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Entraineur;
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
public class EntraineurFacade extends AbstractFacade<Entraineur> implements EntraineurFacadeLocal {

    @PersistenceContext(unitName = "GestionFoot-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntraineurFacade() {
        super(Entraineur.class);
    }
    
        @Override
    public void CreerEntraineur(String Nom, String Prenom, String Login, String Pass) {
        Entraineur f = new Entraineur();
        f.setNom(Nom);
        f.setPrenom(Prenom);
        f.setLogin(Login);
        f.setPass(Pass);
        em.persist(f);
    }
        @Override
    public List<Entraineur> listEntraineur() {
        List<Entraineur> fo=null;
        String txt="SELECT fo FROM Entraineur AS fo ";
        Query req=getEntityManager().createQuery(txt);
        List<Entraineur> result=req.getResultList();
        return result;
    }

    @Override
    public Entraineur rechercheEntraineur(Long id) {
        Entraineur f = null;        
        String txt = "SELECT f FROM Entraineur AS f WHERE f.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);  
        List<Entraineur> res = req.getResultList();
        if (res.size() >= 1)
        {
              f = (Entraineur) res.get(0);
        }
        return f;
    }
}
