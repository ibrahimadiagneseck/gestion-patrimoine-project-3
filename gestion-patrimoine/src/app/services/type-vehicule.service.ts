import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { TypeVehicule } from '../model/type-vehicule.model';





@Injectable({
  providedIn: 'root'
})
export class TypeVehiculeService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}


  public listeTypeVehicules(): Observable<TypeVehicule[]> {
    return this.httpClient.get<TypeVehicule[]>(`${this.urlServeur}/TypeVehicules`);
  }

  public ajouterTypeVehicule(formData: FormData): Observable<TypeVehicule> {
    return this.httpClient.post<TypeVehicule>(`${this.urlServeur}/AjouterTypeVehicule`, formData);
  }

  public modifierTypeVehicule(formData: FormData): Observable<TypeVehicule> {
    return this.httpClient.put<TypeVehicule>(`${this.urlServeur}/ModifierTypeVehicule`, formData);
  }

  public supprimerTypeVehicule(codeTypeVehicule: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerTypeVehiculeByTypeVehiculeId/${codeTypeVehicule}`);
  }


  public createBonEntreeFormData(typeVehicule: TypeVehicule): FormData {

    const formData = new FormData();

    formData.append('codeTypeVehicule', typeVehicule.codeTypeVehicule);
    formData.append('libelleTypeVehicule', typeVehicule.libelleTypeVehicule);

    return formData;
  }
}
