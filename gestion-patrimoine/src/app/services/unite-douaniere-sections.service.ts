import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { UniteDouaniere } from '../model/unite-douaniere.model';
import { Sections } from '../model/sections.model';
import { UniteDouaniereSections } from '../model/unite-douaniere-sections.model';

@Injectable({
  providedIn: 'root'
})
export class UniteDouaniereSectionsService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}


  public listeUniteDouaniereSections(): Observable<UniteDouaniereSections[]> {
    return this.httpClient.get<UniteDouaniereSections[]>(`${this.urlServeur}/UniteDouaniereSections`);
  }

  public ajouterUniteDouaniereSections(formData: FormData): Observable<UniteDouaniereSections> {
    return this.httpClient.post<UniteDouaniereSections>(`${this.urlServeur}/AjouterUniteDouaniereSections`, formData);
  }

  public modifierUniteDouaniereSections(formData: FormData): Observable<UniteDouaniereSections> {
    return this.httpClient.put<UniteDouaniereSections>(`${this.urlServeur}/ModifierUniteDouaniereSections`, formData);
  }

  public supprimerUniteDouaniereSections(codeUniteDouaniereSections: string, codeSection: Sections): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerUniteDouaniereSectionsByUniteDouaniereSectionsId/${codeUniteDouaniereSections}/${codeSection}`);
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
