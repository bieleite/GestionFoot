package Entite;

import Entite.Buts;
import Entite.Composition;
import Entite.Contrat_Jouer;
import Entite.Equipe;
import Entite.Fautes;
import Entite.OutOfGame;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T16:19:38")
@StaticMetamodel(Jouer.class)
public class Jouer_ { 

    public static volatile SingularAttribute<Jouer, String> Prenom;
    public static volatile ListAttribute<Jouer, Fautes> fautess;
    public static volatile SingularAttribute<Jouer, Equipe> Equipe;
    public static volatile ListAttribute<Jouer, Buts> butss;
    public static volatile ListAttribute<Jouer, OutOfGame> outOfGames;
    public static volatile ListAttribute<Jouer, Composition> compositions;
    public static volatile SingularAttribute<Jouer, Long> id;
    public static volatile ListAttribute<Jouer, Contrat_Jouer> contrat_Jouers;
    public static volatile SingularAttribute<Jouer, String> Nom;

}