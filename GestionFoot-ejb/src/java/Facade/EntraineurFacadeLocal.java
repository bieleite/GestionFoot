/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Entraineur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gabrielleite
 */
@Local
public interface EntraineurFacadeLocal {

    void create(Entraineur entraineur);

    void edit(Entraineur entraineur);

    void remove(Entraineur entraineur);

    Entraineur find(Object id);

    List<Entraineur> findAll();

    List<Entraineur> findRange(int[] range);

    int count();
    
    void CreerEntraineur(String Nom, String Prenom, String Login, String Pass);
    
    List<Entraineur> listEntraineur();

    Entraineur rechercheEntraineur(Long id);
    
    Entraineur authentification(String login, String mdp);
}
