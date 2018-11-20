/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Contrat_Entraineur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gabrielleite
 */
@Local
public interface Contrat_EntraineurFacadeLocal {

    void create(Contrat_Entraineur contrat_Entraineur);

    void edit(Contrat_Entraineur contrat_Entraineur);

    void remove(Contrat_Entraineur contrat_Entraineur);

    Contrat_Entraineur find(Object id);

    List<Contrat_Entraineur> findAll();

    List<Contrat_Entraineur> findRange(int[] range);

    int count();
    
}
