/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entite.Arbitre;
import Entite.Championnat;
import Entite.Entraineur;
import Entite.Equipe;
import Entite.Jouer;
import Entite.Matchs;
import Entite.Stade;
import Entite.Statut;
import Facade.ArbitreFacadeLocal;
import Facade.ChampionnatFacadeLocal;
import Facade.Contrat_EntraineurFacadeLocal;
import Facade.Contrat_JouerFacadeLocal;
import Facade.EntraineurFacadeLocal;
import Facade.EquipeFacadeLocal;
import Facade.JouerFacadeLocal;
import Facade.MatchFacadeLocal;
import Facade.StadeFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gabrielleite
 */
@Stateless
public class sessionFederation implements sessionFederationLocal {

    @EJB
    private ChampionnatFacadeLocal championnatFacade;

    @EJB
    private ArbitreFacadeLocal arbitreFacade;


    @EJB
    private MatchFacadeLocal matchFacade;

    @EJB
    private StadeFacadeLocal stadeFacade;

    @EJB
    private JouerFacadeLocal jouerFacade;

    @EJB
    private Contrat_JouerFacadeLocal contrat_JouerFacade;


    @EJB
    private EquipeFacadeLocal equipeFacade;

    @EJB
    private Contrat_EntraineurFacadeLocal contrat_EntraineurFacade;

    @EJB
    private EntraineurFacadeLocal entraineurFacade;

    @Override
    public void CreerEntraineur(String log, String mdp, String nom, String pren, String log1, String mdp1) {
        /*
            Creer entraineur !
        */
        
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
        /*
            Pour l'historique du Entraineur j'ai decidé de créer une classe contrat, comme ça on peut afficher 
            la liste des tout les contrats que l'entraineur participe, pour ça j'ai fait la recherche par nom
            apres une recherche de l'equipe par nom, au fin le contrat est crée et l'equipe du entraineur modifié
            comme ça on a toujour l'equipe actualisé a chaque nouveux contrat
        */
        Statut u=null;
        if ((log.contains("admin")) && (mdp.contains("admin")))
        {
            if (status.contains("Actif") || status.contains("Ac"))
               u = u.Ac;
            else if (status.contains("Inactif")|| status.contains("In"))
                u = u.In;
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

    @Override
    public void CreerJouer(String log, String mdp, String nom, String pren) {
        /*
        Creation d'une jouer
        */
        if ((log.contains("admin")) && (mdp.contains("admin")))
        {
            jouerFacade.CreerJouer(nom, pren);
        }
        
        else System.out.println("Vous n'avez pas les droits pour créer de Jouer ! ");
    }

    @Override
    public void CreerContratJouer(String log, String mdp,String status,double sal, String nom, String nom_equipe, Date dt_deb, Date dt_fin) {
        /*
            Meme idée du creer contrat entraineur /\
                                                  ||
        */
            Statut u=null;
        if ((log.contains("admin")) && (mdp.contains("admin")))
        {
            if (status.contains("Actif") || status.contains("Ac"))
               u = u.Ac;
            else if (status.contains("Inactif")|| status.contains("In"))
                u = u.In;
            Jouer ent = jouerFacade.rechercheJouerParNom(nom);
            Equipe equi = equipeFacade.rechercheEquipeParNom(nom_equipe);
            if(ent!=null && equi!=null){
                contrat_JouerFacade.CreerContrat_Jouer(u, sal, equi, ent, dt_fin, dt_deb);
                jouerFacade.modifEquipe(nom, equi);
            }
            else{
                System.out.println("Equipe ou jouer inexistant! ");
            }
        }
        
        else System.out.println("Vous n'avez pas les droits pour créer de Contrat Jouer ! ");
    }

    @Override
    public void creerMatch(String log, String mdp,Date date,String stade, String equipea,String equipeb,String arbitre,String cham) {
        /*
            Pour la creation d'une match on a besoin de rechercher une championnat d'ou participe cette match
            Après voir si le stade n'est pas ocuppe, il fait la meme chose pour l'arbitre , si tout est bon le match 
            est crée 
        
                    ***IMPORTANT*** faire la verification de l'equipe aussi***
        */
        if ((log.contains("admin")) && (mdp.contains("admin")))
        {
            Championnat champ= championnatFacade.rechercheChampionnatParNom(cham);
            if(champ!=null){
            Stade sta =stadeFacade.rechercheStadeParNom(stade);
            List<Matchs> listeMatch = matchFacade.rechercheMatchStadeDate(sta, date);
            if (listeMatch.isEmpty())
            {
                Equipe eqpa = equipeFacade.rechercheEquipeParNom(equipea);
                Equipe eqpb = equipeFacade.rechercheEquipeParNom(equipeb);
                //Faire une verification pour l'equipe
                if(eqpa!=null && eqpb!=null){

                        Arbitre arb= arbitreFacade.rechercheArbitreParNom(arbitre);
                        List<Matchs> listeMatchA = matchFacade.rechercheMatchArbitreDate(arb, date);
                            if (listeMatchA.isEmpty())
                            {
                                matchFacade.CreerMatch(date, sta, eqpa, eqpb, arb,champ);
                            }
                            else{
                                System.out.println("Arbitre ocuupé! ");
                            }
                    }

                }
                else{
                    System.out.println("Equipe inexistant! ");
                }
            }
            else{
                System.out.println("Stade deja ocuppe!");
            }
        }
        }
    @Override
    public void CreerEquipe(String log, String mdp, String Nom, String Adresse, String stade) {
        /*
        Creer equipe
        */
        
        if ((log.contains("admin")) && (mdp.contains("admin")))
        {
            Stade st =stadeFacade.rechercheStadeParNom(stade);
            if(st!=null){
                equipeFacade.CreerEquipe(Nom, Adresse, st);
            }
            
        }
        
        else System.out.println("Vous n'avez pas les droits pour créer de Entraineur ! ");
        
    }
    
    @Override
    public void CreerArbitre(String log, String mdp, String nom, String pren, String log1, String mdp1) {
        /*
        Creer Arbitre
        */
        if ((log.contains("admin")) && (mdp.contains("admin")))
        {
           arbitreFacade.CreerArbitre(nom, pren, log1, pren);
        }
        
        else System.out.println("Vous n'avez pas les droits pour créer de Entraineur ! ");
        
    }
}
