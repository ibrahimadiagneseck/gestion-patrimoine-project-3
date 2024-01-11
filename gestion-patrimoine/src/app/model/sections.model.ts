import { UniteDouaniere } from "./unite-douaniere.model";


export class Sections {

  public codeSection: string;
  public libelleSection: string;
  public codeUniteDouaniere: UniteDouaniere;
 ;


  constructor(
    codeSection = '',
    libelleSection = '',
    codeUniteDouaniere = new UniteDouaniere()
  ) {
    this.codeSection = codeSection;
    this.libelleSection = libelleSection;
    this.codeUniteDouaniere = codeUniteDouaniere;
  }

}
