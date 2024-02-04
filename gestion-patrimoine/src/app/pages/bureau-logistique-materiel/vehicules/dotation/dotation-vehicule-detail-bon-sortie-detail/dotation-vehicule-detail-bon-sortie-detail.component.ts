import { Component, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Vehicule } from 'src/app/model/vehicule.model';
import { BonDeSortie } from 'src/app/model/bonDeSortie.model';
import { UniteDouaniere } from 'src/app/model/unite-douaniere.model';
import { Subscription } from 'rxjs';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { BonDeSortieService } from 'src/app/services/bon-de-sortie.service';
import { VehiculeService } from 'src/app/services/vehicule.service';
import { UniteDouaniereService } from 'src/app/services/unite-douaniere.service';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { SecuriteService } from 'src/app/services/securite.service';
import { MyDateService } from 'src/app/services/my-date.service';
import { HttpErrorResponse } from '@angular/common/http';
import { MyDate } from 'src/app/model/my-date.model';

@Component({
  selector: 'app-dotation-vehicule-detail-bon-sortie-detail',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './dotation-vehicule-detail-bon-sortie-detail.component.html',
  styleUrl: './dotation-vehicule-detail-bon-sortie-detail.component.css'
})
export class DotationVehiculeDetailBonSortieDetailComponent {

  public vehicules: Vehicule[] = [];
  public vehicule: Vehicule = new Vehicule();


  public bonDeSorties: BonDeSortie[] = [];
  public bonDeSortie: BonDeSortie | undefined;

  public uniteDouanieres: UniteDouaniere[] = [];
  public uniteDouaniere: UniteDouaniere | undefined;


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
    "dateMiseEnCirculation"
  ];
  columnsToHide: string[] = [
    "numeroImmatriculation",
    "typeEnergie",
    "numeroCarteGrise",
    "rowTypeVehicule",
    "codeUniteDouaniere"
  ];
  dataSource = new MatTableDataSource<Vehicule>();
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  displayedColumns: string[] = [
    "numeroSerie",
    "numeroImmatriculation",
    "rowEtat",
    "rowTypeEnergie",
    "rowPays",
    "numeroCarteGrise",
    "dateMiseEnCirculation",
    "rowTypeVehicule",
    "rowMarque"
  ];
  displayedColumnsCustom: string[] = [
    "N° serie",
    "N° immatriculation",
    "Etat vehicule",
    "Type energie",
    "Provenance",
    "N° carte grise",
    "Date mise en circulation",
    "Type vehicule",
    "Marque"
  ];
  /* ----------------------------------------------------------------------------------------- */


  constructor(
    private bonDeSortieService: BonDeSortieService,
    private vehiculeService: VehiculeService,
    private uniteDouaniereService: UniteDouaniereService,

    private matDialog: MatDialog,
    private route: ActivatedRoute,
    private router: Router,
    private securiteService: SecuriteService,
    private myDateService: MyDateService
  ) { }


  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }


  ngOnInit(): void {

    // this.listeArticles();
    // this.listeBonDeSortie();
    // --------------------------------------------------------------------------------
    const id = this.route.snapshot.paramMap.get('idIdentifiantBS') ?? '';
      // console.log(id);



     const decrypt = this.securiteService.decryptUsingAES256(id);



    // console.log(id);
     console.log(decrypt);



    if (decrypt) {
      // this.utilisateurService.getUtilisateurByUtilisateurId(+utilisateurId).subscribe(pokemon => this.pokemon = pokemon);
      this.subscriptions.push(this.bonDeSortieService.recupererBonDeSortieById(decrypt).subscribe({
        next: (response: BonDeSortie) => {
          this.bonDeSortie = response;
          console.log(this.bonDeSortie);
          // this.listeVehicules();
        },
        error: (errorResponse: HttpErrorResponse) => {

        }
      }));
    }
    // --------------------------------------------------------------------------------
  }


  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------
  public listeBonDeSortie(): void {

    const subscription = this.bonDeSortieService.listeBonDeSorties().subscribe({
      next: (response: BonDeSortie[]) => {
        this.bonDeSorties = response;
        this.listeUniteDouaniere();
        // console.log(this.prestataires);
      },
      error: (errorResponse: HttpErrorResponse) => {
        // console.log(errorResponse);
      },
    });

    this.subscriptions.push(subscription);
  }

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


  goToRetour(bonDeSortie: BonDeSortie | undefined): void {

    if(bonDeSortie){

      const id = bonDeSortie.codeUniteDouaniere.codeUniteDouaniere;

      console.log(id);


      const encrypt = this.securiteService.encryptUsingAES256(id);
     this.router.navigate(['/dotation-vehicule-detail', encrypt]);

    }

  }




}
