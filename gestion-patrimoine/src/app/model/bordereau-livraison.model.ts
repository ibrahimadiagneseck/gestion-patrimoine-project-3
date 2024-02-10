import { Agent } from "./agent.model";
import { MyDate } from "./my-date.model";
import { Prestataires } from "./prestataires.model";
import { Sections } from "./sections.model";


export class BordereauLivraison {

  public identifiantBL: string;
  public numeroBL: string;
  public descriptionBL: string;
  public lieuDeLivraison: string;
  public dateBL: MyDate;
  public conformiteBL: string;
  public representantPrestataire: string;
  public codeSection: Sections;
  public ninea: Prestataires;
  public matriculeAgent: Agent;
  // public dateEnregistrement: number;


  // constructor() {
  //   // this.identifiantBL = '';
  //   this.numeroBL = '';
  //   this.descriptionBL = '';
  //   this.lieuDeLivraison = '';
  //   this.dateBL = new MyDate();
  //   this.conformiteBL ='';
  //   this.nomLivreur ='';
  //   this.codeSection = new Sections() ;
  //   this.ninea = new Prestataires() ;
  //   this.matriculeAgent = new Agent() ;
  //   // this.dateEnregistrement = new Date().getTime();
  // }

  constructor(
    identifiantBL: string = '',
    numeroBL: string = '',
    descriptionBL: string = '',
    lieuDeLivraison: string = '',
    dateBL: MyDate = new MyDate(),
    conformiteBL: string = '',
    representantPrestataire: string = '',
    codeSection: Sections = new Sections(),
    ninea: Prestataires = new Prestataires(),
    matriculeAgent: Agent = new Agent()
  ) {
    this.identifiantBL = identifiantBL;
    this.numeroBL = numeroBL;
    this.descriptionBL = descriptionBL;
    this.lieuDeLivraison = lieuDeLivraison;
    this.dateBL = dateBL;
    this.conformiteBL = conformiteBL;
    this.representantPrestataire = representantPrestataire;
    this.codeSection = codeSection;
    this.ninea = ninea;
    this.matriculeAgent = matriculeAgent;
  }

}
