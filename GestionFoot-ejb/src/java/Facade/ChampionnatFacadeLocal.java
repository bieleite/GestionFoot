/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Championnat;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gabrielleite
 */
@Local
public interface ChampionnatFacadeLocal {

    void create(Championnat championnat);

    void edit(Championnat championnat);

    void remove(Championnat championnat);

    Championnat find(Object id);

    List<Championnat> findAll();

    List<Championnat> findRange(int[] range);

    int count();
    
    void CreerChampionnat(String Nom, Date Dt_debut_champio, Date Dt_Fin_Champio);
    
    Championnat rechercheChampionnatParNom(String nom);
    
    List<Championnat> listChampionnat();
    
    Championnat rechercheArbitre(Long id);
}
