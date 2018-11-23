/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Buts;
import Entite.Equipe;
import Entite.Jouer;
import Entite.Match;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gabrielleite
 */
@Local
public interface ButsFacadeLocal {

    void create(Buts buts);

    void edit(Buts buts);

    void remove(Buts buts);

    Buts find(Object id);

    List<Buts> findAll();

    List<Buts> findRange(int[] range);

    int count();
    
    void CreerButs(Equipe equipe, Jouer jouer,Match match);
    
    List<Buts> listButs();

    Buts rechercheButs(Long id);
    
    int qntButsParJouer(Jouer jo);
    
    int qntButsParEquipeEtMatch(Equipe eq,Match mt );
    
}
