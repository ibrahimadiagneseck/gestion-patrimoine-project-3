import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';



import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { UniteDouaniere } from '../model/unite-douaniere.model';

@Injectable({
  providedIn: 'root'
})
export class UniteDouaniereService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) { }

  // RECHERCHER BONENTREE SANS DOUBLONS
  public searchUniteDouaniereListFilterDouble(term: string, listeUniteDouanieres: UniteDouaniere[]): Observable<UniteDouaniere[]> {

    if (term.length <= 1) {
      return of([]);
    }

    // Filtrer la liste de bonEntrees en fonction du terme de recherche
    const filteredUniteDouanieres: UniteDouaniere[] = listeUniteDouanieres.filter((uniteDouaniere) =>
      uniteDouaniere.codeUniteDouaniere.toString().includes(term.toLowerCase()) || uniteDouaniere.nomUniteDouaniere.toLowerCase().includes(term.toLowerCase())
    );

    // Utilisation de la méthode filter() pour éliminer les doublons
    const filteredUniteDouanieres1: UniteDouaniere[] = filteredUniteDouanieres.filter((item, index, self) =>
      index === self.findIndex((t) => (
        t.nomUniteDouaniere === item.nomUniteDouaniere || t.codeUniteDouaniere === item.codeUniteDouaniere
      ))
    );

    return of(filteredUniteDouanieres1);
  }

  // RECHERCHER UniteDouaniere
  public searchUniteDouaniereList(term: string, listeUniteDouanieres: UniteDouaniere[]): Observable<UniteDouaniere[]> {
    if (term.length <= 1) {
      return of([]);
    }

    // Filtrer la liste de UniteDouaniere en fonction du terme de recherche
    const filteredUniteDouanieres = listeUniteDouanieres.filter((uniteDouaniere) =>
      this.doesUniteDouaniereMatchTerm(uniteDouaniere, term)
    );

    return of(filteredUniteDouanieres);
  }

  private doesUniteDouaniereMatchTerm(uniteDouaniere: UniteDouaniere, term: string): boolean {
    // Vérifier si le terme de recherche correspond à n'importe lequel des attributs du uniteDouaniere
    const termLowerCase = term.toLowerCase();
    return (
      uniteDouaniere.codeUniteDouaniere.toString().includes(termLowerCase) || uniteDouaniere.nomUniteDouaniere.toLowerCase().includes(termLowerCase)
      // Ajoutez d'autres attributs à vérifier si nécessaire
    );
  }


  public listeUniteDouanieres(): Observable<UniteDouaniere[]> {
    return this.httpClient.get<UniteDouaniere[]>(`${this.urlServeur}/UniteDouanieres`);
  }

  public ajouterUniteDouaniere(formData: FormData): Observable<UniteDouaniere> {
    return this.httpClient.post<UniteDouaniere>(`${this.urlServeur}/AjouterUniteDouaniere`, formData);
  }

  public modifierUniteDouaniere(formData: FormData): Observable<UniteDouaniere> {
    return this.httpClient.put<UniteDouaniere>(`${this.urlServeur}/ModifierUniteDouaniere`, formData);
  }

  public supprimerUniteDouaniere(codeUniteDouaniere: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerUniteDouaniereByUniteDouaniereId/${codeUniteDouaniere}`);
  }

  public recupererUniteDouaniereById(codeUniteDouaniere: string): Observable<UniteDouaniere> {
    return this.httpClient.get<UniteDouaniere>(`${this.urlServeur}/RecupererUniteDouaniereById/${codeUniteDouaniere}`);
  }

  // public createBonEntreeFormData(uniteDouaniere: UniteDouaniere): FormData {

  //   const formData = new FormData();

  //   formData.append('codeUniteDouaniere', uniteDouaniere.codeUniteDouaniere);
  //   formData.append('nomUniteDouaniere', uniteDouaniere.nomUniteDouaniere);
  //   formData.append('effectifUniteDouaniere', uniteDouaniere.effectifUniteDouaniere.toString());
  //   formData.append('nombreArme', uniteDouaniere.nombreArme.toString());
  //   formData.append('nombreAutomobile', uniteDouaniere.nombreAutomobile.toString());
  //   formData.append('nombreMateriel', uniteDouaniere.nombreMateriel.toString());
  //   formData.append('codeTypeUniteDouaniere', JSON.stringify(uniteDouaniere.codeTypeUniteDouaniere));

  //   return formData;
  // }
}
