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
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gabrielleite
 */
@Local
public interface sessionFederationLocal {

    void CreerEntraineur( String nom, String pren, String log1, String mdp1);

    void CreerContratEntraineur(Statut status,double sal, long entr, long nom_equipe, Date dt_deb, Date dt_fin);

    void CreerJouer( String nom, String pren);
    
    void CreerChampionnat( String nom, Date date_deb, Date date_fin);

    void CreerContratJouer(Statut status,double sal, long jouer, long equipe, Date dt_deb, Date dt_fin);

    void CreerMatch(Date date,String heur,long stade, long equipea,long equipeb,long arbitre,long cham);
    
    void CreerEquipe( String Nom, String Adresse, long id);
    
    void CreerStade( String Nom, String Adresse, int capacite);
    
    void CreerArbitre( String nom, String pren, String log1, String mdp1);
    
    
    List<Fautes> AfficherFautesParMatch(long match);
    
    List<Fautes> AfficherFautesParArbitre(long arbitre);
    
    List<Fautes> AfficherFautesParJouer(long jouer);

    void CreerOutOfGame(long faute,int num);
    
    List<OutOfGame> AfficherOutOfGameParPeriode(Date dtD , Date dtF);
    
    List<Stade> afficherStade();
    
    List<Equipe> afficherEquipe();
    
    List<Arbitre> afficherArbitre();
    
    List<Championnat> afficherChampionnat();
    
    List<Entraineur> afficherEntraineur();
    
    List<Jouer> afficherJouer();
    
    List<Fautes> afficherFautes();
    
    List<Matchs> afficherMatch();
    
    List<Classement> afficherClassement();
    
    List<OutOfGame> afficherOutOfGame();
    
    List<Contrat_Jouer> afficherContratJouer();
    
    List<Contrat_Entraineur> afficherContratEntraineur();

    void stadeParNum(Long id);

    void CreerClassement(long championnat, long equipe);
    
    Equipe rechercheEquipe(long id);
    
}
