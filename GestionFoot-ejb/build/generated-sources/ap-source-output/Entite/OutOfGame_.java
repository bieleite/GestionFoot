package Entite;

import Entite.Jouer;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-17T22:10:32")
@StaticMetamodel(OutOfGame.class)
public class OutOfGame_ { 

    public static volatile SingularAttribute<OutOfGame, Date> Dt_FinOut;
    public static volatile SingularAttribute<OutOfGame, Jouer> leJouer;
    public static volatile SingularAttribute<OutOfGame, Long> id;
    public static volatile SingularAttribute<OutOfGame, Date> Dt_DebutOut;

}