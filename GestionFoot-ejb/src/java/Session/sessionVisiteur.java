/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entite.Arbitre;
import Entite.Championnat;
import Entite.Classement;
import Entite.Composition;
import Entite.Contrat_Entraineur;
import Entite.Contrat_Jouer;
import Entite.Entraineur;
import Entite.Equipe;
import Entite.Fautes;
import Entite.Jouer;
import Entite.Matchs;
import Entite.OutOfGame;
import Entite.Stade;
import Facade.ArbitreFacadeLocal;
import Facade.ChampionnatFacadeLocal;
import Facade.ClassementFacadeLocal;
import Facade.CompositionFacadeLocal;
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
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gabrielleite
 */
@Stateless
public class sessionVisiteur implements sessionVisiteurLocal {

    @EJB
    private CompositionFacadeLocal compositionFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
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
    public List<Matchs> AfficherMatchParEquipe(long equi) {
        /*
        Afficher les differents fautes commises pour les matches d'une date donnée
        */
        List<Matchs> liste = new ArrayList<Matchs>();
        Equipe e= equipeFacade.rechercheEquipe(equi);
        if(e!=null){
            liste = matchFacade.rechercheMatchEquipe(e);
        }
        else{
            System.out.println("Aucune match dans cette date");
        }
        return liste;
    }
    
    @Override
    public List<Composition> AfficherCompositionParMatch(long match) {
        /*
        Afficher les differents fautes commises pour les matches d'une date donnée
        */
        List<Composition> liste = new ArrayList<Composition>();
        Matchs m= matchFacade.rechercheMatch(match);
        if(m!=null){
            liste.add(m.getComposition_Away());
            liste.add(m.getComposition_Home());
        }
        else{
            System.out.println("Aucune match dans cette date");
        }
        return liste;
    }
    
    @Override
    public List<Jouer> AfficherJouerParEquipe(long equi) {
        /*
        Afficher les differents fautes commises pour les matches d'une date donnée
        */
        List<Jouer> liste = new ArrayList<Jouer>();
        Equipe e= equipeFacade.rechercheEquipe(equi);
        if(e!=null){
            liste = jouerFacade.listJouerEquipe(e);
        }
        else{
            System.out.println("Aucune match dans cette date");
        }
        return liste;
    }
    
    @Override
    public List<Contrat_Jouer> AfficherContratJouerParJouer(long jouer) {
        /*
        Afficher les differents fautes commises pour les matches d'une date donnée
        */
        List<Contrat_Jouer> liste = new ArrayList<Contrat_Jouer>();
        Jouer j= jouerFacade.rechercheJouer(jouer);
        if(j!=null){
            liste = contrat_JouerFacade.rechercheContratJouerJouer(j);
        }
        else{
            System.out.println("Aucune match dans cette date");
        }
        return liste;
    }
    
    @Override
    public List<Contrat_Entraineur> AfficherContratEntraineurParEntraineur(long entraineur) {
        /*
        Afficher les differents fautes commises pour les matches d'une date donnée
        */
        List<Contrat_Entraineur> liste = new ArrayList<Contrat_Entraineur>();
        Entraineur e= entraineurFacade.rechercheEntraineur(entraineur);
        if(e!=null){
            liste = contrat_EntraineurFacade.rechercheContratEntraineurEntraineur(e);
        }
        else{
            System.out.println("Aucune match dans cette date");
        }
        return liste;
    }
}
