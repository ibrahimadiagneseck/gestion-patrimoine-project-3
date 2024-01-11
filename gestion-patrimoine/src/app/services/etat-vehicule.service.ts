import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { EtatVehicule } from '../model/etat-vehicule.model';


@Injectable({
  providedIn: 'root'
})
export class EtatVehiculeService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}


  public listeEtatVehicules(): Observable<EtatVehicule[]> {
    return this.httpClient.get<EtatVehicule[]>(`${this.urlServeur}/EtatVehicules`);
  }

  public ajouterEtatVehicule(formData: FormData): Observable<EtatVehicule> {
    return this.httpClient.post<EtatVehicule>(`${this.urlServeur}/AjouterEtatVehicule`, formData);
  }

  public modifierEtatVehicule(formData: FormData): Observable<EtatVehicule> {
    return this.httpClient.put<EtatVehicule>(`${this.urlServeur}/ModifierEtatVehicule`, formData);
  }

  public supprimerEtatVehicule(codeMarque: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerEtatVehiculeByEtatVehiculeId/${codeMarque}`);
  }


  public createBonEntreeFormData(etatVehicule: EtatVehicule): FormData {

    const formData = new FormData();

    formData.append('codeEtat', etatVehicule.codeEtat);
    formData.append('libelleEtat', etatVehicule.libelleEtat);

    return formData;
  }
}
