/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author gabrielleite
 */
@Local
public interface sessionArbitreLocal {

    void saisirResultat();

    void creerFautes(String log, String mdp, long jouer, Date dt_match, String carton);

    void creerButs(String log, String mdp, String nom, Date dt_match);
    
}
