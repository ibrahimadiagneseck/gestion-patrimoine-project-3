import { Component, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Subscription } from 'rxjs';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-prestataire-secteur-ajouter',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './prestataire-secteur-ajouter.component.html',
  styleUrl: './prestataire-secteur-ajouter.component.css'
})
export class PrestataireSecteurAjouterComponent implements OnInit, OnDestroy {

  private subscriptions: Subscription[] = [];

  constructor(
    public dialogRef: MatDialogRef<PrestataireSecteurAjouterComponent>
  ) {}


  ngOnInit(): void {

  }


  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

  popupFermer(): void {
    this.dialogRef.close();
  }


  // --------------------------------------------------------------------------

  private clickButton(buttonId: string): void {
    document.getElementById(buttonId)?.click();
  }

  // pour envoyer tous les formulaires
  public submitForm(): void { 
    this.clickButton('prestataire-form');
  }



  // onSubmit(): void {
  //   // console.log(this.vehiculeForm.value);
  //   // this.AjouterVehicule();
  // }

}
