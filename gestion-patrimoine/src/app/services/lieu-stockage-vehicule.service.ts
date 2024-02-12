import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { LieuStockageVehicule } from '../model/lieu-stockage-vehicule.model';





@Injectable({
  providedIn: 'root'
})
export class LieuStockageVehiculeService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}


  public listeLieuStockageVehicules(): Observable<LieuStockageVehicule[]> {
    return this.httpClient.get<LieuStockageVehicule[]>(`${this.urlServeur}/LieuStockageVehicules`);
  }

  public ajouterLieuStockageVehicule(lieuStockageVehicule: LieuStockageVehicule): Observable<LieuStockageVehicule> {
    return this.httpClient.post<LieuStockageVehicule>(`${this.urlServeur}/AjouterLieuStockageVehicule`, lieuStockageVehicule);
  }

  // public ajouterTypeEnergieRequestParam(formData: FormData): Observable<TypeEnergie> {
  //   return this.httpClient.post<TypeEnergie>(`${this.urlServeur}/AjouterRequestParamTypeEnergie`, formData);
  // }

  public modifierLieuStockageVehicule(formData: FormData): Observable<LieuStockageVehicule> {
    return this.httpClient.put<LieuStockageVehicule>(`${this.urlServeur}/ModifierLieuStockageVehicule`, formData);
  }

  public supprimerLieuStockageVehicule(codeLieuVH: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerLieuStockageVehiculeById/${codeLieuVH}`);
  }


  // public createBonEntreeFormData(typeEnergie: TypeEnergie): FormData {

  //   const formData = new FormData();

  //   formData.append('codeTypeEnergie', typeEnergie.codeTypeEnergie);
  //   formData.append('libelleTypeEnergie', typeEnergie.libelleTypeEnergie);

  //   return formData;
  // }
}
