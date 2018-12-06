/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entite.Arbitre;
import Entite.Championnat;
import Entite.Classement;
import Entite.Contrat_Entraineur;
import Entite.Contrat_Jouer;
import Entite.Entraineur;
import Entite.Equipe;
import Entite.Fautes;
import Entite.Jouer;
import Entite.Matchs;
import Entite.OutOfGame;
import Entite.Stade;
import Entite.Statut;
import Facade.ArbitreFacadeLocal;
import Facade.ChampionnatFacadeLocal;
import Facade.ClassementFacadeLocal;
import Facade.Contrat_EntraineurFacadeLocal;
import Facade.Contrat_JouerFacadeLocal;
import Facade.EntraineurFacadeLocal;
import Facade.EquipeFacadeLocal;
import Facade.FautesFacadeLocal;
import Facade.JouerFacadeLocal;
import Facade.MatchFacadeLocal;
import Facade.OutOfGameFacadeLocal;
import Facade.StadeFacadeLocal;
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
public class sessionFederation implements sessionFederationLocal {

    @EJB
    private ClassementFacadeLocal classementFacade;

    @EJB
    private OutOfGameFacadeLocal outOfGameFacade;

    @EJB
    private FautesFacadeLocal fautesFacade;

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
    public void CreerEntraineur( String nom, String pren, String log1, String mdp1) {
        /*
            Creer entraineur !
        */
        

            entraineurFacade.CreerEntraineur(nom, pren, log1, mdp1);

        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void CreerContratEntraineur(Statut status,double sal, long entr, long nom_equipe, Date dt_deb, Date dt_fin) {
        /*
            Pour l'historique du Entraineur j'ai decidé de créer une classe contrat, comme ça on peut afficher 
            la liste des tout les contrats que l'entraineur participe, pour ça j'ai fait la recherche par nom
            apres une recherche de l'equipe par nom, au fin le contrat est crée et l'equipe du entraineur modifié
            comme ça on a toujour l'equipe actualisé a chaque nouveux contrat
        */
        Statut u=null;
   
            Entraineur ent = entraineurFacade.rechercheEntraineur(entr);
            Equipe equi = equipeFacade.rechercheEquipe(nom_equipe);
            if(ent!=null && equi!=null){
                Contrat_Entraineur c = contrat_EntraineurFacade.rechercheEquipeParContrat_EntraineurActifParEntraineur(ent);
                if(c==null){
                contrat_EntraineurFacade.CreerContrat_Entraineur(status, sal, equi, ent, dt_deb, dt_fin);
                entraineurFacade.modifEquipe(entr, equi);
                }
                else{
                    c.setStatus(Statut.In);
                    c.setDate_Fin(dt_deb);
                    contrat_EntraineurFacade.CreerContrat_Entraineur(status, sal, equi, ent, dt_deb, dt_fin);
                    entraineurFacade.modifEquipe(entr, equi);
                    
                }
            }
            else{
                System.out.println("Equipe ou entraineur inexistant! ");
            }
 
    }

    @Override
    public void CreerJouer(String nom, String pren) {
        /*
        Creation d'une jouer
        */

            jouerFacade.CreerJouer(nom, pren);

    }

    @Override
    public void CreerChampionnat( String nom, Date date_deb, Date date_fin) {
        /*
        Creation d'une jouer
        */

            championnatFacade.CreerChampionnat(nom, date_fin, date_fin);

    }
    
    @Override
    public void CreerContratJouer(Statut status,double sal, long jouer, long equipe, Date dt_deb, Date dt_fin) {
        /*
            Meme idée du creer contrat entraineur /\
                                                  ||
        */
            Statut u=null;

            Jouer jo = jouerFacade.rechercheJouer(jouer);
            Equipe equi = equipeFacade.rechercheEquipe(equipe);
            if(jo!=null && equi!=null){
                contrat_JouerFacade.CreerContrat_Jouer(status, sal, equi, jo, dt_fin, dt_deb);
                jouerFacade.modifEquipe(jouer, equi);
            }
            else{
                System.out.println("Equipe ou jouer inexistant! ");
            }

    }

    @Override
    public void CreerMatch(Date date,long stade, long equipea,long equipeb,long arbitre,long cham) {
        /*
            Pour la creation d'une match on a besoin de rechercher une championnat d'ou participe cette match
            Après voir si le stade n'est pas ocuppe, il fait la meme chose pour l'arbitre , si tout est bon le match 
            est crée 
        
                    ***IMPORTANT*** faire la verification de l'equipe aussi***
                    ***IMPORTANT*** Ajouter heure pour les matchs***
        */

            Championnat champ= championnatFacade.rechercheArbitre(cham);
            if(champ!=null){
            Stade sta =stadeFacade.rechercheStade(stade);
            List<Matchs> listeMatch = matchFacade.rechercheMatchStadeDate(sta, date);
            if (listeMatch.isEmpty())
            {
                Equipe eqpa = equipeFacade.rechercheEquipe(equipea);
                Equipe eqpb = equipeFacade.rechercheEquipe(equipeb);
                //Faire une verification pour l'equipe
                if(eqpa!=null && eqpb!=null){

                        Arbitre arb= arbitreFacade.rechercheArbitre(arbitre);
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
    @Override
    public void CreerEquipe(String Nom, String Adresse, long id ) {
        /*
        Creer equipe
        */
        

            
            Stade st =stadeFacade.rechercheStade(id);
            if(st!=null){
                equipeFacade.CreerEquipe(Nom, Adresse, st);
            }
            

        
    }
    
    @Override
    public void CreerStade(String Nom, String Adresse, int capacite) {
        /*
        Creer equipe
        */
        

 
           stadeFacade.CreerStade(Nom, Adresse, capacite);
 
        
    }
    
    @Override
    public void CreerArbitre(String nom, String pren, String log1, String mdp1) {
        /*
        Creer Arbitre
        */

           arbitreFacade.CreerArbitre(nom, pren, log1, pren);

        
    }
    
    @Override
    public List<Fautes> AfficherFautesParMatch(long match) {
        /*
        Afficher les differents fautes commises pour les matches d'une date donnée
        */
        List<Fautes> liste = new ArrayList<Fautes>();
        Matchs f= matchFacade.rechercheMatch(match);
        if(f!=null){
            liste = fautesFacade.rechercheFautesParMatch(f);
        }
        else{
            System.out.println("Aucune match dans cette date");
        }
        return liste;
    }
    
    @Override
    public List<Fautes> AfficherFautesParJouer(long jouer) {
        /*
        Afficher les differents fautes commises pour les matches d'une date donnée
        */
        List<Fautes> liste = new ArrayList<Fautes>();
        Jouer f= jouerFacade.rechercheJouer(jouer);
        if(f!=null){
            liste = fautesFacade.rechercheFautesParJouer(f);
        }
        else{
            System.out.println("Aucune match dans cette date");
        }
        return liste;
    }
    
    @Override
    public List<Fautes> AfficherFautesParArbitre(long arbitre) {
        /*
        Afficher les differents fautes commises pour les matches d'une date donnée
        */
        List<Fautes> liste = new ArrayList<Fautes>();
        Arbitre f= arbitreFacade.rechercheArbitre(arbitre);
        if(f!=null){
            liste = fautesFacade.rechercheFautesParArbitre(f);
        }
        else{
            System.out.println("Aucune match dans cette date");
        }
        return liste;
    }
    @Override
    public void CreerOutOfGame(long faute,int num) {

            Fautes f = fautesFacade.find(faute);
            Jouer jo= f.getJoeur();
            if(jo!=null){
                Matchs ma = f.getMatch();
                Date dt_deb= ma.getDate();
                List<Fautes> liste = fautesFacade.rechercheFautesParJouerEtMatch(jo, ma);
                if (!liste.isEmpty())
                {   
                    Matchs mf=matchFacade.rechercheProxMatchParDateEtNum(dt_deb, num);
                    Date dt_fin=mf.getDate();
                    outOfGameFacade.CreerOutOfGame(jo, dt_deb, dt_fin);
                    
                     
                }
                
               
            }
        
        
    }
    
    @Override
    public List<OutOfGame> AfficherOutOfGameParPeriode(Date dtD , Date dtF) {
        /*
        Afficher la liste OutOfGame d'une periode
        */
        List<OutOfGame> liste = new ArrayList<OutOfGame>();
        liste = outOfGameFacade.listOutOfGameParDate(dtD, dtF);
        return liste;  
    }
    
    @Override
    public List<Stade> afficherStade() {
        List<Stade> liste = stadeFacade.listStade(); 
        return liste;
    }
    
    @Override
    public List<Equipe> afficherEquipe() {
        List<Equipe> liste = equipeFacade.listEquipe();
        return liste;
    }

    @Override
    public List<Arbitre> afficherArbitre() {
        List<Arbitre> liste = arbitreFacade.listArbitre();
        return liste;
    }
    
    @Override
    public List<Championnat> afficherChampionnat() {
        List<Championnat> liste = championnatFacade.listChampionnat();
        return liste;
    }
    
    @Override
    public List<Entraineur> afficherEntraineur() {
        List<Entraineur> liste = entraineurFacade.listEntraineur();
        return liste;
    }
    
    @Override
    public List<Jouer> afficherJouer() {
        List<Jouer> liste = jouerFacade.listJouer();
        return liste;
    }
    
    @Override
    public List<Fautes> afficherFautes() {
        List<Fautes> liste = fautesFacade.listFautes();
        return liste;
    }
    
    @Override
    public List<Matchs> afficherMatch() {
        List<Matchs> liste = matchFacade.listMatch();
        return liste;
    }
    
    @Override
    public List<Classement> afficherClassement() {
        List<Classement> liste = classementFacade.findAll();
        return liste;
    }
    
    @Override
    public List<OutOfGame> afficherOutOfGame() {
        List<OutOfGame> liste = outOfGameFacade.listOutOfGame();
        return liste;
    }
    
    @Override
    public List<Contrat_Entraineur> afficherContratEntraineur() {
        List<Contrat_Entraineur> liste = contrat_EntraineurFacade.listContrat_Entraineur();
        return liste;
    }
    
    @Override
    public List<Contrat_Jouer> afficherContratJouer() {
        List<Contrat_Jouer> liste = contrat_JouerFacade.listContrat_Jouer();
        return liste;
    }
    
    @Override
    public void stadeParNum(Long id) {
        stadeFacade.rechercheStade(id);
    }

    @Override
    public void CreerClassement(long championnat, long equipe) {
        /*
        Affecter une equipe dans une championnat
        */

            Equipe equi = equipeFacade.rechercheEquipe(equipe);
            if(equi!=null){
                Championnat champ=championnatFacade.find(championnat);
                classementFacade.CreerClassement(champ, equi);
            }
            else System.out.println("Nao func");

    }
    
}
