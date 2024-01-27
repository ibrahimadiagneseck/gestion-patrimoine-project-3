import { Agent } from "./agent.model";
import { BonPour } from "./bon-pour.model";
import { TypeObjet } from "./type-objet.model";


export class ArticleBonPour {

  public identifiantBP: BonPour;
  public libelleArticleBonPour: string;
  public quantiteDemandee: number;
  public codeTypeObjet: TypeObjet;
  public matriculeAgent: Agent;

  constructor(
    identifiantBP = new BonPour(),
    libelleArticleBonPour = '',
    quantiteDemandee = 0,
    codeTypeObjet = new TypeObjet(),
    matriculeAgent = new Agent()
  ) {
    this.identifiantBP = identifiantBP;
    this.libelleArticleBonPour = libelleArticleBonPour;
    this.quantiteDemandee = quantiteDemandee;
    this.codeTypeObjet = codeTypeObjet;
    this.matriculeAgent = matriculeAgent;
  }

}

