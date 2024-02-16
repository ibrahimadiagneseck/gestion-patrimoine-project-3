import { Component, ElementRef, HostListener, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { CommonModule, DatePipe, JsonPipe } from '@angular/common';
import { Vehicule } from 'src/app/model/vehicule.model';
import { VehiculeService } from 'src/app/services/vehicule.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Observable, Subject, Subscription, catchError, debounceTime, distinctUntilChanged, map, of, switchMap, tap, throwError } from 'rxjs';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import jsPDF from 'jspdf';
import autoTable from 'jspdf-autotable';
import { ReceptionVehiculeAjouterBonEntreeComponent } from '../../reception/reception-vehicule-ajouter-bon-entree/reception-vehicule-ajouter-bon-entree.component';
import { ConsultationVehiculeDetailComponent } from '../consultation-vehicule-detail/consultation-vehicule-detail.component';
import { LieuStockageVehicule } from 'src/app/model/lieu-stockage-vehicule.model';
import { LieuStockageVehiculeService } from 'src/app/services/lieu-stockage-vehicule.service';
import { MyDate } from 'src/app/model/my-date.model';
import { UniteDouaniere } from 'src/app/model/unite-douaniere.model';
import { UniteDouaniereService } from 'src/app/services/unite-douaniere.service';
import { DotationVehicule } from 'src/app/model/dotation-vehicule.model';
import { DotationVehiculeVehiculeService } from 'src/app/services/dotation-vehicule-vehicule.service';
import { DotationVehiculeVehicule } from 'src/app/model/dotation-vehicule-vehicule.model';

@Component({
  selector: 'app-consultation-vehicule-liste',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './consultation-vehicule-liste.component.html',
  styleUrl: './consultation-vehicule-liste.component.css'
})
export class ConsultationVehiculeListeComponent implements OnInit, OnDestroy {

  public vehicules: Vehicule[] = [];
  public vehicule: Vehicule | undefined;

  public uniteDouanieres: UniteDouaniere[] = [];
  public uniteDouaniere: UniteDouaniere | undefined;

  public dotationVehiculeVehicules: DotationVehiculeVehicule[] = [];
  public dotationVehiculeVehicule: DotationVehiculeVehicule | undefined;





  public lieuStockageVehicules: LieuStockageVehicule[] = [];
  public lieuStockageVehicule: LieuStockageVehicule | undefined;



  private subscriptions: Subscription[] = [];


  /* ----------------------------------------------------------------------------------------- */
  focusOnInput: boolean = false;

  @ViewChild('monDiv', { static: true }) monDiv: ElementRef | undefined;

  divClique(): void {
    // Code à exécuter lorsque l'élément <div> est cliqué
    // Par exemple, vous pouvez modifier une variable ou déclencher une action
    // console.log('L\'élément <div> a été cliqué !');
    this.focusOnInput = true;
  }

  @HostListener('document:click', ['$event'])
  onDocumentClick(event: Event): void {
    // Vérifie si le clic a eu lieu en dehors de l'élément monDiv
    if (!this.monDiv?.nativeElement.contains(event.target)) {
      // Code à exécuter lorsque le clic est en dehors de monDiv
      // console.log('Clic en dehors de monDiv détecté.');
      this.focusOnInput = false;
    }
  }
  /* ----------------------------------------------------------------------------------------- */


  /* ----------------------------------------------------------------------------------------- */
  @ViewChild('myInputSearch') myInputSearch!: ElementRef;
  // rechercher
  searchTerms = new Subject<string>();
  vehicules$: Observable<Vehicule[]> = of();
  // recherche custom
  searchTermsFilterDoubleNumeroSerieModele = new Subject<string>();
  termeRechercheNumeroSerieModele: string = "";
  vehiculeFilterDoubleNumeroSerieModele$: Observable<Vehicule[]> = of();
  /* ----------------------------------------------------------------------------------------- */


  /* ----------------------------------------------------------------------------------------- */
  // tableau
  rowNumber!: number; // numéro de ligne pour le tableau
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
    "numeroSerie",
    "numeroImmatriculation",
    "rowPays",
    "numeroCarteGrise",
    "dateMiseEnCirculation",
    "rowTypeVehicule",
    "rowUniteDouaniere"
  ];
  dataSource = new MatTableDataSource<Vehicule>();
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  displayedColumns: string[] = [
    "rowNumber",
    "rowLibelleArticleBonEntree",
    "rowLieuStockageVehicule",
    "numeroSerie",
    "numeroImmatriculation",
    "rowEtat",
    "rowTypeEnergie",
    "rowPays",
    "numeroCarteGrise",
    "dateMiseEnCirculation",
    "rowTypeVehicule",
    "rowUniteDouaniere",
     "rowNombreAgeVehicule"


  ];
  displayedColumnsCustom: string[] = [
    "N°",
    "Libelle article",
    "Lieu stockage vehicule",
    "N° serie",
    "N° immatriculation",
    "Etat vehicule",
    "Type energie",
    "Provenance",
    "N° carte grise",
    "Date mise en circulation",
    "Type vehicule",
    "Nom unite",
     "Age (années)"


  ];
  /* ----------------------------------------------------------------------------------------- */

  constructor(
    private vehiculeService: VehiculeService,
    private lieuStockageVehiculeService: LieuStockageVehiculeService,
    private uniteDouaniereService: UniteDouaniereService,
    private dotationVehiculeVehiculeService: DotationVehiculeVehiculeService,




    private matDialog: MatDialog,
  ) { }

  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

  ngOnInit(): void {
    this.listeVehicules();
    this.listeLieuStockageVehicules();
    this.listeUniteDouanieres();
    this.listeDotationVehiculeVehicule();


    /* ----------------------------------------------------------------------------------------- */
    // rechercher
    this.vehicules$ = this.searchTerms.pipe(
      // {...."ab"..."abz"."ab"...."abc"......}
      debounceTime(300),
      // {......"ab"...."ab"...."abc"......}
      distinctUntilChanged(),
      // {......"ab"..........."abc"......}
      switchMap((term) => this.vehiculeService.searchVehiculeList(term, this.vehicules))
      // {.....List(ab)............List(abc)......}
    );
    this.vehiculeFilterDoubleNumeroSerieModele$ = this.searchTermsFilterDoubleNumeroSerieModele.pipe(
      // {...."ab"..."abz"."ab"...."abc"......}
      debounceTime(300),
      // {......"ab"...."ab"...."abc"......}
      distinctUntilChanged(),
      // {......"ab"..........."abc"......}
      switchMap((term) => this.vehiculeService.searchVehiculeListFilterDouble(term, this.vehicules))
      // {.....List(ab)............List(abc)......}
    );
    /* ----------------------------------------------------------------------------------------- */
  }


  generatePDF(): void {

    const data: Vehicule[] = this.dataSource.filteredData;
    // const data: any[] = this.dataSource.filteredData;

    // console.log(data);


    // const months = ['JANV.', 'FÉVR.', 'MARS', 'AVR.', 'MAI', 'JUIN', 'JUIL.', 'AOÛT', 'SEPT.', 'OCT.', 'NOV.', 'DÉC.'];
    const months = ['JANVIER', 'FÉVRIER', 'MARS', 'AVRIL', 'MAI', 'JUIN', 'JUILLET', 'AOÛT', 'SEPTEMBRE', 'OCTOBRE', 'NOVEMBRE', 'DÉCEMBRE'];
    const doc = new jsPDF();

    // Créez un tableau de données pour autoTable
    const tableData = data.map((item: Vehicule) => [
    // const tableData = data.map((item: any) => [

      item.numeroSerie,
      item.numeroImmatriculation,
      item.modele || 'N/A',
      item.rowEtat,
      item.rowTypeEnergie,
      item.rowPays,
      item.numeroCarteGrise,
      item.dateMiseEnCirculation ? `${new Date(item.dateMiseEnCirculation.toString()).getDate()} ${months[new Date(item.dateMiseEnCirculation.toString()).getMonth()]} ${new Date(item.dateMiseEnCirculation.toString()).getFullYear()}` : 'N/A',
      // item.dateMiseEnCirculation ? `${new Date(item.dateMiseEnCirculation.toString()).getDate()} ${months[new Date(item.dateMiseEnCirculation.toString()).getMonth()]} ${new Date(item.dateMiseEnCirculation.toString()).getFullYear() % 100}` : 'N/A',
      // `${new Date(item.dateMiseEnCirculation).getDate()} ${months[new Date(item.dateMiseEnCirculation).getMonth()]} ${new Date(item.dateMiseEnCirculation).getFullYear() % 100}`,
      item.rowTypeVehicule,
      item.rowMarque
    ]);

    // Configuration pour le PDF avec une taille de page personnalisée

    const marginLeft = 10;
    const marginTop = 10;
    const marginRight = 10;
    const marginBottom = 10;

    // Générer le tableau dans le PDF avec des styles de texte personnalisés
    autoTable(doc, {
      head: [
        [
          { content: 'N° serie', styles: { fontSize: 6 } },
          { content: 'N° immatriculation', styles: { fontSize: 6 } },
          { content: 'Modele', styles: { fontSize: 6 } },
          { content: 'Etat vehicule', styles: { fontSize: 6 } },
          { content: 'Type energie', styles: { fontSize: 6 } },
          { content: 'Provenance', styles: { fontSize: 6 } },
          { content: 'N° carte grise', styles: { fontSize: 6 } },
          { content: 'Date mise en circulation', styles: { fontSize: 6 } },
          { content: 'Type vehicule', styles: { fontSize: 6 } },
          { content: 'Marque', styles: { fontSize: 6 } }
        ]
      ],
      body: tableData.map(row => row.map(cell => ({ content: cell.toString(), styles: { fontSize: 6 } }))),
      margin: { top: marginTop, right: marginRight, bottom: marginBottom, left: marginLeft },
      theme: 'plain'
    });

    doc.save('vehicule-liste.pdf');
  }


  search(term: string): void {
    this.termeRechercheNumeroSerieModele = term;
    this.searchTerms.next(term);
    this.searchTermsFilterDoubleNumeroSerieModele.next(term);
  }

  applyFilter(event: Event): void {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

  }


  FilterDoubleNumeroSerieModele(termeRechercheNumeroSerieModele: string) {
    this.termeRechercheNumeroSerieModele = termeRechercheNumeroSerieModele;
    this.myInputSearch.nativeElement.value = termeRechercheNumeroSerieModele;
    this.dataSource.filter = termeRechercheNumeroSerieModele.trim().toLowerCase(); // supprimer les espaces vide et mettre minuscule
    this.focusOnInput = false;
  }


  isNumber(termeRechercheNumeroSerieModele: string): boolean {
    return !isNaN(Number(termeRechercheNumeroSerieModele))
  }


  filtrerParLieuStockageVehicule(event: any) {
    const value: string = event.target.value;
    if (value) {
      this.dataSource.filter = value.trim().toLowerCase();
    } else {
      this.dataSource.filter = '';
    }
  }

  filtrerParUniteDouaniere(event: any) {
    const value: string = event.target.value;
    if (value) {
      this.dataSource.filter = value.trim().toLowerCase();
    } else {
      this.dataSource.filter = '';
    }
  }

  filtrerParAgeVehicule(event: any) {
    const value: string = event.target.value;
    if (value) {
      this.dataSource.filter = value.trim().toLowerCase();
    } else {
      this.dataSource.filter = '';
    }
  }







  public listeVehicules(): void {

    const subscription = this.vehiculeService.listeVehicules().subscribe({
      next: (response: Vehicule[]) => {

        // console.log(response);


        // this.vehicules = response.sort((a, b) => parseInt(a.numeroImmatriculation) - parseInt(b.numeroImmatriculation));
        this.vehicules = response.sort((a, b) => Number(a.numeroImmatriculation) - Number(b.numeroImmatriculation));
        // this.vehicules = response.sort((a, b) => a.numeroImmatriculation.localeCompare(b.numeroImmatriculation));
        // this.vehicules = response.sort((a, b) => a.numeroChassis - b.numeroChassis);
        // this.vehicules = response.sort((a, b) => new Date(b.dateModification).getTime() - new Date(a.dateModification).getTime());

        this.rowNumber = 1;

        // this.dataSource = new MatTableDataSource<IVehicule>(this.vehicules);
        this.dataSource = new MatTableDataSource<Vehicule>(this.vehicules.map((item) => ({
          ...item,




          // vehicule: [] as Vehicule[],
          rowMarque: item.codeMarque.libelleMarque,
          rowPays: item.codePays.libellePays,
          rowEtat: item.codeEtat.libelleEtat,
          rowTypeEnergie: item.codeTypeEnergie.libelleTypeEnergie,
          rowTypeVehicule: item.codeTypeVehicule.libelleTypeVehicule,
          rowLibelleArticleBonEntree: item.identifiantBE.libelleArticleBonEntree,
          rowLieuStockageVehicule: item.identifiantBE.codeLieuVH.libellleLieuVH,
          rowUniteDouaniere: this.libelleUniteDouaniere(item, this.dotationVehiculeVehicules),
          rowNombreAgeVehicule: this.calculerAgeVehicule(new Date(item.dateMiseEnCirculation.toString())),
          rowNumber: this.rowNumber++,
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

  public listeLieuStockageVehicules(): void {

    const subscription = this.lieuStockageVehiculeService.listeLieuStockageVehicules().subscribe({
      next: (response: LieuStockageVehicule[]) => {
        this.lieuStockageVehicules = response;
        // console.log(this.secteurActivites);

      },
      error: (errorResponse: HttpErrorResponse) => {
        // console.log(errorResponse);
      },
    });

    this.subscriptions.push(subscription);
  }


  public listeUniteDouanieres(): void {

    const subscription = this.uniteDouaniereService.listeUniteDouanieres().subscribe({
      next: (response: UniteDouaniere[]) => {
        this.uniteDouanieres = response;
        // console.log(this.secteurActivites);

      },
      error: (errorResponse: HttpErrorResponse) => {
        // console.log(errorResponse);
      },
    });

    this.subscriptions.push(subscription);
  }

  public listeDotationVehiculeVehicule(): void {

    const subscription = this.dotationVehiculeVehiculeService.listeDotationVehiculeVehicule().subscribe({
      next: (response: DotationVehiculeVehicule[]) => {
        this.dotationVehiculeVehicules = response;
        // this.listeVehicules();

      },
      error: (errorResponse: HttpErrorResponse) => {
        // console.log(errorResponse);
      },
    });

    this.subscriptions.push(subscription);
  }











  popupDetail(vehicule: Vehicule): void {
    const dialogRef = this.matDialog.open(
      ConsultationVehiculeDetailComponent,
      {
        width: '80%',
        enterAnimationDuration: '100ms',
        exitAnimationDuration: '100ms',
        data: vehicule
      }
    );

    dialogRef.afterClosed().subscribe(() => {
      this.ngOnInit();
    });
  }


  compare(value1: String, value2: String): boolean {
    return value1 === value1;
  }




  calculerAgeVehicule(dateMiseEnCirculation: Date ): number {

    if (!dateMiseEnCirculation) {
      return 0; // Gérer le cas où la conversion échoue
  }


    // if (!dateMiseEnCirculation || !dateMiseEnCirculation.year || !dateMiseEnCirculation.month || !dateMiseEnCirculation.day) {
    //   return 0;
    // }






    console.log(dateMiseEnCirculation);

    // const dateMiseEnCirculationAsDate = this.convertMyDateToDate(dateMiseEnCirculation); // Convertir MyDate en Date


    const diffEnMs = Math.abs(dateMiseEnCirculation.getTime() - new Date().getTime());
    const annees = Math.floor(diffEnMs / (1000 * 60 * 60 * 24 * 365)); // Nombre d'années écoulées
    const moisRestants = Math.floor((diffEnMs % (1000 * 60 * 60 * 24 * 365)) / (1000 * 60 * 60 * 24 * 30.44)); // Mois restants après le calcul des années
    return annees;
}







// public recupererDotation( vehicule: Vehicule): any {




//   let unite: any = this.dotationVehiculeVehiculeService.recupererDotationByVehiculeId(vehicule.numeroSerie).pipe(
//     tap((response: DotationVehiculeVehicule) => {
//         this.dotationVehiculeVehicule = response;
//         console.log(this.dotationVehiculeVehicule);
//     }),
//     catchError((errorResponse: HttpErrorResponse) => {
//         // Gérer l'erreur ici
//         // console.log(errorResponse);
//         return throwError(errorResponse); // Si vous voulez relancer l'erreur
//     })

// );

// console.log(unite );


// return unite?.identifiantDV?.identifiantBS?.identifiantBS?.identifiantBP?.codeUniteDouaniere?.nomUniteDouaniere;



// }


// public recupererDotation(vehicule: Vehicule): any {
//   return this.dotationVehiculeVehiculeService.recupererDotationByVehiculeId(vehicule.numeroSerie).pipe(
//     tap((response: DotationVehiculeVehicule) => {
//       this.dotationVehiculeVehicule = response;
//       console.log(this.dotationVehiculeVehicule);
//     }),
//     map((unite: any) => {
//       console.log(unite);
//       return unite?.identifiantDV?.identifiantBS?.identifiantBS?.identifiantBP?.codeUniteDouaniere?.nomUniteDouaniere;
//     }),
//     catchError((errorResponse: HttpErrorResponse) => {
//       // Gérer l'erreur ici
//       // console.log(errorResponse);
//       return throwError(errorResponse); // Si vous voulez relancer l'erreur
//     })
//   );
// }


libelleUniteDouaniere( vehicule: Vehicule, dotationVehiculeVehicules: DotationVehiculeVehicule[]): string {
  // let nombreArticleBonEntree = 0;

  for (let dotationVehiculeVehicule of dotationVehiculeVehicules) {

    console.log(dotationVehiculeVehicule.identifiantDV.identifiantBS.identifiantBS.identifiantBP.codeUniteDouaniere.nomUniteDouaniere);
    console.log(vehicule);




          if ( vehicule.numeroSerie ===  dotationVehiculeVehicule.numeroSerie.numeroSerie ) {

            // console.log(dotationVehiculeVehicule);


             return dotationVehiculeVehicule.identifiantDV.identifiantBS.identifiantBS.identifiantBP.codeUniteDouaniere.nomUniteDouaniere;



      }

  }

  return " ";
}







}
