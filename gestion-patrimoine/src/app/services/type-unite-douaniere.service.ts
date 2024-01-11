import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { TypeUniteDouaniere } from '../model/type-unite-douaniere.model';




@Injectable({
  providedIn: 'root'
})
export class TypeUniteDouaniereService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}


  public listeTypeUniteDouanieres(): Observable<TypeUniteDouaniere[]> {
    return this.httpClient.get<TypeUniteDouaniere[]>(`${this.urlServeur}/TypeUniteDouanieres`);
  }

  public ajouterTypeUniteDouaniere(formData: FormData): Observable<TypeUniteDouaniere> {
    return this.httpClient.post<TypeUniteDouaniere>(`${this.urlServeur}/AjouterTypeUniteDouaniere`, formData);
  }

  public modifierTypeUniteDouaniere(formData: FormData): Observable<TypeUniteDouaniere> {
    return this.httpClient.put<TypeUniteDouaniere>(`${this.urlServeur}/ModifierTypeUniteDouaniere`, formData);
  }

  public supprimerTypeUniteDouaniere(codeTypeUniteDouaniere: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerTypeUniteDouaniereByTypeUniteDouaniereId/${codeTypeUniteDouaniere}`);
  }


  public createBonEntreeFormData(typeUniteDouaniere: TypeUniteDouaniere): FormData {

    const formData = new FormData();

    formData.append('codeTypeUniteDouaniere', typeUniteDouaniere.codeTypeUniteDouaniere);
    formData.append('libelleTypeUniteDouaniere', typeUniteDouaniere.libelleTypeUniteDouaniere);

    return formData;
  }
}
