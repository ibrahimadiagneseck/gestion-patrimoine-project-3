import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { Prestataires } from '../model/prestataires.model';



@Injectable({
  providedIn: 'root'
})
export class PrestatairesService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}


  // ----------------------------------------------------------------------------
  // RECHERCHER PRESTATAIRES SANS DOUBLONS
  public searchPrestatairesListFilterDouble(term: string, listePrestataires: Prestataires[]): Observable<Prestataires[]> {

    if (term.length <= 1) {
      return of([]);
    }

    // Filtrer la liste de prestataires en fonction du terme de recherche
    const filteredPrestataires: Prestataires[] = listePrestataires.filter((prestataires) =>
      prestataires.numeroTelephone.toString().includes(term.toLowerCase()) || prestataires.adresseEmail.toLowerCase().includes(term.toLowerCase())
    );

    // Utilisation de la méthode filter() pour éliminer les doublons
    const filteredPrestataires1: Prestataires[] = filteredPrestataires.filter((item, index, self) =>
      index === self.findIndex((t) => (
          t.adresseEmail === item.adresseEmail || t.numeroTelephone === item.numeroTelephone
      ))
    );

    return of(filteredPrestataires1);
  }

  // RECHERCHER PRESTATAIRES
  public searchPrestatairesList(term: string, listePrestataires: Prestataires[]): Observable<Prestataires[]> {
    if (term.length <= 1) {
      return of([]);
    }

    // Filtrer la liste de Prestataires en fonction du terme de recherche
    const filteredPrestataires = listePrestataires.filter((prestataires) =>
      this.doesPrestatairesMatchTerm(prestataires, term)
    );

    return of(filteredPrestataires);
  }

  private doesPrestatairesMatchTerm(prestataires: Prestataires, term: string): boolean {
    // Vérifier si le terme de recherche correspond à n'importe lequel des attributs du prestataires
    const termLowerCase = term.toLowerCase();
    return (
      prestataires.numeroTelephone.toString().includes(termLowerCase) || prestataires.adresseEmail.toLowerCase().includes(termLowerCase)
      // Ajoutez d'autres attributs à vérifier si nécessaire
    );
  }
  // ----------------------------------------------------------------------------



  public listePrestataires(): Observable<Prestataires[]> {
    return this.httpClient.get<Prestataires[]>(`${this.urlServeur}/Prestataires`);
  }

  public ajouterPrestataires(prestataires: Prestataires): Observable<Prestataires> {
    return this.httpClient.post<Prestataires>(`${this.urlServeur}/AjouterPrestataires`, prestataires);
  }

  public ajouterPrestatairesRequestParam(formData: FormData): Observable<Prestataires> {
    return this.httpClient.post<Prestataires>(`${this.urlServeur}/AjouterRequestParamPrestataires`, formData);
  }

  public modifierPrestataires(prestataires: Prestataires): Observable<Prestataires> {
    return this.httpClient.put<Prestataires>(`${this.urlServeur}/ModifierPrestataires`, prestataires);
  }
  

  public supprimerPrestatairesById(ninea: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerPrestatairesById/${ninea}`);
  }


  public createPrestatairesFormData(prestataires: Prestataires): FormData {

    const formData = new FormData();

    formData.append('ninea', prestataires.ninea);
    formData.append('raisonSociale', prestataires.raisonSociale);
    formData.append('numeroTelephone', prestataires.numeroTelephone.toString());
    formData.append('adresseEmail', prestataires.adresseEmail);
    formData.append('adresse', prestataires.adresse);
    return formData;
  }
}
