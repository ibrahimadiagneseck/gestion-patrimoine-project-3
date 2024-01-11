import { BordereauLivraison } from "./bordereau-livraison.model";
import { MyDate } from "./my-date.model";

export class BonEntree {

  public identifiantBE: string;
  public numeroBE: string;
  public libelleBonEntree: string;
  public dateBonEntree: MyDate;
  public observationBonEntree:string;
  public identifiantBL: BordereauLivraison;
  public rowNombreArticleBonEntree: number;


  constructor(
    identifiantBE = '',
    numeroBE = '',
    libelleBonEntree = '',
    dateBonEntree = new MyDate(),
    observationBonEntree = '',
    identifiantBL = new BordereauLivraison(),
    rowNombreArticleBonEntree = 0
  ) {
    this.identifiantBE = identifiantBE;
    this.numeroBE = numeroBE;
    this.libelleBonEntree = libelleBonEntree;
    this.dateBonEntree = dateBonEntree;
    this.observationBonEntree = observationBonEntree;
    this.identifiantBL = identifiantBL;
    this.rowNombreArticleBonEntree = rowNombreArticleBonEntree;
  }

}
