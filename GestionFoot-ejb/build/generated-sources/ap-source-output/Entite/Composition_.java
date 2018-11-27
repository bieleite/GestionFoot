package Entite;

import Entite.Equipe;
import Entite.Jouer;
import Entite.Matchs;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-27T14:15:31")
@StaticMetamodel(Composition.class)
public class Composition_ { 

    public static volatile ListAttribute<Composition, Matchs> matchs;
    public static volatile ListAttribute<Composition, Jouer> test;
    public static volatile SingularAttribute<Composition, Date> Date_Comp;
    public static volatile SingularAttribute<Composition, Equipe> Equipe;
    public static volatile SingularAttribute<Composition, Jouer> Joeur;
    public static volatile SingularAttribute<Composition, Long> id;

}