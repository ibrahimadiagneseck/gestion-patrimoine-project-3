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

@Component({
  selector: 'app-dotation-vehicule-detail',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './dotation-vehicule-detail.component.html',
  styleUrl: './dotation-vehicule-detail.component.css'
})
export class DotationVehiculeDetailComponent implements OnInit, OnDestroy{

  public bonDeSorties: BonDeSortie[] = [];
  public bonDeSortie: BonDeSortie = new BonDeSortie();

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
    this.listeBonDeSorties();
    // --------------------------------------------------------------------------------
    const id = this.route.snapshot.paramMap.get('codeUniteDouaniere') ?? '';
      // console.log(id);

     const decrypt = this.securiteService.decryptUsingAES256(id);



    // console.log(id);
    //  console.log(decrypt);



    if (decrypt) {
      // this.utilisateurService.getUtilisateurByUtilisateurId(+utilisateurId).subscribe(pokemon => this.pokemon = pokemon);
      this.subscriptions.push(this.uniteDouaniereService.recupererUniteDouaniereById(decrypt).subscribe({
        next: (response: UniteDouaniere) => {
          this.uniteDouaniere = response;
          console.log(this.uniteDouaniere);
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


  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------


  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------
  public listeUniteDouaniere(): void {

    const subscription = this.uniteDouaniereService.listeUniteDouanieres().subscribe({
      next: (response: UniteDouaniere[]) => {
        this.uniteDouanieres = response;
        // this.listeVehicules();

      },
      error: (errorResponse: HttpErrorResponse) => {
        // console.log(errorResponse);
      },
    });

    this.subscriptions.push(subscription);
  }


  // public listeBonDeSorties(): void {

  //     const subscription = this.bonDeSortieService.listeBonDeSorties().subscribe({
  //       next: (response: BonDeSortie[]) => {

  //         this.dataSource = new MatTableDataSource<BonDeSortie>(this.bonDeSorties.map((item) => ({
  //           ...item,
  //           // vehicule: [] as Vehicule[],

  //         })));

  //         this.dataSource.paginator = this.paginator;




  //       },
  //       error: (errorResponse: HttpErrorResponse) => {
  //         // console.log(errorResponse);
  //       },
  //     });

  //     this.subscriptions.push(subscription);
  //   }


    public listeBonDeSorties(): void {

      const subscription = this.bonDeSortieService.listeBonDeSorties().subscribe({
        next: (response: BonDeSortie[]) => {
          this.bonDeSorties = response;

          this.dataSource = new MatTableDataSource<BonDeSortie>(this.bonDeSorties.map((item) => ({
            ...item,
            // rowTypeUniteDouaniere: item.codeTypeUniteDouaniere.libelleTypeUniteDouaniere

          })));

          // console.log(this.dataSource.data);
          this.dataSource.paginator = this.paginator;
        },
        error: (errorResponse: HttpErrorResponse) => {
          // console.log(errorResponse);
        },
      });

      this.subscriptions.push(subscription);
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
    this.router.navigate(['/dotation-vehicule-bon-sortie-detail', encrypt]);
  }

}
