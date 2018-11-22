package Entite;

import Entite.Arbitre;
import Entite.Composition;
import Entite.Equipe;
import Entite.Fautes;
import Entite.Stade;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-22T18:08:27")
@StaticMetamodel(Match.class)
public class Match_ { 

    public static volatile ListAttribute<Match, Fautes> fautess;
    public static volatile SingularAttribute<Match, Composition> Composition_Home;
    public static volatile SingularAttribute<Match, Equipe> Equipe_Away;
    public static volatile SingularAttribute<Match, Stade> Stade;
    public static volatile SingularAttribute<Match, Composition> Composition_Away;
    public static volatile SingularAttribute<Match, Equipe> Equipe_Home;
    public static volatile SingularAttribute<Match, Long> id;
    public static volatile SingularAttribute<Match, Date> Dt_Match;
    public static volatile SingularAttribute<Match, Arbitre> Arbitre;

}