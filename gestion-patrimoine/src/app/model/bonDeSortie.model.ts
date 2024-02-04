import { Agent } from "./agent.model";
import { BordereauLivraison } from "./bordereau-livraison.model";
import { MyDate } from "./my-date.model";
import { UniteDouaniere } from "./unite-douaniere.model";
import { Sections } from "./sections.model";
import { BonPour } from "./bon-pour.model";
import { ArticleBonPour } from "./article-bon-pour.model";

export class BonDeSortie {

  public identifiantBS: string;
  public numeroBS: string;
  public descriptionBS: string;
  public dateBS: MyDate;
  public observationBS: string;
  public codeUniteDouaniere: UniteDouaniere;
  public codeSection: Sections;
  public identifiantBP: BonPour;
  public matriculeAgent: Agent;


  constructor(
    identifiantBS = '',
    numeroBS = '',
    descriptionBS = '',
    dateBS = new MyDate(),
    observationBS = '',
    codeUniteDouaniere = new UniteDouaniere(),
    codeSection = new Sections(),
    identifiantBP = new BonPour(),
    matriculeAgent = new Agent()
  ) {
    this.identifiantBS = identifiantBS;
    this.numeroBS = numeroBS;
    this.descriptionBS = descriptionBS;
    this.dateBS = dateBS;
    this.observationBS = observationBS;
    this.codeUniteDouaniere = codeUniteDouaniere;
    this.codeSection = codeSection;
    this.identifiantBP = identifiantBP;
    this.matriculeAgent = matriculeAgent;
  }

}
