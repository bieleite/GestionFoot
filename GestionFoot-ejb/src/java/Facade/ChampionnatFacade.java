/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Championnat;
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
public class ChampionnatFacade extends AbstractFacade<Championnat> implements ChampionnatFacadeLocal {

    @PersistenceContext(unitName = "GestionFoot-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ChampionnatFacade() {
        super(Championnat.class);
    }
    
    @Override
    public void CreerChampionnat(String Nom, Date Dt_debut_champio, Date Dt_Fin_Champio) {
        Championnat c = new Championnat();
        c.setNom_Championnat(Nom);
        c.setDt_debut_champio(Dt_debut_champio);
        c.setDt_Fin_Champio(Dt_Fin_Champio);
        em.persist(c);
    }
    
    @Override
    public  Championnat rechercheChampionnatParNom(String nom) {
        Championnat c = null;        
        String txt = "SELECT c FROM Championnat AS c WHERE c.Nom_Championnat=:nom ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("nom", nom);
        List<Championnat> res = req.getResultList();
        if (res.size() >= 1)
        {
              c = (Championnat) res.get(0);
        }
        return c;
        
    }
    @Override
    public List<Championnat> listChampionnat() {
        List<Championnat> fo=null;
        String txt="SELECT fo FROM Championnat AS fo ";
        Query req=getEntityManager().createQuery(txt);
        List<Championnat> result=req.getResultList();
        return result;
    }

}
