import { Agent } from "./agent.model";
import { ArticleBonSortie } from "./article-bon-sortie.model";
import { BordereauLivraison } from "./bordereau-livraison.model";
import { MyDate } from "./my-date.model";
import { Vehicule } from "./vehicule.model";

export class DotationVehicule {

  public numeroSerie: Vehicule;
  public identifiantBS: ArticleBonSortie
  public matriculeAgent: Agent;

  constructor(
    numeroSerie = new Vehicule(),
    identifiantBS = new ArticleBonSortie(),
    matriculeAgent = new Agent()
  ) {
    this.numeroSerie = numeroSerie;
    this.identifiantBS = identifiantBS;
    this.matriculeAgent = matriculeAgent;
  }

}
