import { HttpClient, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { BonEntree } from '../model/bon-entree.model';
import { ArticleBonEntree } from '../model/article-bon-entree.model';
import { ArticleBonSortie } from '../model/article-bon-sortie.model';
import { MyDate } from '../model/my-date.model';
import { DatePipe } from '@angular/common';
import { BonPour } from '../model/bon-pour.model';
import { BonDeSortie } from '../model/bonDeSortie.model';

@Injectable({
  providedIn: 'root',
})
export class ArticleBonSortieService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}

  // ----------------------------------------------------------------------------
  // // RECHERCHER ARTICLEBONENTREE SANS DOUBLONS
  // public searchArticleBonEntreeListFilterDouble(term: string, listeArticleBonEntrees: ArticleBonEntree[]): Observable<ArticleBonEntree[]> {

  //   if (term.length <= 1) {
  //     return of([]);
  //   }

  //   // Filtrer la liste de articlebonEntrees en fonction du terme de recherche
  //   const filteredArticleBonEntrees = listeArticleBonEntrees.filter((articleBonEntree) =>
  //   articleBonEntree.codeArticleBonEntree.toString().includes(term.toLowerCase()) || articleBonEntree.libelleArticleBonEntree.toLowerCase().includes(term.toLowerCase())
  //   );

  //   // Utilisation de la méthode filter() pour éliminer les doublons
  //   const filteredArticleBonEntrees1: ArticleBonEntree[] = filteredArticleBonEntrees.filter((item, index, self) =>
  //     index === self.findIndex((t) => (
  //         t.libelleArticleBonEntree === item.libelleArticleBonEntree || t.codeArticleBonEntree === item.codeArticleBonEntree
  //     ))
  //   );

  //   return of(filteredArticleBonEntrees1);
  // }

  // // RECHERCHER ARTICLEBONENTREE
  // public searchArticleBonEntreeList(term: string, listeArticleBonEntrees: ArticleBonEntree[]): Observable<ArticleBonEntree[]> {
  //   if (term.length <= 1) {
  //     return of([]);
  //   }

  //   // Filtrer la liste de BonEntree en fonction du terme de recherche
  //   const filteredArticleBonEntrees = listeArticleBonEntrees.filter((articleBonEntree) =>
  //     this.doesBonEntreeMatchTerm(articleBonEntree, term)
  //   );

  //   return of(filteredArticleBonEntrees);
  // }

  // private doesBonEntreeMatchTerm(articleBonEntree: ArticleBonEntree, term: string): boolean {
  //   // Vérifier si le terme de recherche correspond à n'importe lequel des attributs du bonEntree
  //   const termLowerCase = term.toLowerCase();
  //   return (
  //     articleBonEntree.codeArticleBonEntree.toString().includes(termLowerCase) || articleBonEntree.libelleArticleBonEntree.toLowerCase().includes(termLowerCase)
  //     // Ajoutez d'autres attributs à vérifier si nécessaire
  //   );
  // }
  // ----------------------------------------------------------------------------


  // ----------------------------------------------------------------------------
  //  CRUD ARTICLEBONSORTIE

  public listeArticleBonSorties(): Observable<ArticleBonSortie[]> {
    return this.httpClient.get<ArticleBonSortie[]>(`${this.urlServeur}/ArticleBonSorties`);
  }

  public ajouterArticleBonSortie(articleBonSortie: ArticleBonSortie): Observable<string> {
    return this.httpClient.post<string>(`${this.urlServeur}/AjouterArticleBonSortie`, articleBonSortie);
  }

  // public ajouterArticleBonSortieRequestParam(formData: FormData): Observable<ArticleBonSortie> {
  //   return this.httpClient.post<ArticleBonSortie>(`${this.urlServeur}/AjouterRequestParamArticleBonSortie`, formData);
  // }

  public modifierArticleBonSortie(articleBonSortie: ArticleBonSortie): Observable<ArticleBonSortie> {
    return this.httpClient.put<ArticleBonSortie>(`${this.urlServeur}/ModifierArticleBonSortie`, articleBonSortie);
  }

  public supprimerArticleBonSortie(codeArticleBonSortie: string, identifiantBS: BonDeSortie): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerArticleBonSortieById/${codeArticleBonSortie}/${identifiantBS}`);
  }


//   public createArticleBonEntreeFormData(articleBonEntree: ArticleBonEntree): FormData {

//     const formData = new FormData();

//     formData.append('identifiantBE', articleBonEntree.identifiantBE.identifiantBE);
//     formData.append('codeArticleBonEntree', articleBonEntree.codeArticleBonEntree);
//     formData.append('libelleArticleBonEntree', articleBonEntree.libelleArticleBonEntree);
//     formData.append('quantiteEntree', articleBonEntree.quantiteEntree.toString());
//     formData.append('codeTypeObjet', articleBonEntree.codeTypeObjet.codeTypeObjet);
//     formData.append('matriculeAgent', articleBonEntree.matriculeAgent.matriculeAgent);

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
