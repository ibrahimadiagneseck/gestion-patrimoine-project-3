import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { MarqueVehicule } from '../model/marque-vehicule.model';


@Injectable({
  providedIn: 'root'
})
export class MarqueVehiculeService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}


  public listeMarqueVehicules(): Observable<MarqueVehicule[]> {
    return this.httpClient.get<MarqueVehicule[]>(`${this.urlServeur}/MarqueVehicules`);
  }

  public ajouterMarqueVehicule(formData: FormData): Observable<MarqueVehicule> {
    return this.httpClient.post<MarqueVehicule>(`${this.urlServeur}/AjouterMarqueVehicule`, formData);
  }

  public modifierMarqueVehicule(formData: FormData): Observable<MarqueVehicule> {
    return this.httpClient.put<MarqueVehicule>(`${this.urlServeur}/ModifierMarqueVehicule`, formData);
  }

  public supprimerMarqueVehicule(codeMarque: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerMarqueVehiculeByMarqueVehiculeId/${codeMarque}`);
  }


  public createBonEntreeFormData(marqueVehicule: MarqueVehicule): FormData {

    const formData = new FormData();

    formData.append('codeMarque', marqueVehicule.codeMarque);
    formData.append('libelleMarque', marqueVehicule.libelleMarque);

    return formData;
  }
}
