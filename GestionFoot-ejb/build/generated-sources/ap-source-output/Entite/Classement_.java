package Entite;

import Entite.Championnat;
import Entite.Equipe;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-16T13:42:09")
@StaticMetamodel(Classement.class)
public class Classement_ { 

    public static volatile SingularAttribute<Classement, Integer> Point;
    public static volatile SingularAttribute<Classement, Long> id;
    public static volatile SingularAttribute<Classement, Championnat> leChampionnat;
    public static volatile SingularAttribute<Classement, Equipe> leEquipe;

}