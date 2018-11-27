/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entite.Carton;
import Entite.Jouer;
import Entite.Matchs;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gabrielleite
 */
@Local
public interface sessionArbitreLocal {

    void saisirResultat();

    void creerFautes(String log, String mdp, long jouer, Date dt_match, Carton carton);

    void creerButs(String log, String mdp, long jouer, Long mat);
    
    List<Jouer> afficherJouer();
    
    List<Matchs> afficherMatch();

    void calculerMatch(String log, String mdp,Long id_match);
    
    List<Matchs> afficherMatchSansResultat();
}
