package Entite;

import Entite.Equipe;
import Entite.Match;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-22T18:08:27")
@StaticMetamodel(Stade.class)
public class Stade_ { 

    public static volatile ListAttribute<Stade, Match> matchs;
    public static volatile ListAttribute<Stade, Equipe> equipes;
    public static volatile SingularAttribute<Stade, String> Adresse_Stade;
    public static volatile SingularAttribute<Stade, Integer> Capacite;
    public static volatile SingularAttribute<Stade, String> Nom_Stade;
    public static volatile SingularAttribute<Stade, Long> id;

}