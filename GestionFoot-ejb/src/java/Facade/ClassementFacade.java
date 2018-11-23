/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Championnat;
import Entite.Classement;
import Entite.Equipe;
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
public class ClassementFacade extends AbstractFacade<Classement> implements ClassementFacadeLocal {

    @PersistenceContext(unitName = "GestionFoot-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClassementFacade() {
        super(Classement.class);
    }
    
    @Override
    public void CreerClassement(Championnat Champ, Equipe equi) {
        Classement c = new Classement();
        c.setLeChampionnat(Champ);
        c.setLeEquipe(equi);
        c.setPoint(0);
        em.persist(c);
    }

    @Override
    public void setPointsParEquipeGagnant(Equipe equi) {
            Classement m=null;
            String txt = "SELECT m FROM Classement AS m WHERE m.leEquipe=:eq ";
            Query req = getEntityManager().createQuery(txt);
            req = req.setParameter("eq", equi);
            List<Classement> res = req.getResultList();
            if (res.size() >= 1)
            {
                  m = (Classement) res.get(0);
                  m.setPoint(m.getPoint()+3);
                  em.merge(m);
            }
    }
    
    @Override
    public void setPointsParEquipeNulle(Equipe equi) {
            Classement m=null;
            String txt = "SELECT m FROM Classement AS m WHERE m.leEquipe=:eq ";
            Query req = getEntityManager().createQuery(txt);
            req = req.setParameter("eq", equi);
            List<Classement> res = req.getResultList();
            if (res.size() >= 1)
            {
                  m = (Classement) res.get(0);
                  m.setPoint(m.getPoint()+1);
                  em.merge(m);
            }
    }
}
