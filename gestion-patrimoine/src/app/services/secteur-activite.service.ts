import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { BordereauLivraison } from '../model/bordereau-livraison.model';
import { DatePipe } from '@angular/common';
import { MyDate } from '../model/my-date.model';
import { SecteurActivite } from '../model/secteur-activite.model';

@Injectable({
  providedIn: 'root'
})
export class SecteurActiviteService {

  private urlServeur = environment.apiUrl;

  constructor(
    private httpClient: HttpClient
  ) {}


  public listeSecteurActivites(): Observable<SecteurActivite[]> {
    return this.httpClient.get<SecteurActivite[]>(`${this.urlServeur}/SecteurActivites`);
  }

  public ajouterSecteurActivite(secteurActivite: SecteurActivite): Observable<SecteurActivite> {
    return this.httpClient.post<SecteurActivite>(`${this.urlServeur}/AjouterSecteurActivite`, secteurActivite);
  }

  public ajouterSecteurActiviteRequestParam(formData: FormData): Observable<SecteurActivite> {
    return this.httpClient.post<SecteurActivite>(`${this.urlServeur}/AjouterRequestParamSecteurActivite`, formData);
  }

  public modifierSecteurActivite(formData: FormData): Observable<SecteurActivite> {
    return this.httpClient.put<SecteurActivite>(`${this.urlServeur}/ModifierSecteurActivite`, formData);
  }

  public supprimerSecteurActiviteById(identifiantBL: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerSecteurActiviteById/${identifiantBL}`);
  }


  public createSecteurActiviteFormData(secteurActivite: SecteurActivite): FormData {

    const formData = new FormData();

    formData.append('codeSecteurActivite', secteurActivite.codeSecteurActivite);
    formData.append('libelleSecteurActivite', secteurActivite.libelleSecteurActivite);
    
    return formData;
  }


  
}
