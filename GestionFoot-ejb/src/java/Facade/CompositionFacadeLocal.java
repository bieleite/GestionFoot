/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Composition;
import Entite.Entraineur;
import Entite.Equipe;
import Entite.Jouer;
import Entite.Matchs;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gabrielleite
 */
@Local
public interface CompositionFacadeLocal {

    void create(Composition composition);

    void edit(Composition composition);

    void remove(Composition composition);

    Composition find(Object id);

    List<Composition> findAll();

    List<Composition> findRange(int[] range);

    int count();
    
    void CreerComposition(Date dt_comp,Equipe equipe, List<Jouer> jouers);
    
    List<Composition> listComposition();
    
    List<Composition> rechercheCompositionMatch(Matchs ma);

    Composition rechercheComposition(Long id);
    
    Composition rechercheCompositionParEquipeEtDate(Equipe equi,Date dt);
    
}
