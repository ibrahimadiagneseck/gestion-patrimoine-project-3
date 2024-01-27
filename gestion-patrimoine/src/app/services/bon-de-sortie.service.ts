import { HttpClient, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { BonEntree } from '../model/bon-entree.model';
import { MyDate } from '../model/my-date.model';
import { DatePipe } from '@angular/common';
import { BonDeSortie } from '../model/bonDeSortie.model';

@Injectable({
  providedIn: 'root',
})
export class BonDeSortieService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}

  // ----------------------------------------------------------------------------
  // // RECHERCHER BONENTREE SANS DOUBLONS
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
  //  CRUD BonDeSortie

  public listeBonDeSorties(): Observable<BonDeSortie[]> {
    return this.httpClient.get<BonDeSortie[]>(`${this.urlServeur}/BonDeSorties`);
  }

  public ajouterBonDeSortie(BonDeSortie: BonDeSortie): Observable<BonDeSortie> {
    return this.httpClient.post<BonDeSortie>(`${this.urlServeur}/AjouterBonDeSortie`, BonDeSortie);
  }

  // public ajouterBonDeSortieRequestParam(formData: FormData): Observable<BonDeSortie> {
  //   return this.httpClient.post<BonDeSortie>(`${this.urlServeur}/AjouterRequestParamBonDeSortie`, formData);
  // }

  public modifierBonDeSortie(bonDeSortie: BonDeSortie): Observable<BonDeSortie> {
    return this.httpClient.put<BonDeSortie>(`${this.urlServeur}/ModifierBonDeSortie`, bonDeSortie);
  }

  public supprimerBonDeSortieById(identifiantBE: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerBonDeSortieById/${identifiantBE}`);
  }

  public recupererBonDeSortieById(idIdentifiantBE: string): Observable<BonDeSortie> {
    return this.httpClient.get<BonDeSortie>(`${this.urlServeur}/RecupererBonDeSortieById/${idIdentifiantBE}`);
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
