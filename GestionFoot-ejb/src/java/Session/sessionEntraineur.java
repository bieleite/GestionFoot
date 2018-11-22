/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entite.Composition;
import Entite.Contrat_Entraineur;
import Entite.Contrat_Jouer;
import Entite.Entraineur;
import Entite.Equipe;
import Entite.Jouer;
import Entite.Statut;
import Facade.CompositionFacadeLocal;
import Facade.Contrat_EntraineurFacadeLocal;
import Facade.Contrat_JouerFacadeLocal;
import Facade.EntraineurFacadeLocal;
import Facade.EquipeFacadeLocal;
import Facade.JouerFacadeLocal;
import Facade.MatchFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gabrielleite
 */
@Stateless
public class sessionEntraineur implements sessionEntraineurLocal {

    @EJB
    private Contrat_JouerFacadeLocal contrat_JouerFacade;

    @EJB
    private MatchFacadeLocal matchFacade;

    @EJB
    private JouerFacadeLocal jouerFacade;

    @EJB
    private EquipeFacadeLocal equipeFacade;

    @EJB
    private Contrat_EntraineurFacadeLocal contrat_EntraineurFacade;

    @EJB
    private CompositionFacadeLocal compositionFacade;

    @EJB
    private EntraineurFacadeLocal entraineurFacade;

    @Override
    public void CreerComposition_Home(String log, String mdp, String nom,Date dt_comp) {   
        Entraineur c = entraineurFacade.authentification(log, mdp);
        if (c != null)
        {
            Contrat_Entraineur cc = contrat_EntraineurFacade.rechercheContrat_EntraineurParEntraineur(c);
            if(cc!=null){
                Equipe e = equipeFacade.rechercheEquipeParEntraineur(c);
                if(e!=null){
                    Jouer jouer=jouerFacade.rechercheJouerParNom(nom);
                     compositionFacade.CreerComposition(dt_comp,e, jouer);
                    Composition comp = compositionFacade.rechercheCompositionParEquipeEtDate(e, dt_comp);
                     matchFacade.modifCompositionHome(comp, e);
                }
               
            }
            
        }
       
        else System.out.println("Entraineur inéxistant");
    }
    
    @Override
    public void CreerComposition_Away(String log, String mdp, String nom,Date dt_comp) {   
        Entraineur c = entraineurFacade.authentification(log, mdp);
        if (c != null)
        {
            Contrat_Entraineur cc = contrat_EntraineurFacade.rechercheContrat_EntraineurParEntraineur(c);
            if(cc!=null){
                Equipe e = equipeFacade.rechercheEquipeParEntraineur(c);
                if(e!=null){
                    Jouer jouer=jouerFacade.rechercheJouerParNom(nom);
                     compositionFacade.CreerComposition(dt_comp,e, jouer);
                     Composition comp = compositionFacade.rechercheCompositionParEquipeEtDate(e, dt_comp);
                     matchFacade.modifCompositionAway(comp, e);
                }
               
            }
            
        }
       
        else System.out.println("Entraineur inéxistant");
    }

    @Override
    public void transfererJouer(String log, String mdp,String status,double sal, String nom, Date dt_deb, Date dt_fin) {
        Statut u= null;
        Entraineur c = entraineurFacade.authentification(log, mdp);
        if (c!=null)
        {
            if (status.contains("Actif") || status.contains("Actif"))
               u = u.Actif;
            else if (status.contains("Inactif")|| status.contains("Inactif"))
                u = u.Inactif;
            Jouer jo = jouerFacade.rechercheJouerParNom(nom);
            Equipe equi = equipeFacade.rechercheEquipeParEntraineur(c);
            if(jo!=null){
                Contrat_Jouer ac = contrat_JouerFacade.rechercheContrat_JouerParJouer(jo);
                if(ac!=null){
                    contrat_JouerFacade.modifStatutInactif(jo,ac);
                    contrat_JouerFacade.CreerContrat_Jouer(u, sal, equi, jo, dt_fin, dt_deb);
                    jouerFacade.modifEquipe(nom, equi);
                }
                
                
            }
            else{
                System.out.println("Equipe ou jouer inexistant! ");
            }
        }
        
        else System.out.println("Vous n'avez pas les droits pour créer de Contrat Jouer ! ");
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
