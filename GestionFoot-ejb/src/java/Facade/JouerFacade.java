/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

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
}
