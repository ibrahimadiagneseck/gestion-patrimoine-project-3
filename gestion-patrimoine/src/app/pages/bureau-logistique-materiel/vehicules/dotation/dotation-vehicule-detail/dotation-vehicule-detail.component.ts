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
import { NgForm } from '@angular/forms';
import { Agent } from 'src/app/model/agent.model';
import { AgentService } from 'src/app/services/agent.service';
import { DotationVehicule } from 'src/app/model/dotation-vehicule.model';
import { DotationVehiculeService } from 'src/app/services/dotation-vehicule.service';

@Component({
  selector: 'app-dotation-vehicule-detail',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './dotation-vehicule-detail.component.html',
  styleUrl: './dotation-vehicule-detail.component.css'
})
export class DotationVehiculeDetailComponent implements OnInit, OnDestroy {



  public bonDeSorties: BonDeSortie[] = [];
  public bonDeSortie: BonDeSortie | undefined  | null= new BonDeSortie();

  public articleBonPours: ArticleBonPour[] = [];
  public articleBonPour: ArticleBonPour = new ArticleBonPour();

  public dotationVehicules: DotationVehicule[] = [];
  public dotationVehicule: DotationVehicule = new DotationVehicule();

  public bonPours: BonPour[] = [];
  public bonPour: BonPour = new BonPour();

  public uniteDouanieres: UniteDouaniere[] = [];
  public uniteDouaniere: UniteDouaniere | undefined;

  public typeUniteDouanieres: TypeUniteDouaniere[] = [];
  public typeUniteDouaniere: TypeUniteDouaniere | undefined;

  public agents: Agent[] = [];
  public agent: Agent = new Agent();

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
    "dateDotation"
  ];
  columnsToHide: string[] = [
  ];
  dataSource = new MatTableDataSource<DotationVehicule>();
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  displayedColumns: string[] = [
    "dateDotation",
    "rowQuantiteAccordee",
    "rowQuantiteDemandee"


  ];
  displayedColumnsCustom: string[] = [
    "Date dotation",
    "Quantité accordée",
    "Quantité Demandée"


  ];
  /* ----------------------------------------------------------------------------------------- */


  constructor(
    private articleBonPourService: ArticleBonPourService,
    private bonDeSortieService: BonDeSortieService,
    private dotationVehiculeService: DotationVehiculeService,

    private agentService: AgentService,
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
     this.listeAgents();
     this.listeDotations();
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
        // this.bonDeSortie = this.filtreBonPourArticleBonSortie(this.articleBonPour.identifiantBP, this.bonDeSorties);
        this.bonDeSortie = this.AfficherFormBonSortie(this.articleBonPour.identifiantBP, this.bonDeSorties);
        console.log(this.bonDeSortie);
        console.log(this.articleBonPour.identifiantBP);


      },
      error: (errorResponse: HttpErrorResponse) => {
        // console.log(errorResponse);
      },
    });

    this.subscriptions.push(subscription);
  }


  public listeAgents(): void {

    const subscription = this.agentService.listeAgents().subscribe({
      next: (response: Agent[]) => {
        this.agents = response;
        // console.log(this.agents);

      },
      error: (errorResponse: HttpErrorResponse) => {
        // console.log(errorResponse);
      },
    });

    this.subscriptions.push(subscription);
  }

  AfficherFormBonSortie(bonPour: BonPour, bonDeSorties: BonDeSortie[]): BonDeSortie | null{


    for (const bonDeSortie of bonDeSorties) {
      // Comparer les bonEntree ici (assurez-vous d'implémenter une méthode de comparaison dans la classe BonEntree)
      if (bonPour && bonDeSortie.identifiantBP && JSON.stringify(bonPour) === JSON.stringify(bonDeSortie.identifiantBP)) {

       return bonDeSortie;
      }

    }


    return null;
  }


  // filtreBonPourArticleBonSortie(bonPour: BonPour, bonDeSorties: BonDeSortie[]): BonDeSortie {
  //   return bonDeSorties.find(bonDeSortie =>
  //       Array.isArray(bonDeSortie.identifiantBP) && bonDeSortie.identifiantBP.some(bp => bp === bonPour)
  //   ) ?? new BonDeSortie();
  // }



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

  private clickButton(buttonId: string): void {
    document.getElementById(buttonId)?.click();
  }

  // pour envoyer tous les formulaires
  public submitForm(): void {


    this.submitBonSortieForm();
    // this.submitBonEntreeForm();

    // this.popupFermer();
    // this.router.navigate(['/ajouter-article']);
  }

  // pour executer ajouterBordereauLivraison
  public submitBonSortieForm(): void {
    this.clickButton('bon-sortie-form')
  }


  public ajouterBonSortie(BonSortieForm: NgForm): void {

    // -------------------------------------------------------------------------- METHODE 1
    // const formData = this.bordereauLivraisonService.createBordereauLivraisonFormData(BordereauLivraisonForm.value);

    // this.subscriptions.push(this.bordereauLivraisonService.ajouterBordereauLivraisonRequestParam(formData).subscribe({
    //     next: (response: BordereauLivraison) => {
    //       console.log(response);

    //     },
    //     error: (errorResponse: HttpErrorResponse) => {

    //     }
    //   })
    // );

    // -------------------------------------------------------------------------- METHODE 2
    // const dateBS: MyDate = BordereauLivraisonForm.value.dateBS;
    // const formattedDate = this.bordereauLivraisonService.formatterMyDate(dateBL);

    // const bordereauLivraisonForm1: NgForm = BordereauLivraisonForm;
    // BordereauLivraisonForm.control.get('dateBL')?.patchValue(formattedDate);
    // BordereauLivraisonForm.control.get('dateBL')?.setValue(formattedDate);


    // if (formattedDate) {
    //   BordereauLivraisonForm.value.dateBL = formattedDate;
    // }




    //  AGENT
    BonSortieForm.value.numeroBS = 'BS005';
    BonSortieForm.value.matriculeAgent = this.agents[0];
    BonSortieForm.value.identifiantBP = this.articleBonPour.identifiantBP;

    // CONFORMITE BORDEREAU LIVRAISON
    // BordereauLivraisonForm.value.conformiteBL = 'oui';

     console.log(BonSortieForm.value);


    this.subscriptions.push(this.bonDeSortieService.ajouterBonDeSortie(BonSortieForm.value).subscribe({
        next: (response: BonDeSortie) => {
          this.bonDeSortie = response;
          console.log(this.bonDeSortie);

        },
        error: (errorResponse: HttpErrorResponse) => {

        }
      })
    );

  }


  public listeDotations(): void {

    const subscription = this.dotationVehiculeService.listeDotationVehicules().subscribe({
      next: (response: DotationVehicule[]) => {

        this.dotationVehicules = response;

        // console.log(response);


        // this.vehicules = response.sort((a, b) => parseInt(a.numeroImmatriculation) - parseInt(b.numeroImmatriculation));
        // this.vehicules = response.sort((a, b) => Number(a.numeroImmatriculation) - Number(b.numeroImmatriculation));
        // this.vehicules = response.sort((a, b) => a.numeroImmatriculation.localeCompare(b.numeroImmatriculation));
        // this.vehicules = response.sort((a, b) => a.numeroChassis - b.numeroChassis);
        // this.vehicules = response.sort((a, b) => new Date(b.dateModification).getTime() - new Date(a.dateModification).getTime());

        // this.rowNumber = 1;

        // this.dataSource = new MatTableDataSource<IVehicule>(this.vehicules);
        this.dataSource = new MatTableDataSource<DotationVehicule>(this.dotationVehicules.map((item) => ({
          ...item,

          rowQuantiteAccordee: item.identifiantBS.quantiteAccordee,
          // rowQuantiteDemandee: item.identifiantBS.identifiantBS.


          // vehicule: [] as Vehicule[],
          // rowMarque: item.codeMarque.libelleMarque,
          // rowPays: item.codePays.libellePays,
          // rowEtat: item.codeEtat.libelleEtat,
          // rowTypeEnergie: item.codeTypeEnergie.libelleTypeEnergie,
          // rowTypeVehicule: item.codeTypeVehicule.libelleTypeVehicule,
          // rowLibelleArticleBonEntree: item.identifiantBE.libelleArticleBonEntree,
          // rowNumber: this.rowNumber++,
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





}
