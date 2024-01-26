import { Agent } from "./agent.model";
import { MyDate } from "./my-date.model";
import { Sections } from "./sections.model";
import { UniteDouaniere } from "./unite-douaniere.model";

export class BonPour {

  identifiantBP: string;
  descriptionBP: string;
  numeroCourrielOrigine: number;
  dateCourrielOrigine: MyDate;
  etatBP: string;
  objectCourrielOrigine: string;
  numeroArriveDLF: number;
  dateArriveDLF: MyDate;
  numeroArriveBLM: number;
  dateArriveBLM: MyDate;
  numeroArriveSection: number;
  dateArriveSection: MyDate;
  codeUniteDouaniere: UniteDouaniere;
  observationBP: string;
  codeSection: Sections;
  matriculeAgent: Agent;

  constructor(
    identifiantBP = '',
    descriptionBP = '',
    numeroCourrielOrigine = 0,
    dateCourrielOrigine = new MyDate(),
    etatBP = '',
    objectCourrielOrigine = '',
    numeroArriveDLF = 0,
    dateArriveDLF = new MyDate(),
    numeroArriveBLM = 0,
    dateArriveBLM = new MyDate(),
    numeroArriveSection = 0,
    dateArriveSection = new MyDate(),
    codeUniteDouaniere = new UniteDouaniere(),
    observationBP = '',
    codeSection = new Sections(),
    matriculeAgent = new Agent()
  ) {
    this.identifiantBP = identifiantBP;
    this.descriptionBP = descriptionBP;
    this.numeroCourrielOrigine = numeroCourrielOrigine;
    this.dateCourrielOrigine = dateCourrielOrigine;
    this.etatBP = etatBP;
    this.objectCourrielOrigine = objectCourrielOrigine;
    this.numeroArriveDLF = numeroArriveDLF;
    this.dateArriveDLF = dateArriveDLF;
    this.numeroArriveBLM = numeroArriveBLM;
    this.dateArriveBLM = dateArriveBLM;
    this.numeroArriveSection = numeroArriveSection;
    this.dateArriveSection = dateArriveSection;
    this.codeUniteDouaniere = codeUniteDouaniere;
    this.observationBP = observationBP;
    this.codeSection = codeSection;
    this.matriculeAgent = matriculeAgent;
  }

}
