/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Composition;
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
    
}
