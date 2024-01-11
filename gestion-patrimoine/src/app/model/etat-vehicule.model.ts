
export class EtatVehicule {

  public codeEtat: string;
  public libelleEtat: string;

  constructor(
    codeEtat = '',
    libelleEtat = ''
  ) {
    this.codeEtat = codeEtat;
    this.libelleEtat = libelleEtat;
  }

}
