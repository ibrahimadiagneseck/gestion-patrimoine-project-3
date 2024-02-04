import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BonDeSortie } from 'src/app/model/bonDeSortie.model';
import { UniteDouaniere } from 'src/app/model/unite-douaniere.model';
import { TypeUniteDouaniere } from 'src/app/model/type-unite-douaniere.model';
import { Subscription } from 'rxjs';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatDialog } from '@angular/material/dialog';
import { BonDeSortieService } from 'src/app/services/bon-de-sortie.service';
import { ActivatedRoute, Router } from '@angular/router';
import { TypeUniteDouaniereService } from 'src/app/services/type-unite-douaniere.service';
import { UniteDouaniereService } from 'src/app/services/unite-douaniere.service';
import { SecuriteService } from 'src/app/services/securite.service';
import { MyDateService } from 'src/app/services/my-date.service';
import { HttpErrorResponse } from '@angular/common/http';
import { MyDate } from 'src/app/model/my-date.model';
import { ArticleBonPourService } from 'src/app/services/article-bon-pour.service';
import { ArticleBonPour } from 'src/app/model/article-bon-pour.model';
import { ArticleBonSortie } from 'src/app/model/article-bon-sortie.model';
import { BonPour } from 'src/app/model/bon-pour.model';

@Component({
  selector: 'app-dotation-vehicule-detail',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './dotation-vehicule-detail.component.html',
  styleUrl: './dotation-vehicule-detail.component.css'
})
export class DotationVehiculeDetailComponent implements OnInit, OnDestroy {

  public bonDeSorties: BonDeSortie[] = [];
  public bonDeSortie: BonDeSortie | undefined = new BonDeSortie();

  public articleBonPours: ArticleBonPour[] = [];
  public articleBonPour: ArticleBonPour = new ArticleBonPour();

  public uniteDouanieres: UniteDouaniere[] = [];
  public uniteDouaniere: UniteDouaniere | undefined;

  public typeUniteDouanieres: TypeUniteDouaniere[] = [];
  public typeUniteDouaniere: TypeUniteDouaniere | undefined;

  private subscriptions: Subscription[] = [];


  /* ----------------------------------------------------------------------------------------- */
  // tableau
  // columnsToCodeMarque: string[] = [
  //   "codeMarque"
  // ];
  // columnsToCodePays: string[] = [
  //   "codePays"
  // ];
  columnsDateFormat: string[] = [
    "dateBS"
  ];
  columnsToHide: string[] = [
  ];
  dataSource = new MatTableDataSource<BonDeSortie>();
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  displayedColumns: string[] = [
    "numeroBS",
    "descriptionBS",
    "dateBS",
    "observationBS"

  ];
  displayedColumnsCustom: string[] = [
    "N° bon sortie",
    "Description bon sortie",
    "Date bon sortie",
    "Observation bon sortie"

  ];
  /* ----------------------------------------------------------------------------------------- */


  constructor(
    private articleBonPourService: ArticleBonPourService,
    private bonDeSortieService: BonDeSortieService,
    private matDialog: MatDialog,
    private route: ActivatedRoute,
    private router: Router,
    private typeUniteDouaniereService: TypeUniteDouaniereService,
    private uniteDouaniereService: UniteDouaniereService,
    private securiteService: SecuriteService,
    private myDateService: MyDateService
  ) { }


  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }


  ngOnInit(): void {

    // this.listeArticles();
    // this.listeBonDeSorties();
    // --------------------------------------------------------------------------------
    const identifiantBP = this.route.snapshot.paramMap.get('identifiantBP') ?? '';
    const codeArticleBonPour = this.route.snapshot.paramMap.get('codeArticleBonPour') ?? '';
    // console.log(id);

    const decrypt1 = this.securiteService.decryptUsingAES256(identifiantBP);
    const decrypt2 = this.securiteService.decryptUsingAES256(codeArticleBonPour);

    // console.log(decrypt1, decrypt2);



    if (decrypt1 && decrypt2) {
      // this.utilisateurService.getUtilisateurByUtilisateurId(+utilisateurId).subscribe(pokemon => this.pokemon = pokemon);
      this.subscriptions.push(this.articleBonPourService.recupererArticleBonPourById(decrypt1, decrypt2).subscribe({
        next: (response: ArticleBonPour) => {
          this.articleBonPour = response;
          console.log(this.articleBonPour);

          this.listeBonDeSorties();
        },
        error: (errorResponse: HttpErrorResponse) => {

        }
      }));
    }
    // --------------------------------------------------------------------------------
  }


  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------
  public listeBonDeSorties(): void {

    const subscription = this.bonDeSortieService.listeBonDeSorties().subscribe({
      next: (response: BonDeSortie[]) => {
        this.bonDeSorties = response;
        this.bonDeSortie = this.filtreBonPourArticleBonSortie(this.articleBonPour.identifiantBP, this.bonDeSorties);
        console.log(this.bonDeSortie);
        console.log(this.articleBonPour.identifiantBP);
        
        
      },
      error: (errorResponse: HttpErrorResponse) => {
        // console.log(errorResponse);
      },
    });

    this.subscriptions.push(subscription);
  }


  filtreBonPourArticleBonSortie(bonPour: BonPour, bonDeSorties: BonDeSortie[]): BonDeSortie {
    return bonDeSorties.find(bonDeSortie =>
        Array.isArray(bonDeSortie.identifiantBP) && bonDeSortie.identifiantBP.some(bp => bp === bonPour)
    ) ?? new BonDeSortie();
  }



  myDateStringFormatter(date: MyDate | string | undefined): string {
    if (!date) {
      return '';
    }

    if (typeof date === 'string') {
      return this.myDateService.formatterMyDateFromString(date);
    } else {
      return this.myDateService.formatterMyDate(date);
    }
  }

  // popupAjouterBonSortie(): void {
  //   const dialogRef = this.matDialog.open(
  //     DotationVehiculeAjouterBonSortieComponent,
  //     {
  //       width: '80%',
  //       enterAnimationDuration: '100ms',
  //       exitAnimationDuration: '100ms'
  //     }
  //   );

  //   dialogRef.afterClosed().subscribe(() => {
  //     this.ngOnInit();
  //   });
  // }



  goToDetail(bonDeSortie: BonDeSortie): void {
    const id = bonDeSortie.identifiantBS;
    console.log(id);

    const encrypt = this.securiteService.encryptUsingAES256(id);
    this.router.navigate(['/dotation-vehicule-detail-bon-sortie-detail', encrypt]);
  }

}
