import { HttpClient, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { MyDate } from '../model/my-date.model';
import { DatePipe } from '@angular/common';
import { BonPour } from '../model/bon-pour.model';
import { ArticleBonPour } from '../model/article-bon-pour.model';

@Injectable({
  providedIn: 'root',
})
export class ArticleBonPourService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}

  // ----------------------------------------------------------------------------
  // RECHERCHER BONENTREE SANS DOUBLONS
  public searchArticleBonPourListFilterDouble(term: string, listeArticleBonPours: ArticleBonPour[]): Observable<ArticleBonPour[]> {

    if (term.length <= 1) {
      return of([]);
    }

    // Filtrer la liste de articleBonPours en fonction du terme de recherche
    const filteredArticleBonPours: ArticleBonPour[] = listeArticleBonPours.filter((articleBonPour) =>
      articleBonPour.identifiantBP.numeroCourrielOrigine.toString().includes(term.toLowerCase()) || articleBonPour.identifiantBP.etatBP.toLowerCase().includes(term.toLowerCase())
    );

    // Utilisation de la méthode filter() pour éliminer les doublons
    const filteredArticleBonPours1: ArticleBonPour[] = filteredArticleBonPours.filter((item, index, self) =>
      index === self.findIndex((t) => (
          t.identifiantBP.etatBP === item.identifiantBP.etatBP || t.identifiantBP.numeroCourrielOrigine === item.identifiantBP.numeroCourrielOrigine
      ))
    );

    return of(filteredArticleBonPours1);
  }

  // RECHERCHER ArticleBonPour
  public searchArticleBonPourList(term: string, listeArticleBonPours: ArticleBonPour[]): Observable<ArticleBonPour[]> {
    if (term.length <= 1) {
      return of([]);
    }

    // Filtrer la liste de ArticleBonPour en fonction du terme de recherche
    const filteredArticleBonPours = listeArticleBonPours.filter((articleBonPour) =>
      this.doesArticleBonPourMatchTerm(articleBonPour, term)
    );

    return of(filteredArticleBonPours);
  }

  private doesArticleBonPourMatchTerm(articleBonPour: ArticleBonPour, term: string): boolean {
    // Vérifier si le terme de recherche correspond à n'importe lequel des attributs du articleBonPour
    const termLowerCase = term.toLowerCase();
    return (
      articleBonPour.identifiantBP.numeroCourrielOrigine.toString().includes(termLowerCase) || articleBonPour.identifiantBP.etatBP.toLowerCase().includes(termLowerCase)
      // Ajoutez d'autres attributs à vérifier si nécessaire
    );
  }
  // ----------------------------------------------------------------------------


  // ----------------------------------------------------------------------------
  //  CRUD BONENTREE

  public listeArticleBonPours(): Observable<ArticleBonPour[]> {
    return this.httpClient.get<ArticleBonPour[]>(`${this.urlServeur}/ArticleBonPours`);
  }

  public ajouterArticleBonPour(articleBonPour: ArticleBonPour): Observable<ArticleBonPour> {
    return this.httpClient.post<ArticleBonPour>(`${this.urlServeur}/AjouterArticleBonPour`, articleBonPour);
  }

  // public ajouterBonEntreeRequestParam(formData: FormData): Observable<BonPour> {
  //   return this.httpClient.post<BonPour>(`${this.urlServeur}/AjouterRequestParamBonEntree`, formData);
  // }

  public modifierArticleBonPour(articleBonPour: ArticleBonPour): Observable<ArticleBonPour> {
    return this.httpClient.put<ArticleBonPour>(`${this.urlServeur}/ModifierArticleBonPour`, articleBonPour);
  }

  public supprimerArticleBonPourById(numeroBonPour: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerArticleBonPourById/${numeroBonPour}`);
  }

  public recupererArticleBonPourById(identifiantBP: string, codeArticleBonPour: string): Observable<ArticleBonPour> {
    return this.httpClient.get<ArticleBonPour>(`${this.urlServeur}/RecupererArticleBonPourById/${identifiantBP}/${codeArticleBonPour}`);
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
