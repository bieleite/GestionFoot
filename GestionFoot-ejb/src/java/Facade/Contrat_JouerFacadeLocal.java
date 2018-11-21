/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Contrat_Jouer;
import Entite.Equipe;
import Entite.Jouer;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gabrielleite
 */
@Local
public interface Contrat_JouerFacadeLocal {

    void create(Contrat_Jouer contrat_Jouer);

    void edit(Contrat_Jouer contrat_Jouer);

    void remove(Contrat_Jouer contrat_Jouer);

    Contrat_Jouer find(Object id);

    List<Contrat_Jouer> findAll();

    List<Contrat_Jouer> findRange(int[] range);

    int count();
    
    void CreerContrat_Jouer(double salaire, Equipe equipe,Jouer jouer, Date dt_fin, Date dt_debut);
    
    List<Contrat_Jouer> listContrat_Jouer();

    Contrat_Jouer rechercheContrat_Jouer(Long id);
}
