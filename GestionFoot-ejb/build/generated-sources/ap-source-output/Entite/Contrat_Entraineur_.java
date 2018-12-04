package Entite;

import Entite.Entraineur;
import Entite.Equipe;
import Entite.Statut;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T16:19:38")
@StaticMetamodel(Contrat_Entraineur.class)
public class Contrat_Entraineur_ { 

    public static volatile SingularAttribute<Contrat_Entraineur, Statut> Status;
    public static volatile SingularAttribute<Contrat_Entraineur, Entraineur> Entraineur;
    public static volatile SingularAttribute<Contrat_Entraineur, Date> Date_Fin;
    public static volatile SingularAttribute<Contrat_Entraineur, Double> Salaire;
    public static volatile SingularAttribute<Contrat_Entraineur, Date> Date_debut;
    public static volatile SingularAttribute<Contrat_Entraineur, Equipe> Equipe;
    public static volatile SingularAttribute<Contrat_Entraineur, Long> id;

}