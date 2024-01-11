import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { FonctionAgent } from '../model/fonction-agent.model';


@Injectable({
  providedIn: 'root'
})
export class FonctionAgentService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}


  public listeFonctionAgents(): Observable<FonctionAgent[]> {
    return this.httpClient.get<FonctionAgent[]>(`${this.urlServeur}/FonctionAgents`);
  }

  public ajouterFonctionAgent(formData: FormData): Observable<FonctionAgent> {
    return this.httpClient.post<FonctionAgent>(`${this.urlServeur}/AjouterFonctionAgent`, formData);
  }

  public modifierFonctionAgent(formData: FormData): Observable<FonctionAgent> {
    return this.httpClient.put<FonctionAgent>(`${this.urlServeur}/ModifierFonctionAgent`, formData);
  }

  public supprimerFonctionAgent(codeFonctionAgent: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerFonctionAgentByFonctionAgentId/${codeFonctionAgent}`);
  }


  public createBonEntreeFormData(fonctionAgent: FonctionAgent): FormData {

    const formData = new FormData();

    formData.append('codeFonctionAgent', fonctionAgent.codeFonctionAgent);
    formData.append('libelleFonctionAgent', fonctionAgent.libelleFonctionAgent);

    return formData;
  }
}
