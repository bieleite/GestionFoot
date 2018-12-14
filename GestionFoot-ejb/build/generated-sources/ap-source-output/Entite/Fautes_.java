package Entite;

import Entite.Arbitre;
import Entite.Carton;
import Entite.Jouer;
import Entite.Matchs;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-14T13:34:01")
@StaticMetamodel(Fautes.class)
public class Fautes_ { 

    public static volatile SingularAttribute<Fautes, Jouer> Joeur;
    public static volatile SingularAttribute<Fautes, Long> id;
    public static volatile SingularAttribute<Fautes, Arbitre> Arbitre;
    public static volatile SingularAttribute<Fautes, Carton> Carton;
    public static volatile SingularAttribute<Fautes, Matchs> Match;

}