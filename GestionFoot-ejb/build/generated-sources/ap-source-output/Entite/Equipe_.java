package Entite;

import Entite.Buts;
import Entite.Classement;
import Entite.Composition;
import Entite.Contrat_Entraineur;
import Entite.Contrat_Jouer;
import Entite.Entraineur;
import Entite.Jouer;
import Entite.Matchs;
import Entite.Stade;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-14T13:34:01")
@StaticMetamodel(Equipe.class)
public class Equipe_ { 

    public static volatile SingularAttribute<Equipe, String> Adresse_Equipe;
    public static volatile ListAttribute<Equipe, Jouer> jouers;
    public static volatile ListAttribute<Equipe, Contrat_Entraineur> contrat_Entraineurs;
    public static volatile SingularAttribute<Equipe, String> Nom_Equipe;
    public static volatile SingularAttribute<Equipe, Entraineur> entraineur;
    public static volatile ListAttribute<Equipe, Matchs> matchs;
    public static volatile SingularAttribute<Equipe, Stade> Stade;
    public static volatile ListAttribute<Equipe, Buts> butss;
    public static volatile ListAttribute<Equipe, Composition> compositions;
    public static volatile SingularAttribute<Equipe, Long> id;
    public static volatile ListAttribute<Equipe, Contrat_Jouer> contrat_Jouers;
    public static volatile ListAttribute<Equipe, Classement> classements;

}