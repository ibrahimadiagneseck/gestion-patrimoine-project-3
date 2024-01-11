import { Prestataires } from "./prestataires.model";

export class SecteurActivite {

  public codeSecteurActivite: string;
  public libelleSecteurActivite: string;
  // public prestataires: Prestataires[] = [];

  constructor(
    codeSecteurActivite: string = '',
    libelleSecteurActivite: string = '',
    // prestataires: Prestataires[] = []
  ) {
    this.codeSecteurActivite = codeSecteurActivite;
    this.libelleSecteurActivite = libelleSecteurActivite;
    // this.prestataires = prestataires;
  }

}
