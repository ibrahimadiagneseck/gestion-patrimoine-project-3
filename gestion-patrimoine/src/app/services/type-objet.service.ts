import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { TypeObjet } from '../model/type-objet.model';
import { Agent } from '../model/agent.model';



@Injectable({
  providedIn: 'root'
})
export class TypeObjetService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}


  public listeTypeObjets(): Observable<TypeObjet[]> {
    return this.httpClient.get<TypeObjet[]>(`${this.urlServeur}/TypeObjets`);
  }

  public ajouterTypeObjet(typeObjet: TypeObjet): Observable<TypeObjet> {
    return this.httpClient.post<TypeObjet>(`${this.urlServeur}/AjouterTypeObjet`, typeObjet);
  }

  public ajouterTypeObjetRequestParam(formData: FormData): Observable<TypeObjet> {
    return this.httpClient.post<TypeObjet>(`${this.urlServeur}/AjouterRequestParamTypeObjet`, formData);
  }

  public modifierTypeObjet(formData: FormData): Observable<TypeObjet> {
    return this.httpClient.put<TypeObjet>(`${this.urlServeur}/ModifierTypeObjet`, formData);
  }

  public supprimerTypeObjet(codeTypeObjet: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerTypeObjetByTypeObjetId/${codeTypeObjet}`);
  }


  public createBonEntreeFormData(typeObjet: TypeObjet): FormData {

    const formData = new FormData();

    formData.append('codeTypeObjet', typeObjet.codeTypeObjet);
    formData.append('libelleTypeObjet', typeObjet.libelleTypeObjet);
    formData.append('codeSection', typeObjet.codeSection.codeSection);


    return formData;
  }
}
