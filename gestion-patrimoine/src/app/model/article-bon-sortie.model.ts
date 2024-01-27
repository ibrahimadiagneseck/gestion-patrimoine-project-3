import { Agent } from "./agent.model";
import { ArticleBonEntree } from "./article-bon-entree.model";
import { MyDate } from "./my-date.model";

export class ArticleBonSortie {

  public identifiantBS: string;
  public codeArticleBonSortie: string;
  public libelleArticleBonSortie: string;
  public quantiteAccordee: number;
  public dateArticleBonSortie: MyDate;
  public identifiantBE: ArticleBonEntree;
  public matriculeAgent: Agent;


  constructor(
    identifiantBS = '',
    codeArticleBonSortie = '',
    libelleArticleBonSortie = '',
    quantiteAccordee = 0,
    dateArticleBonSortie = new MyDate(),
    identifiantBE = new ArticleBonEntree(),
    matriculeAgent = new Agent
  ) {
    this.identifiantBS = identifiantBS;
    this.codeArticleBonSortie = codeArticleBonSortie;
    this.libelleArticleBonSortie = libelleArticleBonSortie;
    this.quantiteAccordee = quantiteAccordee;
    this.dateArticleBonSortie = dateArticleBonSortie;
    this.identifiantBE = identifiantBE;
    this.matriculeAgent = matriculeAgent;
  }

}
