/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Contrat_Entraineur;
import Entite.Entraineur;
import Entite.Equipe;
import Entite.Statut;
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
public class Contrat_EntraineurFacade extends AbstractFacade<Contrat_Entraineur> implements Contrat_EntraineurFacadeLocal {

    @PersistenceContext(unitName = "GestionFoot-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Contrat_EntraineurFacade() {
        super(Contrat_Entraineur.class);
    }
    
    @Override
    public void CreerContrat_Entraineur(Statut status,double salaire, Equipe equipe,Entraineur entraineur, Date dt_debut, Date dt_fin) {
        Contrat_Entraineur f = new Contrat_Entraineur();
        f.setStatus(Statut.Actif);
        f.setSalaire(salaire);
        f.setEquipe(equipe);
        f.setEntraineur(entraineur);
        f.setDate_debut(dt_debut);
        f.setDate_Fin(dt_fin);
        em.persist(f);
    }
    
    @Override
    public List<Contrat_Entraineur> listContrat_Entraineur() {
        List<Contrat_Entraineur> fo=null;
        String txt="SELECT fo FROM Contrat_Entraineur AS fo ";
        Query req=getEntityManager().createQuery(txt);
        List<Contrat_Entraineur> result=req.getResultList();
        return result;
    }

    @Override
    public Contrat_Entraineur rechercheContrat_Entraineur(Long id) {
        Contrat_Entraineur f = null;        
        String txt = "SELECT f FROM Contrat_Entraineur AS f WHERE f.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);  
        List<Contrat_Entraineur> res = req.getResultList();
        if (res.size() >= 1)
        {
              f = (Contrat_Entraineur) res.get(0);
        }
        return f;
    }
    
    @Override
    public Contrat_Entraineur rechercheEquipeParContrat_Entraineur(Long id) {
        Contrat_Entraineur f = null;        
        String txt = "SELECT f FROM Contrat_Entraineur AS f WHERE f.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);  
        List<Contrat_Entraineur> res = req.getResultList();
        if (res.size() >= 1)
        {
              f = (Contrat_Entraineur) res.get(0);
        }
        return f;
    }
}
