/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Fautes;
import Entite.Jouer;
import Entite.OutOfGame;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gabrielleite
 */
@Local
public interface OutOfGameFacadeLocal {

    void create(OutOfGame outOfGame);

    void edit(OutOfGame outOfGame);

    void remove(OutOfGame outOfGame);

    OutOfGame find(Object id);

    List<OutOfGame> findAll();

    List<OutOfGame> findRange(int[] range);

    int count();
    
    void CreerOutOfGame(Jouer joueur, Date dt_deb, Date dt_fin);
    
    List<OutOfGame> listOutOfGame();

    OutOfGame rechercheOutOfGame(Long id);
    
    List<OutOfGame> listOutOfGameParDate(Date dtD,Date dtF);
}
