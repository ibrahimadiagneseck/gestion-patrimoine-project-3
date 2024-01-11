import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { CorpsAgent } from '../model/corps-agent.model';


@Injectable({
  providedIn: 'root'
})
export class CorpsAgentService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}


  public listeCorpsAgents(): Observable<CorpsAgent[]> {
    return this.httpClient.get<CorpsAgent[]>(`${this.urlServeur}/CorpsAgents`);
  }

  public ajouterCorpsAgent(formData: FormData): Observable<CorpsAgent> {
    return this.httpClient.post<CorpsAgent>(`${this.urlServeur}/AjouterCorpsAgent`, formData);
  }

  public modifierCorpsAgent(formData: FormData): Observable<CorpsAgent> {
    return this.httpClient.put<CorpsAgent>(`${this.urlServeur}/ModifierCorpsAgent`, formData);
  }

  public supprimerCorpsAgent(codeCorpsAgent: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerCorpsAgentByCorpsAgentId/${codeCorpsAgent}`);
  }


  public createBonEntreeFormData(corpsAgent: CorpsAgent): FormData {

    const formData = new FormData();

    formData.append('codeCorpsAgent', corpsAgent.codeCorpsAgent);
    formData.append('libelleCorpsAgent', corpsAgent.libelleCorpsAgent);

    return formData;
  }
}
