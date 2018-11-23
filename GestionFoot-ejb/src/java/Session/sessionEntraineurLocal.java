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
public interface sessionEntraineurLocal {

    void CreerComposition_Home(String log, String mdp, String nom,Date dt_comp);
    
    void CreerComposition_Away(String log, String mdp, String nom,Date dt_comp);
    
    void transfererJouer(String log, String mdp,String status,double sal, String nom, Date dt_deb, Date dt_fin);

    void supprimerJouer(String log, String mdp,String nom);

    void affecterJouer(String log, String mdp,String nom,double sal, Date dt_deb, Date dt_fin);
    
}
