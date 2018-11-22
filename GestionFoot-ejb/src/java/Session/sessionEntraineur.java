/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entite.Contrat_Entraineur;
import Entite.Entraineur;
import Entite.Equipe;
import Entite.Jouer;
import Facade.CompositionFacadeLocal;
import Facade.Contrat_EntraineurFacadeLocal;
import Facade.EntraineurFacadeLocal;
import Facade.EquipeFacadeLocal;
import Facade.JouerFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gabrielleite
 */
@Stateless
public class sessionEntraineur implements sessionEntraineurLocal {

    @EJB
    private JouerFacadeLocal jouerFacade;

    @EJB
    private EquipeFacadeLocal equipeFacade;

    @EJB
    private Contrat_EntraineurFacadeLocal contrat_EntraineurFacade;

    @EJB
    private CompositionFacadeLocal compositionFacade;

    @EJB
    private EntraineurFacadeLocal entraineurFacade;

    @Override
    public void CreerComposition(String log, String mdp, String nom) {   
        Entraineur c = entraineurFacade.authentification(log, mdp);
        if (c != null)
        {
            Contrat_Entraineur cc = contrat_EntraineurFacade.rechercheContrat_EntraineurParEntraineur(c);
            if(cc!=null){
                Equipe e = equipeFacade.rechercheEquipeParEntraineur(c);
                if(e!=null){
                    Jouer jouer=jouerFacade.rechercheJouerParNom(nom);
                     compositionFacade.CreerComposition(e, jouer);
                }
               
            }
            
        }
       
        else System.out.println("Entraineur inéxistant");
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
