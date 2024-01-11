import { Component, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Subscription } from 'rxjs';
import { Prestataires } from 'src/app/model/prestataires.model';
import { PopupConfirmationSupprimerComponent } from 'src/app/composant/popup-confirmation-supprimer/popup-confirmation-supprimer.component';

@Component({
  selector: 'app-prestataire-secteur-detail',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './prestataire-secteur-detail.component.html',
  styleUrl: './prestataire-secteur-detail.component.css'
})
export class PrestataireSecteurDetailComponent implements OnInit, OnDestroy {

  @ViewChild('dataPrestataire') dataPrestataire: any;
  @ViewChild('dataSecteurActivite') dataSecteurActivite: any;

  ngAfterViewInit() {
    // Vous pouvez maintenant accéder aux propriétés du composant enfant
    if (this.dataPrestataire) {
      console.log(this.dataPrestataire.prestataire.ninea);
    }

    if (this.dataSecteurActivite) {
      console.log(this.dataSecteurActivite.secteurActivites);
    }
  }

  private subscriptions: Subscription[] = [];

  constructor(
    public dialogRef: MatDialogRef<PrestataireSecteurDetailComponent>,
    private matDialog: MatDialog,
  ) {}

  ngOnInit(): void {
    // console.log(this.prestataire);
    
  }
  

  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

  supprimerPrestataireById(ninea: String): void {

    const dialogRef = this.matDialog.open(
      PopupConfirmationSupprimerComponent,
      {
        width: '40%',
        enterAnimationDuration: '100ms',
        exitAnimationDuration: '100ms',
        data: {
          id: ninea,
          categorie: "prestataire",
          message: "Voulez-vous supprimer ce prestataire?"
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
