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
  observationDLF: string;
  numeroArriveBLM: number;
  dateArriveBLM: MyDate;
  observationBLM: string;
  numeroArriveSection: number;
  dateArriveSection: MyDate;
  observationSection: string;
  codeUniteDouaniere: UniteDouaniere;
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
    observationDLF = '',
    numeroArriveBLM = 0,
    dateArriveBLM = new MyDate(),
    observationBLM = '',
    numeroArriveSection = 0,
    dateArriveSection = new MyDate(),
    observationSection = '',
    codeUniteDouaniere = new UniteDouaniere(),
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
    this.observationDLF = observationDLF;
    this.numeroArriveBLM = numeroArriveBLM;
    this.dateArriveBLM = dateArriveBLM;
    this.observationBLM = observationBLM;
    this.numeroArriveSection = numeroArriveSection;
    this.dateArriveSection = dateArriveSection;
    this.observationSection = observationSection;
    this.codeUniteDouaniere = codeUniteDouaniere;
    this.codeSection = codeSection;
    this.matriculeAgent = matriculeAgent;
  }

}
