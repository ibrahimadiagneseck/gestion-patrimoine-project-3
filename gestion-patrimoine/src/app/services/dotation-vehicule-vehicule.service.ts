import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { DotationVehiculeVehicule } from '../model/dotation-vehicule-vehicule.model';




@Injectable({
  providedIn: 'root'
})
export class DotationVehiculeVehiculeService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}


  // ----------------------------------------------------------------------------
  // // RECHERCHER PRESTATAIRES SANS DOUBLONS
  // public searchPrestatairesListFilterDouble(term: string, listePrestataires: Prestataires[]): Observable<Prestataires[]> {

  //   if (term.length <= 1) {
  //     return of([]);
  //   }

  //   // Filtrer la liste de prestataires en fonction du terme de recherche
  //   const filteredPrestataires: Prestataires[] = listePrestataires.filter((prestataires) =>
  //     prestataires.numeroTelephone.toString().includes(term.toLowerCase()) || prestataires.adresseEmail.toLowerCase().includes(term.toLowerCase())
  //   );

  //   // Utilisation de la méthode filter() pour éliminer les doublons
  //   const filteredPrestataires1: Prestataires[] = filteredPrestataires.filter((item, index, self) =>
  //     index === self.findIndex((t) => (
  //         t.adresseEmail === item.adresseEmail || t.numeroTelephone === item.numeroTelephone
  //     ))
  //   );

  //   return of(filteredPrestataires1);
  // }

  // // RECHERCHER PRESTATAIRES
  // public searchPrestatairesList(term: string, listePrestataires: Prestataires[]): Observable<Prestataires[]> {
  //   if (term.length <= 1) {
  //     return of([]);
  //   }

  //   // Filtrer la liste de Prestataires en fonction du terme de recherche
  //   const filteredPrestataires = listePrestataires.filter((prestataires) =>
  //     this.doesPrestatairesMatchTerm(prestataires, term)
  //   );

  //   return of(filteredPrestataires);
  // }

  // private doesPrestatairesMatchTerm(prestataires: Prestataires, term: string): boolean {
  //   // Vérifier si le terme de recherche correspond à n'importe lequel des attributs du prestataires
  //   const termLowerCase = term.toLowerCase();
  //   return (
  //     prestataires.numeroTelephone.toString().includes(termLowerCase) || prestataires.adresseEmail.toLowerCase().includes(termLowerCase)
  //     // Ajoutez d'autres attributs à vérifier si nécessaire
  //   );
  // }
  // ----------------------------------------------------------------------------



  public listeDotationVehiculeVehicule(): Observable<DotationVehiculeVehicule[]> {
    return this.httpClient.get<DotationVehiculeVehicule[]>(`${this.urlServeur}/DotationVehiculeVehicules`);
  }

  public ajouterDotationVehiculeVehicule(dotationVehiculeVehicule: DotationVehiculeVehicule): Observable<DotationVehiculeVehicule> {
    return this.httpClient.post<DotationVehiculeVehicule>(`${this.urlServeur}/AjouterDotationVehiculeVehicule`, dotationVehiculeVehicule);
  }

  // public ajouterPrestatairesSecteurRequestParam(formData: FormData): Observable<PrestatairesSecteur> {
  //   return this.httpClient.post<PrestatairesSecteur>(`${this.urlServeur}/AjouterRequestParamPrestatairesSecteur`, formData);
  // }

  public modifierDotationVehiculeVehicule(dotationVehiculeVehicule: DotationVehiculeVehicule): Observable<DotationVehiculeVehicule> {
    return this.httpClient.put<DotationVehiculeVehicule>(`${this.urlServeur}/ModifierDotationVehiculeVehicule`, dotationVehiculeVehicule);
  }


  public supprimerDotationVehiculeVehiculeById(numeroSerie: string, identifiantDV: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerDotationVehiculeVehiculeById/${numeroSerie}/${identifiantDV}`);
  }

  public recupererDotationByVehiculeId(numeroSerie: string): Observable<DotationVehiculeVehicule> {
    return this.httpClient.get<DotationVehiculeVehicule>(`${this.urlServeur}/RecupererDotationByVehiculeId/${numeroSerie}`);
  }


  // public createPrestatairesFormData(prestataires: Prestataires): FormData {

  //   const formData = new FormData();

  //   formData.append('ninea', prestataires.ninea);
  //   formData.append('raisonSociale', prestataires.raisonSociale);
  //   formData.append('numeroTelephone', prestataires.numeroTelephone.toString());
  //   formData.append('adresseEmail', prestataires.adresseEmail);
  //   formData.append('adresse', prestataires.adresse);
  //   return formData;
  // }
}
