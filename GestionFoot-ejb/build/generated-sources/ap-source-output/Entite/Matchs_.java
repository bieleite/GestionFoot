package Entite;

import Entite.Arbitre;
import Entite.Buts;
import Entite.Championnat;
import Entite.Composition;
import Entite.Equipe;
import Entite.Fautes;
import Entite.Resultat;
import Entite.Stade;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-17T11:50:22")
@StaticMetamodel(Matchs.class)
public class Matchs_ { 

    public static volatile ListAttribute<Matchs, Fautes> fautess;
    public static volatile SingularAttribute<Matchs, Composition> Composition_Home;
    public static volatile SingularAttribute<Matchs, Resultat> Resultat_away;
    public static volatile SingularAttribute<Matchs, Equipe> Equipe_Away;
    public static volatile SingularAttribute<Matchs, Stade> Stade;
    public static volatile SingularAttribute<Matchs, Equipe> Equipe_Home;
    public static volatile SingularAttribute<Matchs, Integer> Score_Home;
    public static volatile SingularAttribute<Matchs, Championnat> leChampionnat;
    public static volatile SingularAttribute<Matchs, String> Heure;
    public static volatile SingularAttribute<Matchs, Resultat> Resultat_home;
    public static volatile SingularAttribute<Matchs, Composition> Composition_Away;
    public static volatile SingularAttribute<Matchs, Integer> Score_Away;
    public static volatile ListAttribute<Matchs, Buts> butss;
    public static volatile SingularAttribute<Matchs, Long> id;
    public static volatile SingularAttribute<Matchs, Date> Dt_Match;
    public static volatile SingularAttribute<Matchs, Arbitre> Arbitre;

}