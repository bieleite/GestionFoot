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
import Entite.Fautes;
import Entite.Jouer;
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

    void CreerEntraineur(String log, String mdp, String nom, String pren, String log1, String mdp1);

    void CreerContratEntraineur(String log, String mdp,Statut status,double sal, long entr, long nom_equipe, Date dt_deb, Date dt_fin);

    void CreerJouer(String log, String mdp, String nom, String pren);
    
    void CreerChampionnat(String log, String mdp, String nom, Date date_deb, Date date_fin);

    void CreerContratJouer(String log, String mdp,Statut status,double sal, long jouer, long equipe, Date dt_deb, Date dt_fin);

    void CreerMatch(String log, String mdp,Date date,long stade, long equipea,long equipeb,long arbitre,long cham);
    
    void CreerEquipe(String log, String mdp, String Nom, String Adresse, long id);
    
    void CreerStade(String log, String mdp, String Nom, String Adresse, int capacite);
    
    void CreerArbitre(String log, String mdp, String nom, String pren, String log1, String mdp1);
    
    List<Fautes> AfficherFautesParJouer(Long id);
    
    List<Fautes> AfficherFautesParArbitre(String nom, String prenom);
    
    List<Fautes> AfficherFautesParMatch(Date dt);

    void CreerOutOfGame(String log, String mdp,long jouer,Date dt_deb,int num);
    
    List<OutOfGame> AfficherOutOfGameParPeriode(String log, String mdp,Date dtD , Date dtF);
    
    List<Stade> afficherStade();
    
    List<Equipe> afficherEquipe();
    
    List<Arbitre> afficherArbitre();
    
    List<Championnat> afficherChampionnat();
    
    List<Entraineur> afficherEntraineur();
    
    List<Jouer> afficherJouer();

    void stadeParNum(Long id);

    void CreerClassement(String log, String mdp,long championnat, long equipe);
    
}
