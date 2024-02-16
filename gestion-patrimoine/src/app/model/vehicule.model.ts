import { Agent } from "./agent.model";
import { ArticleBonEntree } from "./article-bon-entree.model";
import { BonEntree } from "./bon-entree.model";
import { MyDate } from "./my-date.model";
import { EtatVehicule } from "./etat-vehicule.model";
import { MarqueVehicule } from "./marque-vehicule.model";
import { Pays } from "./pays.model";
import { TypeEnergie } from "./type-energie.model";
import { TypeObjet } from "./type-objet.model";
import { TypeVehicule } from "./type-vehicule.model";
import { UniteDouaniere } from "./unite-douaniere.model";


export class Vehicule {

  public numeroSerie: string;
  public numeroImmatriculation: string;
  public identifiantBE: ArticleBonEntree;
  public modele: string;
  public codeEtat: EtatVehicule;
  public codeTypeEnergie: TypeEnergie;
  public codePays: Pays;
  public numeroCarteGrise: string;
  public dateMiseEnCirculation: MyDate;
  public codeTypeVehicule: TypeVehicule;
  public codeMarque: MarqueVehicule;
  public rowPays: String;
  public rowMarque: String;
  public rowEtat: String;
  public rowTypeEnergie: String;
  public rowTypeVehicule: String;


  constructor(
    numeroSerie = '',
    codeTypeVehicule = new TypeVehicule(),
    numeroImmatriculation = '',
    codeMarque = new MarqueVehicule(),
    modele = '',
    codeEtat = new EtatVehicule(),
    codeTypeEnergie = new TypeEnergie(),
    codePays = new Pays(),
    numeroCarteGrise = '',
    dateMiseEnCirculation = new MyDate(),
    identifiantBE = new ArticleBonEntree(),
    rowPays = '',
    rowMarque = '',
    rowEtat = '',
    rowTypeEnergie = '',
    rowTypeVehicule = '',
  ) {
    this.numeroSerie = numeroSerie;
    this.codeTypeVehicule = codeTypeVehicule;
    this.numeroImmatriculation = numeroImmatriculation;
    this.codeMarque = codeMarque;
    this.modele = modele;
    this.codeEtat = codeEtat;
    this.codeTypeEnergie = codeTypeEnergie;
    this.codePays = codePays;
    this.numeroCarteGrise = numeroCarteGrise;
    this.dateMiseEnCirculation = dateMiseEnCirculation;
    this.identifiantBE = identifiantBE;
    this.rowPays = rowPays;
    this.rowMarque = rowMarque;
    this.rowEtat = rowEtat;
    this.rowTypeEnergie = rowTypeEnergie;
    this.rowTypeVehicule = rowTypeVehicule;
  }

}
