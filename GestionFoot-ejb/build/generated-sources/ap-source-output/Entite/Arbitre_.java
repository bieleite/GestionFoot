package Entite;

import Entite.Fautes;
import Entite.Matchs;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-16T13:42:09")
@StaticMetamodel(Arbitre.class)
public class Arbitre_ { 

    public static volatile SingularAttribute<Arbitre, String> Prenom;
    public static volatile ListAttribute<Arbitre, Matchs> matchs;
    public static volatile ListAttribute<Arbitre, Fautes> fautess;
    public static volatile SingularAttribute<Arbitre, String> Pass;
    public static volatile SingularAttribute<Arbitre, String> Login;
    public static volatile SingularAttribute<Arbitre, Long> id;
    public static volatile SingularAttribute<Arbitre, String> Nom;

}