package Entite;

import Entite.Classement;
import Entite.Matchs;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-29T22:23:13")
@StaticMetamodel(Championnat.class)
public class Championnat_ { 

    public static volatile SingularAttribute<Championnat, Date> Dt_debut_champio;
    public static volatile SingularAttribute<Championnat, String> Nom_Championnat;
    public static volatile SingularAttribute<Championnat, Date> Dt_Fin_Champio;
    public static volatile ListAttribute<Championnat, Matchs> matchss;
    public static volatile SingularAttribute<Championnat, Long> id;
    public static volatile ListAttribute<Championnat, Classement> classements;

}