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
  // RECHERCHER BONENTREE SANS DOUBLONS
  // public searchBonEntreeListFilterDouble(term: string, listeBonEntrees: BonEntree[]): Observable<BonEntree[]> {

  //   if (term.length <= 1) {
  //     return of([]);
  //   }

  //   // Filtrer la liste de bonEntrees en fonction du terme de recherche
  //   const filteredBonEntrees: BonEntree[] = listeBonEntrees.filter((bonEntree) =>
  //     bonEntree.numeroBE.toString().includes(term.toLowerCase()) || bonEntree.libelleBonEntree.toLowerCase().includes(term.toLowerCase())
  //   );

  //   // Utilisation de la méthode filter() pour éliminer les doublons
  //   const filteredBonEntrees1: BonEntree[] = filteredBonEntrees.filter((item, index, self) =>
  //     index === self.findIndex((t) => (
  //         t.libelleBonEntree === item.libelleBonEntree || t.numeroBE === item.numeroBE
  //     ))
  //   );

  //   return of(filteredBonEntrees1);
  // }

  // // RECHERCHER BONENTREE
  // public searchBonEntreeList(term: string, listeBonEntrees: BonEntree[]): Observable<BonEntree[]> {
  //   if (term.length <= 1) {
  //     return of([]);
  //   }

  //   // Filtrer la liste de BonEntree en fonction du terme de recherche
  //   const filteredBonEntrees = listeBonEntrees.filter((bonEntree) =>
  //     this.doesBonEntreeMatchTerm(bonEntree, term)
  //   );

  //   return of(filteredBonEntrees);
  // }

  // private doesBonEntreeMatchTerm(bonEntree: BonEntree, term: string): boolean {
  //   // Vérifier si le terme de recherche correspond à n'importe lequel des attributs du bonEntree
  //   const termLowerCase = term.toLowerCase();
  //   return (
  //     bonEntree.numeroBE.toString().includes(termLowerCase) || bonEntree.libelleBonEntree.toLowerCase().includes(termLowerCase)
  //     // Ajoutez d'autres attributs à vérifier si nécessaire
  //   );
  // }
  // ----------------------------------------------------------------------------


  // ----------------------------------------------------------------------------
  //  CRUD BONENTREE

  public listeBonPours(): Observable<BonPour[]> {
    return this.httpClient.get<BonPour[]>(`${this.urlServeur}/BonPours`);
  }

  public ajouterBonPour(bonPour: BonPour): Observable<BonPour> {
    return this.httpClient.post<BonPour>(`${this.urlServeur}/AjouterBonPour`, bonPour);
  }

  // public ajouterBonEntreeRequestParam(formData: FormData): Observable<BonPour> {
  //   return this.httpClient.post<BonPour>(`${this.urlServeur}/AjouterRequestParamBonEntree`, formData);
  // }

  public modifierBonPour(bonPour: BonPour): Observable<BonPour> {
    return this.httpClient.put<BonPour>(`${this.urlServeur}/ModifierBonPour`, bonPour);
  }

  public supprimerBonPourById(identifiantBP: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerBonPourById/${identifiantBP}`);
  }

  public recupererBonEntreeById(identifiantBP: string): Observable<BonPour> {
    return this.httpClient.get<BonPour>(`${this.urlServeur}/RecupererBonEntreeById/${identifiantBP}`);
  }


//   public createBonEntreeFormData(bonEntree: BonEntree): FormData {

//     const formData = new FormData();

//     const formattedDate = this.formatterMyDate(bonEntree.dateBonEntree);

//     formData.append('numeroBE', bonEntree.numeroBE);
//     formData.append('libelleBonEntree', bonEntree.libelleBonEntree);
//     formData.append('dateBonEntree', formattedDate);
//     formData.append('observationBonEntree', bonEntree.observationBonEntree);
//     formData.append('identifiantBL', bonEntree.identifiantBL.identifiantBL);

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
