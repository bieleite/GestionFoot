/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entite.Entraineur;
import Entite.Equipe;
import Entite.Statut;
import Facade.Contrat_EntraineurFacadeLocal;
import Facade.EntraineurFacadeLocal;
import Facade.EquipeFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gabrielleite
 */
@Stateless
public class sessionFederation implements sessionFederationLocal {


    @EJB
    private EquipeFacadeLocal equipeFacade;

    @EJB
    private Contrat_EntraineurFacadeLocal contrat_EntraineurFacade;

    @EJB
    private EntraineurFacadeLocal entraineurFacade;

    @Override
    public void CreerEntraineur(String log, String mdp, String nom, String pren, String log1, String mdp1) {
        
        if ((log.contains("admin")) && (mdp.contains("admin")))
        {
            entraineurFacade.CreerEntraineur(nom, pren, log1, mdp1);
        }
        
        else System.out.println("Vous n'avez pas les droits pour créer de Entraineur ! ");
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void CreerContrantEntraineur(String log, String mdp,String status,double sal, String nom, String nom_equipe, Date dt_deb, Date dt_fin) {
        Statut u=null;
        if ((log.contains("admin")) && (mdp.contains("admin")))
        {
            if (status.contains("Actif") || status.contains("Actif"))
               u = u.Actif;
            else if (status.contains("Inactif")|| status.contains("Inactif"))
                u = u.Inactif;
            Entraineur ent = entraineurFacade.rechercheEntraineurParNom(nom);
            Equipe equi = equipeFacade.rechercheEquipeParNom(nom_equipe);
            if(ent!=null && equi!=null){
                contrat_EntraineurFacade.CreerContrat_Entraineur(u, sal, equi, ent, dt_deb, dt_fin);
                entraineurFacade.modifEquipe(nom, equi);
            }
            else{
                System.out.println("Equipe ou entraineur inexistant! ");
            }
        }
        
        else System.out.println("Vous n'avez pas les droits pour créer de Contrat Entraineur ! ");
    }
}
