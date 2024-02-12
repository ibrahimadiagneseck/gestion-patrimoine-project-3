import { Agent } from "./agent.model";
import { ArticleBonSortie } from "./article-bon-sortie.model";
import { MyDate } from "./my-date.model";
import { Vehicule } from "./vehicule.model";

export class DotationVehicule {


  public identifiantDV: string;
  public dateDotation: MyDate;
  public identifiantBS: ArticleBonSortie;
  public matriculeAgent: Agent;
  public vehiculeDotation: Vehicule[] = [];



  constructor(
    identifiantDV: string = '',
    dateDotation = new MyDate(),
    identifiantBS = new ArticleBonSortie(),
    matriculeAgent = new Agent(),
    vehiculeDotation: Vehicule[] = []
  ) {
    this.identifiantDV = identifiantDV;
    this.dateDotation = dateDotation;
    this.identifiantBS = identifiantBS;
    this.matriculeAgent = matriculeAgent;
    this.vehiculeDotation = vehiculeDotation;
  }

}
