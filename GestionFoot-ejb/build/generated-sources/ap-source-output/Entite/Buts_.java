package Entite;

import Entite.Equipe;
import Entite.Jouer;
import Entite.Matchs;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-17T22:10:32")
@StaticMetamodel(Buts.class)
public class Buts_ { 

    public static volatile SingularAttribute<Buts, Equipe> Equipe;
    public static volatile SingularAttribute<Buts, Matchs> leMatch;
    public static volatile SingularAttribute<Buts, Jouer> Jouer;
    public static volatile SingularAttribute<Buts, Long> id;

}