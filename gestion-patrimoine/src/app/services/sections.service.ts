import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



import { environment } from 'src/environments/environment';
import { BonEntree } from '../model/bon-entree.model';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { Sections } from '../model/sections.model';

@Injectable({
  providedIn: 'root'
})
export class SectionsService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}


  public listeSections(): Observable<Sections[]> {
    return this.httpClient.get<Sections[]>(`${this.urlServeur}/Sections`);
  }

  public ajouterSections(formData: FormData): Observable<Sections> {
    return this.httpClient.post<Sections>(`${this.urlServeur}/AjouterSections`, formData);
  }

  public modifierSections(formData: FormData): Observable<Sections> {
    return this.httpClient.put<Sections>(`${this.urlServeur}/ModifierSections`, formData);
  }

  public supprimerSections(codeSection: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerSectionsBySectionsId/${codeSection}`);
  }


  // public createBonEntreeFormData(sections: Sections): FormData {

  //   const formData = new FormData();

  //   formData.append('codeSection', sections.codeSection);
  //   formData.append('libelleSection', sections.libelleSection);

  //   return formData;
  // }
}
