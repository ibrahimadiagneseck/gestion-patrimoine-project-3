import { AfterViewInit, ChangeDetectorRef, Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Subscription } from 'rxjs';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { PopupConfirmationSupprimerComponent } from 'src/app/composant/supprimer/popup-confirmation-supprimer/popup-confirmation-supprimer.component';
import { Vehicule } from 'src/app/model/vehicule.model';

@Component({
  selector: 'app-consultation-vehicule-detail',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './consultation-vehicule-detail.component.html',
  styleUrl: './consultation-vehicule-detail.component.css'
})
export class ConsultationVehiculeDetailComponent implements OnInit, OnDestroy, AfterViewInit  {

  public numeroBE: string = '';
  public dateBonEntree: string = '';
  public raisonSociale: any = '';
  public dateBL: string = '';
  public numeroBL: string = '';
  public lieuDeLivraison: string = '';
  public libelleArticleBonEntree: string = '';

  

  @ViewChild('dataVehicule') data: any;

  ngAfterViewInit() {
    // Vous pouvez maintenant accéder aux propriétés du composant enfant
    if (this.data) {
      this.numeroBE = this.data.vehicule.identifiantBE.identifiantBE.numeroBE;
      this.dateBonEntree = this.data.vehicule.identifiantBE.identifiantBE.dateBonEntree;
      this.raisonSociale = this.data.vehicule.identifiantBE.identifiantBE.identifiantBL.ninea.raisonSociale;
      this.dateBL = this.data.vehicule.identifiantBE.identifiantBE.identifiantBL.dateBL;
      this.numeroBL = this.data.vehicule.identifiantBE.identifiantBE.identifiantBL.numeroBL;
      this.lieuDeLivraison = this.data.vehicule.identifiantBE.identifiantBE.identifiantBL.lieuDeLivraison;
      // this.numeroSerie = this.data.vehicule.numeroSerie;
      this.libelleArticleBonEntree = this.data.vehicule.identifiantBE.libelleArticleBonEntree;

      // Déclencher manuellement la détection des changements si nécessaire
      this.cdr.detectChanges();
    }
  }

  private subscriptions: Subscription[] = [];

  constructor(
    public dialogRef: MatDialogRef<ConsultationVehiculeDetailComponent>,
    private matDialog: MatDialog,
    private cdr: ChangeDetectorRef // Ajout de ChangeDetectorRef
  ) {}

  ngOnInit(): void {

    // console.log(this.vehicule);
    
  }
  

  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

  supprimerVehiculeById(numeroSerie: String): void {

    const dialogRef = this.matDialog.open(
      PopupConfirmationSupprimerComponent,
      {
        width: '40%',
        enterAnimationDuration: '100ms',
        exitAnimationDuration: '100ms',
        data: {
          id: numeroSerie,
          categorie: "vehicule",
          message: "Voulez-vous supprimer ce vehicule?"
        }
      }
    );

    dialogRef.afterClosed().subscribe(() => {
      this.popupFermer();
    });
  }

  popupFermer(): void {
    this.dialogRef.close();
  }

}
