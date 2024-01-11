import { Component, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgForm } from '@angular/forms';
import { BonEntree } from 'src/app/model/bon-entree.model';
import { HttpErrorResponse } from '@angular/common/http';
import { BonEntreeService } from 'src/app/services/bon-entree.service';
import { Subscription } from 'rxjs';
import { BordereauLivraison } from 'src/app/model/bordereau-livraison.model';
import { Sections } from 'src/app/model/sections.model';
import { Agent } from 'src/app/model/agent.model';
import { SectionsService } from 'src/app/services/sections.service';
import { BordereauLivraisonService } from 'src/app/services/bordereau-livraison.service';
import { AgentService } from 'src/app/services/agent.service';
import { Prestataires } from 'src/app/model/prestataires.model';
import { PrestatairesService } from 'src/app/services/prestataires.service';
import { MyDate } from 'src/app/model/my-date.model';
import { SecteurActivite } from 'src/app/model/secteur-activite.model';
import { SecteurActiviteService } from 'src/app/services/secteur-activite.service';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { PopupSecteurActiviteComponent } from '../../secteur-activite/popup-secteur-activite/popup-secteur-activite.component';

@Component({
  selector: 'app-prestataire-ajouter',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './prestataire-ajouter.component.html',
  styleUrl: './prestataire-ajouter.component.css'
})
export class PrestataireAjouterComponent implements OnInit, OnDestroy {

  public secteurActivitesSelect: SecteurActivite[] = [];

  public secteurActivites: SecteurActivite[] = [];
  public secteurActivite: SecteurActivite = new SecteurActivite();

  public prestataires: Prestataires[] = [];
  public prestataire: Prestataires = new Prestataires();

  private subscriptions: Subscription[] = [];

  constructor(
    public dialogRef: MatDialogRef<PrestataireAjouterComponent>,
    private secteurActiviteService: SecteurActiviteService,
    private prestatairesService: PrestatairesService,
    private matDialog: MatDialog,
  ) { }

  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

  ngOnInit(): void {
    this.listeSecteurActivites();

  }

  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------
  public listeSecteurActivites(): void {

    const subscription = this.secteurActiviteService.listeSecteurActivites().subscribe({
      next: (response: SecteurActivite[]) => {
        this.secteurActivites = response;
        console.log(this.secteurActivites);
        
      },
      error: (errorResponse: HttpErrorResponse) => {
        // console.log(errorResponse);
      },
    });

    this.subscriptions.push(subscription);
  }
  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------




  // --------------------------------------------------------------------------
  private clickButton(buttonId: string): void {
    document.getElementById(buttonId)?.click();
  }

  // pour executer ajouterBonEntree
  public submitBonEntreeForm(): void { 
    this.clickButton('prestataire-form')
  }

  public ajouterPrestataire(prestataireForm: NgForm): void {

    // -------------------------------------------------------------------------- METHODE 1
    // const formData = this.prestatairesService.createPrestatairesFormData(prestataireForm.value);

    // this.subscriptions.push(this.prestatairesService.ajouterPrestatairesRequestParam(formData).subscribe({
    //     next: (response: Prestataires) => {
    //       console.log(response);
          
    //     },
    //     error: (errorResponse: HttpErrorResponse) => {

    //     }
    //   })
    // );

    // -------------------------------------------------------------------------- METHODE 2

    // SECTEUR ACTIVITE
    prestataireForm.value.secteurActivite = this.secteurActivitesSelect;

    console.log(prestataireForm.value);
    
    
    this.subscriptions.push(this.prestatairesService.ajouterPrestataires(prestataireForm.value).subscribe({
        next: (response: Prestataires) => {
          console.log(response);
          this.popupFermer();
          
        },
        error: (errorResponse: HttpErrorResponse) => {

        }
      })
    );
  }
  // --------------------------------------------------------------------------


  popupSecteurActivite(secteurActivites: SecteurActivite[], prestataires: Prestataires): void {
    const dialogRef = this.matDialog.open(
      PopupSecteurActiviteComponent,
      {
        width: '80%',
        // height: '80%',
        enterAnimationDuration: '100ms',
        exitAnimationDuration: '100ms',
        data:  {
          secteurActivites: secteurActivites,
          prestataires: prestataires
        }
      }
    );

    dialogRef.afterClosed().subscribe(() => {
      // ----------------------------------
      // Accéder à this.secteurActivitesForm après la fermeture du popup
      if (dialogRef.componentInstance instanceof PopupSecteurActiviteComponent) {
        this.secteurActivitesSelect = dialogRef.componentInstance.secteurActivitesSelect;
        console.log(this.secteurActivitesSelect);
      }
      // ----------------------------------
      this.ngOnInit();
    });
  }


  popupFermer(): void {
    this.dialogRef.close();
  }

}