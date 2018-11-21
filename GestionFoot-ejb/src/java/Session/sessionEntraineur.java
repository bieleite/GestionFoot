/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entite.Entraineur;
import Entite.Equipe;
import Facade.CompositionFacadeLocal;
import Facade.EntraineurFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gabrielleite
 */
@Stateless
public class sessionEntraineur implements sessionEntraineurLocal {

    @EJB
    private CompositionFacadeLocal compositionFacade;

    @EJB
    private EntraineurFacadeLocal entraineurFacade;

    @Override
    public void CreerComposition(String log, String mdp, String nom) {
        Entraineur c = null;    
        c = entraineurFacade.authentification(log, mdp);
        if (c != null)
        {
            Equipe e = 
            compositionFacade.CreerComposition(e, jouer);
        }
       
        else System.out.println("Entraineur inéxistant");
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
