/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Stade;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gabrielleite
 */
@Local
public interface StadeFacadeLocal {

    void create(Stade stade);

    void edit(Stade stade);

    void remove(Stade stade);

    Stade find(Object id);

    List<Stade> findAll();

    List<Stade> findRange(int[] range);

    int count();
    
    void CreerStade(String Nom, String Adresse, int capacite);
    
    List<Stade> listStade();

    Stade rechercheStade(Long id);
    
    Stade rechercheStadeParNom(String nom);
}
