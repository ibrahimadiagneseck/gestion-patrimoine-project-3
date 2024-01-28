import { HttpClient, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { MyDate } from '../model/my-date.model';
import { DatePipe } from '@angular/common';
import { BonPour } from '../model/bon-pour.model';

@Injectable({
  providedIn: 'root',
})
export class BonPourService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}

  // ----------------------------------------------------------------------------
  // RECHERCHER BONPOUR SANS DOUBLONS
  public searchBonPourListFilterDouble(term: string, listeBonPours: BonPour[]): Observable<BonPour[]> {

    if (term.length <= 1) {
      return of([]);
    }

    // Filtrer la liste de BonPours en fonction du terme de recherche
    const filteredBonPours: BonPour[] = listeBonPours.filter((BonPour) =>
      BonPour.numeroCourrielOrigine.toString().includes(term.toLowerCase()) || BonPour.objectCourrielOrigine.toLowerCase().includes(term.toLowerCase())
    );

    // Utilisation de la méthode filter() pour éliminer les doublons
    const filteredBonPours1: BonPour[] = filteredBonPours.filter((item, index, self) =>
      index === self.findIndex((t) => (
          t.objectCourrielOrigine === item.objectCourrielOrigine || t.numeroCourrielOrigine === item.numeroCourrielOrigine
      ))
    );

    return of(filteredBonPours1);
  }

  // RECHERCHER BonPour
  public searchBonPourList(term: string, listeBonPours: BonPour[]): Observable<BonPour[]> {
    if (term.length <= 1) {
      return of([]);
    }

    // Filtrer la liste de BonPour en fonction du terme de recherche
    const filteredBonPours = listeBonPours.filter((BonPour) =>
      this.doesBonPourMatchTerm(BonPour, term)
    );

    return of(filteredBonPours);
  }

  private doesBonPourMatchTerm(BonPour: BonPour, term: string): boolean {
    // Vérifier si le terme de recherche correspond à n'importe lequel des attributs du BonPour
    const termLowerCase = term.toLowerCase();
    return (
      BonPour.numeroCourrielOrigine.toString().includes(termLowerCase) || BonPour.objectCourrielOrigine.toLowerCase().includes(termLowerCase)
      // Ajoutez d'autres attributs à vérifier si nécessaire
    );
  }
  // ----------------------------------------------------------------------------


  // ----------------------------------------------------------------------------
  //  CRUD BonPour

  public listeBonPours(): Observable<BonPour[]> {
    return this.httpClient.get<BonPour[]>(`${this.urlServeur}/BonPours`);
  }

  public ajouterBonPour(bonPour: BonPour): Observable<BonPour> {
    return this.httpClient.post<BonPour>(`${this.urlServeur}/AjouterBonPour`, bonPour);
  }

  // public ajouterBonPourRequestParam(formData: FormData): Observable<BonPour> {
  //   return this.httpClient.post<BonPour>(`${this.urlServeur}/AjouterRequestParamBonPour`, formData);
  // }

  public modifierBonPour(bonPour: BonPour): Observable<BonPour> {
    return this.httpClient.put<BonPour>(`${this.urlServeur}/ModifierBonPour`, bonPour);
  }

  public supprimerBonPourById(identifiantBP: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerBonPourById/${identifiantBP}`);
  }

  public recupererBonPourById(identifiantBP: string): Observable<BonPour> {
    return this.httpClient.get<BonPour>(`${this.urlServeur}/RecupererBonPourById/${identifiantBP}`);
  }


//   public createBonPourFormData(BonPour: BonPour): FormData {

//     const formData = new FormData();

//     const formattedDate = this.formatterMyDate(BonPour.dateBonPour);

//     formData.append('numeroBE', BonPour.numeroBE);
//     formData.append('libelleBonPour', BonPour.libelleBonPour);
//     formData.append('dateBonPour', formattedDate);
//     formData.append('observationBonPour', BonPour.observationBonPour);
//     formData.append('identifiantBL', BonPour.identifiantBL.identifiantBL);

//     return formData;
//   }


public formatterMyDate(myDate: MyDate): string  {

  if (!myDate || !myDate.year || !myDate.month || !myDate.day) {
      return '';
  }

  const { year, month, day } = myDate;
  const date = new Date(year, month - 1, day);

  const datePipe = new DatePipe('en-US');
  const formattedDate = datePipe.transform(date, 'yyyy-MM-dd') || '';

  return formattedDate;
}



}
// ----------------------------------------------------------------------------
