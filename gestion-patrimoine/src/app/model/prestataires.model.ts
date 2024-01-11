import { SecteurActivite } from "./secteur-activite.model";

export class Prestataires {

  public ninea: string;
  public raisonSociale: string;
  public numeroTelephone: number;
  public adresse: string;
  public adresseEmail: string;
  public secteurActivite: SecteurActivite[] = [];
  public rowSecteurActivite: String;

  constructor(
    ninea: string = '',
    raisonSociale: string = '',
    numeroTelephone: number = 0,
    adresse: string = '',
    adresseEmail: string = '',
    secteurActivite: SecteurActivite[] = [],
    rowSecteurActivite: string = ''
  ) {
    this.ninea = ninea;
    this.raisonSociale = raisonSociale;
    this.numeroTelephone = numeroTelephone;
    this.adresse = adresse;
    this.adresseEmail = adresseEmail;
    this.secteurActivite = secteurActivite;
    this.rowSecteurActivite = rowSecteurActivite;
  }

}
