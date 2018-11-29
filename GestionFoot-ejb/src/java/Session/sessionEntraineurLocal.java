/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entite.Entraineur;
import Entite.Jouer;
import Entite.Matchs;
import Entite.OutOfGame;
import Entite.Statut;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gabrielleite
 */
@Local
public interface sessionEntraineurLocal {

    void CreerComposition_Home(String log, String mdp, long match, List<Jouer> jouer);
    
    void CreerComposition_Away(String log, String mdp, long match, List<Jouer> jouer);
    
    void transfererJouer(String log, String mdp,Statut status,double sal, long jouer, Date dt_deb, Date dt_fin);

    void supprimerJouer(String log, String mdp,String nom);

    void affecterJouer(String log, String mdp,long jouer,double sal, Date dt_deb, Date dt_fin);
    
    List<OutOfGame> AfficherOutOfGameParPeriode(String log, String mdp,Date dtD , Date dtF);
    
//    List<Jouer> afficherJouerEquipe(String log, String mdp);
    
    List<Jouer> afficherJouer();
    
    List<Matchs> afficherMatch();
    
    Jouer rechercheJouer(long id);
    
    Matchs rechercheMatch(long id);
    
    Entraineur authentification(String login ,String pass);
}
