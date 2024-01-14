import { HttpErrorResponse } from '@angular/common/http';
import { Component, Inject, OnDestroy, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Subscription } from 'rxjs';
import { NotificationType } from 'src/app/enum/notification-type.enum';
import { CustomHttpRespone } from 'src/app/model/custom-http-response.model';
import { NotificationService } from 'src/app/services/notification.service';
import { PrestatairesService } from 'src/app/services/prestataires.service';
// import { UtilisateurService } from 'src/app/services/utilisateur.service';
import { VehiculeService } from 'src/app/services/vehicule.service';

@Component({
  selector: 'app-popup-confirmation-supprimer',
  templateUrl: './popup-confirmation-supprimer.component.html',
  styleUrls: ['./popup-confirmation-supprimer.component.css']
})
export class PopupConfirmationSupprimerComponent implements OnInit, OnDestroy {


  private subscriptions: Subscription[] = [];

  constructor(
    private prestatairesService: PrestatairesService,
    private vehiculeService: VehiculeService,
    public dialogRef: MatDialogRef<PopupConfirmationSupprimerComponent>,
    @Inject(MAT_DIALOG_DATA) public informations: any,
    private notificationService: NotificationService
  ) { }


  private sendNotification(type: NotificationType, message: string, titre?: string): void {
    if (message) {
      this.notificationService.showAlert(type, message, titre);
    } else {
      this.notificationService.showAlert(type, 'Une erreur s\'est produite. Veuillez réessayer.', titre);
    }
  }


  supprimeronfirmer(id: string, categorie: string): void {

    switch (categorie) {
      case "prestataire":
        this.subscriptions.push(
          this.prestatairesService.supprimerPrestatairesById(id).subscribe({
            next: (response: CustomHttpRespone) => {
              this.popupFermer();
              this.sendNotification(NotificationType.SUCCESS, response.message);
            },
            error: (erreurs: HttpErrorResponse) => {
              console.log(erreurs);
            }
          })
        );
        break;
    
      case "vehicule":
        this.subscriptions.push(
          this.vehiculeService.supprimerVehiculeById(id).subscribe({
            next: (response: CustomHttpRespone) => {
              this.popupFermer();
              this.sendNotification(NotificationType.SUCCESS, response.message);
            },
            error: (erreurs: HttpErrorResponse) => {
              console.log(erreurs);
            }
          })
        );
        break;
    
      default:
      
        break;
    }
    
    
  }

  ngOnInit(): void {

  }


  popupFermer(): void {
    this.dialogRef.close();
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

}