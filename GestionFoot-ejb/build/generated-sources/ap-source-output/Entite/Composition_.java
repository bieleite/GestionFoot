package Entite;

import Entite.Equipe;
import Entite.Jouer;
import Entite.Match;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-22T18:08:27")
@StaticMetamodel(Composition.class)
public class Composition_ { 

    public static volatile ListAttribute<Composition, Match> matchs;
    public static volatile SingularAttribute<Composition, Date> Date_Comp;
    public static volatile SingularAttribute<Composition, Equipe> Equipe;
    public static volatile SingularAttribute<Composition, Jouer> Joeur;
    public static volatile SingularAttribute<Composition, Long> id;

}