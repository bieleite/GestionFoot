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
public interface sessionFederationLocal {

    void CreerEntraineur(String log, String mdp, String nom, String pren, String log1, String mdp1);

    void CreerContrantEntraineur(String log, String mdp,String status,double sal, String nom, String nom_equipe, Date dt_deb, Date dt_fin);

    void CreerJouer(String log, String mdp, String nom, String pren);

    void CreerContratJouer(String log, String mdp,String status,double sal, String nom, String nom_equipe, Date dt_deb, Date dt_fin);

    void creerMatch(String log, String mdp,Date date,String stade, String equipea,String equipeb,String arbitre);
    
}
