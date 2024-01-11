import { CorpsAgent } from "./corps-agent.model";
import { FonctionAgent } from "./fonction-agent.model";
import { UniteDouaniere } from "./unite-douaniere.model";


export class Agent {

  public matriculeAgent: string;
  public codeAgent: string;
  public nomAgent: string;
  public prenomAgent: string;
  public numeroTelephoneAgent: number;
  public codeFonctionAgent: FonctionAgent;
  public codeUniteDouaniere: UniteDouaniere;
  public codeCorpsAgent: CorpsAgent;


  constructor(
    matriculeAgent = '',
    codeAgent = '',
    nomAgent = '',
    prenomAgent = '',
    numeroTelephoneAgent = 0,
    codeFonctionAgent = new FonctionAgent(),
    codeUniteDouaniere = new UniteDouaniere(),
    codeCorpsAgent = new CorpsAgent()
  ) {
    this.matriculeAgent = matriculeAgent;
    this.codeAgent = codeAgent;
    this.nomAgent = nomAgent;
    this.prenomAgent = prenomAgent;
    this.numeroTelephoneAgent = numeroTelephoneAgent;
    this.codeFonctionAgent = codeFonctionAgent;
    this.codeUniteDouaniere = codeUniteDouaniere;
    this.codeCorpsAgent = codeCorpsAgent;
  }

}
