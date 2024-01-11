import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { TypeEnergie } from '../model/type-energie.model';





@Injectable({
  providedIn: 'root'
})
export class TypeEnergieService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}


  public listeTypeEnergies(): Observable<TypeEnergie[]> {
    return this.httpClient.get<TypeEnergie[]>(`${this.urlServeur}/TypeEnergies`);
  }

  public ajouterTypeEnergie(typeEnergie: TypeEnergie): Observable<TypeEnergie> {
    return this.httpClient.post<TypeEnergie>(`${this.urlServeur}/AjouterTypeEnergie`, typeEnergie);
  }

  public ajouterTypeEnergieRequestParam(formData: FormData): Observable<TypeEnergie> {
    return this.httpClient.post<TypeEnergie>(`${this.urlServeur}/AjouterRequestParamTypeEnergie`, formData);
  }

  public modifierTypeEnergie(formData: FormData): Observable<TypeEnergie> {
    return this.httpClient.put<TypeEnergie>(`${this.urlServeur}/ModifierTypeEnergie`, formData);
  }

  public supprimerTypeEnergie(codeTypeEnergie: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerTypeEnergieByTypeEnergieId/${codeTypeEnergie}`);
  }


  public createBonEntreeFormData(typeEnergie: TypeEnergie): FormData {

    const formData = new FormData();

    formData.append('codeTypeEnergie', typeEnergie.codeTypeEnergie);
    formData.append('libelleTypeEnergie', typeEnergie.libelleTypeEnergie);

    return formData;
  }
}
