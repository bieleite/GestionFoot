/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Equipe;
import Entite.Jouer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gabrielleite
 */
@Local
public interface JouerFacadeLocal {

    void create(Jouer jouer);

    void edit(Jouer jouer);

    void remove(Jouer jouer);

    Jouer find(Object id);

    List<Jouer> findAll();

    List<Jouer> findRange(int[] range);

    int count();
    
    void CreerJouer(String Nom, String Prenom);
    
    List<Jouer> listJouer();
    
    List<Jouer> listJouerEquipe(Equipe e);

    Jouer rechercheJouer(Long id);
    
    Jouer rechercheJouerParEquipe(Equipe equi);
            
    Jouer rechercheJouerParNom(String nom);
    
    void modifEquipe(long Nom, Equipe equi);
    
    Jouer supprimerJouer(Jouer c);
    
    Jouer rechercheJouerSansEquipeParNom(String nom);
}
