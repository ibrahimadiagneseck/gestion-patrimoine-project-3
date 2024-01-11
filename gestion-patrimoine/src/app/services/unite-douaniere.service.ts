import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { UniteDouaniere } from '../model/unite-douaniere.model';

@Injectable({
  providedIn: 'root'
})
export class UniteDouaniereService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}


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


  public createBonEntreeFormData(uniteDouaniere: UniteDouaniere): FormData {

    const formData = new FormData();

    formData.append('codeUniteDouaniere', uniteDouaniere.codeUniteDouaniere);
    formData.append('nomUniteDouaniere', uniteDouaniere.nomUniteDouaniere);
    formData.append('effectifUniteDouaniere', uniteDouaniere.effectifUniteDouaniere.toString());
    formData.append('nombreArme', uniteDouaniere.nombreArme.toString());
    formData.append('nombreAutomobile', uniteDouaniere.nombreAutomobile.toString());
    formData.append('nombreMateriel', uniteDouaniere.nombreMateriel.toString());
    formData.append('codeTypeUniteDouaniere', JSON.stringify(uniteDouaniere.codeTypeUniteDouaniere));

    return formData;
  }
}
