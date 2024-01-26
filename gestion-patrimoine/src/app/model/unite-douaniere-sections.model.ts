import { Sections } from "./sections.model";
import { TypeUniteDouaniere } from "./type-unite-douaniere.model";
import { UniteDouaniere } from "./unite-douaniere.model";

export class UniteDouaniereSections {

  public codeUniteDouaniere: UniteDouaniere;
  public codeSection: Sections;


  constructor(
    codeUniteDouaniere = new UniteDouaniere(),
    codeSection = new Sections()
  ) {
    this.codeUniteDouaniere = codeUniteDouaniere;
    this.codeSection = codeSection;
  }

}
