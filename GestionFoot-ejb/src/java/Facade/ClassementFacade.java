/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Championnat;
import Entite.Classement;
import Entite.Equipe;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
