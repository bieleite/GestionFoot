package Entite;

import Entite.Contrat_Entraineur;
import Entite.Equipe;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-24T15:12:53")
@StaticMetamodel(Entraineur.class)
public class Entraineur_ { 

    public static volatile SingularAttribute<Entraineur, String> Prenom;
    public static volatile ListAttribute<Entraineur, Contrat_Entraineur> contrat_Entraineurs;
    public static volatile SingularAttribute<Entraineur, String> Pass;
    public static volatile SingularAttribute<Entraineur, Equipe> Equipe;
    public static volatile SingularAttribute<Entraineur, String> Login;
    public static volatile SingularAttribute<Entraineur, Long> id;
    public static volatile SingularAttribute<Entraineur, String> Nom;

}