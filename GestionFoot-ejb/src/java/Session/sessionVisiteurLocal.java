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
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gabrielleite
 */
@Local
public interface sessionVisiteurLocal {
    
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
    
    List<Matchs> AfficherMatchParEquipe(long equi);
    
    List<Composition> AfficherCompositionParMatch(long match);
    
    List<Jouer> AfficherJouerParEquipe(long equi);
    
    List<Contrat_Jouer> AfficherContratJouerParJouer(long jouer);
    
    List<Contrat_Entraineur> AfficherContratEntraineurParEntraineur(long entraineur);
}
