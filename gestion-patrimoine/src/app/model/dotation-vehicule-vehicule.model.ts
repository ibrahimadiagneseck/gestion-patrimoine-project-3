import { DotationVehicule } from "./dotation-vehicule.model";
import { Vehicule } from "./vehicule.model";


export class DotationVehiculeVehicule {

  public numeroSerie: Vehicule;
  public identifiantDV: DotationVehicule;

  constructor(
    numeroSerie: Vehicule = new Vehicule(),
    identifiantDV: DotationVehicule = new DotationVehicule(),
  ) {
    this.numeroSerie = numeroSerie;
    this.identifiantDV = identifiantDV;
  }

}
