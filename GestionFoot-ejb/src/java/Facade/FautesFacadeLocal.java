/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Arbitre;
import Entite.Carton;
import Entite.Fautes;
import Entite.Jouer;
import Entite.Match;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gabrielleite
 */
@Local
public interface FautesFacadeLocal {

    void create(Fautes fautes);

    void edit(Fautes fautes);

    void remove(Fautes fautes);

    Fautes find(Object id);

    List<Fautes> findAll();

    List<Fautes> findRange(int[] range);

    int count();
    
    void CreerFautes(Carton carton,Match match, Arbitre arbitre, Jouer jouer);
    
    List<Fautes> listFautes();

    Fautes rechercheFautes(Long id);
}
