/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entite.Fautes;
import Entite.OutOfGame;
import Entite.Stade;
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

    void CreerContrantEntraineur(String log, String mdp,String status,double sal, String nom, String nom_equipe, Date dt_deb, Date dt_fin);

    void CreerJouer(String log, String mdp, String nom, String pren);

    void CreerContratJouer(String log, String mdp,String status,double sal, String nom, String nom_equipe, Date dt_deb, Date dt_fin);

    void CreerMatch(String log, String mdp,Date date,String stade, String equipea,String equipeb,String arbitre,String cham);
    
    void CreerEquipe(String log, String mdp, String Nom, String Adresse, long id);
    
    void CreerStade(String log, String mdp, String Nom, String Adresse, int capacite);
    
    void CreerArbitre(String log, String mdp, String nom, String pren, String log1, String mdp1);
    
    List<Fautes> AfficherFautesParJouer(Long id);
    
    List<Fautes> AfficherFautesParArbitre(String nom, String prenom);
    
    List<Fautes> AfficherFautesParMatch(Date dt);

    void CreerOutOfGame(String log, String mdp,String nom,Date dt_deb,int num);
    
    List<OutOfGame> AfficherOutOfGameParPeriode(String log, String mdp,Date dtD , Date dtF);
    
    List<Stade> afficherStade();

    void stadeParNum(Long id);
}
