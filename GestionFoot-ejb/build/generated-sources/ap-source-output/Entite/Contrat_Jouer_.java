package Entite;

import Entite.Equipe;
import Entite.Jouer;
import Entite.Statut;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-27T14:15:31")
@StaticMetamodel(Contrat_Jouer.class)
public class Contrat_Jouer_ { 

    public static volatile SingularAttribute<Contrat_Jouer, Statut> Status;
    public static volatile SingularAttribute<Contrat_Jouer, Date> Date_fin;
    public static volatile SingularAttribute<Contrat_Jouer, Double> Salaire;
    public static volatile SingularAttribute<Contrat_Jouer, Equipe> Equipe;
    public static volatile SingularAttribute<Contrat_Jouer, Date> Date_Debut;
    public static volatile SingularAttribute<Contrat_Jouer, Jouer> Joeur;
    public static volatile SingularAttribute<Contrat_Jouer, Long> id;

}