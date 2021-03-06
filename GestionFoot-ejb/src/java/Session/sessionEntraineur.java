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
import Entite.OutOfGame;
import Entite.Statut;
import Facade.CompositionFacadeLocal;
import Facade.Contrat_EntraineurFacadeLocal;
import Facade.Contrat_JouerFacadeLocal;
import Facade.EntraineurFacadeLocal;
import Facade.EquipeFacadeLocal;
import Facade.JouerFacadeLocal;
import Facade.MatchFacadeLocal;
import Facade.OutOfGameFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gabrielleite
 */
@Stateless
public class sessionEntraineur implements sessionEntraineurLocal {

    @EJB
    private OutOfGameFacadeLocal outOfGameFacade;

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
        /*
            Creer composition home, il faut voir si il y a le besoin d'ajouter une class pour la liste de jouer
        */
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
        /*
            Creer composition away, il faut voir si il y a le besoin d'ajouter une class pour la liste de jouer
        */
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
    public void transfererJouer(String log, String mdp,Statut status,double sal, long jouer, Date dt_deb, Date dt_fin) {
        /*
            Pour Transferer le jouer d'une equipe a l'autre, le method changé le status du ancien contrat vers Inactif
            et la date fin pour la date de debut du nouveaux contrat, au fin il modifie l'equipe du jouer pour l'equipe 
            de l'entraineur
        ps: regarder la necessté du if else du status
        */
        Statut u= null;
        Entraineur c = entraineurFacade.authentification(log, mdp);
        if (c!=null)
        {
            Jouer jo = jouerFacade.rechercheJouer(jouer);
            Equipe equi = equipeFacade.rechercheEquipeParEntraineur(c);
            if(jo!=null){
                Contrat_Jouer ac = contrat_JouerFacade.rechercheContrat_JouerParJouer(jo);
                if(ac!=null){
                    contrat_JouerFacade.modifStatutInactif(jo,ac);
                    contrat_JouerFacade.modifDateFinContrat(jo, ac, dt_deb);
                    contrat_JouerFacade.CreerContrat_Jouer(u, sal, equi, jo, dt_fin, dt_deb);
                    jouerFacade.modifEquipe(jouer, equi);
                }
                else{
                    contrat_JouerFacade.CreerContrat_Jouer(u, sal, equi, jo, dt_fin, dt_deb);
                    jouerFacade.modifEquipe(jouer, equi);
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

    @Override
    public void supprimerJouer(String log, String mdp,String nom) {
        /*
            Supprimer le jouer, pas de plus
        */
        Entraineur c = entraineurFacade.authentification(log, mdp);
        if (c!=null)
        {
            Jouer jo = jouerFacade.rechercheJouerParNom(nom);
            if(jo!=null){
                jouerFacade.supprimerJouer(jo);
            }
        }
    }

    @Override
    public void affecterJouer(String log, String mdp,long jouer,double sal, Date dt_deb, Date dt_fin) {
        /*
            Affecter le jouer sans equipe dans l'equipe du entraineur 
            Apres reflechir la vrai necessité de cette method
        */
        Entraineur c = entraineurFacade.authentification(log, mdp);
        if (c!=null)
        {
            Jouer jo = jouerFacade.rechercheJouer(jouer);
            Equipe equi = equipeFacade.rechercheEquipeParEntraineur(c);
            if(jo!=null){
                    contrat_JouerFacade.CreerContrat_Jouer(Statut.Ac, sal, equi, jo, dt_fin, dt_deb);
                    jouerFacade.modifEquipe(jouer, equi);
                }
            else{
                System.out.println("Jouer inexistant! ");
            }
        
        } 
        else System.out.println("Vous n'avez pas les droits pour créer de Contrat Jouer ! ");
        }
    
    @Override
    public List<OutOfGame> AfficherOutOfGameParPeriode(String log, String mdp,Date dtD , Date dtF) {
        /*
        Afficher la liste OutOfGame d'une periode
        */
        List<OutOfGame> liste = new ArrayList<OutOfGame>();
        liste = outOfGameFacade.listOutOfGameParDate(dtD, dtF);
        return liste;  
    }
}
