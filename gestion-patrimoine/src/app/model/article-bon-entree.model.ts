import { Agent } from "./agent.model";
import { BonEntree } from "./bon-entree.model";
import { LieuStockageVehicule } from "./lieu-stockage-vehicule.model";
import { MyDate } from "./my-date.model";
import { TypeObjet } from "./type-objet.model";

export class ArticleBonEntree {


  public identifiantBE: BonEntree;
  public codeArticleBonEntree: string;
  public libelleArticleBonEntree: string;
  public quantiteEntree: number;
  public dateEnregistrement: MyDate;
  public codeTypeObjet: TypeObjet;
  public codeLieuVH: LieuStockageVehicule;

  public matriculeAgent: Agent;


  constructor(
    identifiantBE = new BonEntree(),
    codeArticleBonEntree = '',
    libelleArticleBonEntree = '',
    quantiteEntree = 0,
    dateEnregistrement = new MyDate(),
    codeTypeObjet = new TypeObjet(),
    codeLieuVH = new LieuStockageVehicule(),
    matriculeAgent = new Agent()
  ) {
    this.identifiantBE = identifiantBE;
    this.codeArticleBonEntree = codeArticleBonEntree;
    this.libelleArticleBonEntree = libelleArticleBonEntree;
    this.quantiteEntree = quantiteEntree;
    this.dateEnregistrement = dateEnregistrement;
    this.codeTypeObjet = codeTypeObjet;
    this.codeLieuVH = codeLieuVH;
    this.matriculeAgent = matriculeAgent;
  }

}

