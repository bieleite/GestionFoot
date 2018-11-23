/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Championnat;
import Entite.Classement;
import Entite.Equipe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gabrielleite
 */
@Local
public interface ClassementFacadeLocal {

    void create(Classement classement);

    void edit(Classement classement);

    void remove(Classement classement);

    Classement find(Object id);

    List<Classement> findAll();

    List<Classement> findRange(int[] range);

    int count();
    
    void CreerClassement(Championnat Champ, Equipe equi);

    void setPointsParEquipeGagnant(Equipe equi);
    
    void setPointsParEquipeNulle(Equipe equi);
}
