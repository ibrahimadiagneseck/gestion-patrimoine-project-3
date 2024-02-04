import { Component, Inject, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Subscription } from 'rxjs';
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from '@angular/material/dialog';
import { MyDateService } from 'src/app/services/my-date.service';
import { UniteDouaniere } from 'src/app/model/unite-douaniere.model';

@Component({
  selector: 'app-unite-douaniere-detail',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './unite-douaniere-detail.component.html',
  styleUrl: './unite-douaniere-detail.component.css'
})
export class UniteDouaniereDetailComponent implements OnInit, OnDestroy  {


  private subscriptions: Subscription[] = [];

  constructor(
    public dialogRef: MatDialogRef<UniteDouaniereDetailComponent>,
    @Inject(MAT_DIALOG_DATA) public uniteDouaniere: UniteDouaniere,
  ) {}

  ngOnInit(): void {

  }
  

  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }


  supprimerUniteDouaniereById(codeUniteDouaniere: String): void {

    // const dialogRef = this.matDialog.open(
    //   PopupConfirmationSupprimerComponent,
    //   {
    //     width: '40%',
    //     enterAnimationDuration: '100ms',
    //     exitAnimationDuration: '100ms',
    //     data: {
    //       id: numeroSerie,
    //       categorie: "vehicule",
    //       message: "Voulez-vous supprimer ce vehicule?"
    //     }
    //   }
    // );

    // dialogRef.afterClosed().subscribe(() => {
    //   this.popupFermer();
    // });
  }

  popupFermer(): void {
    this.dialogRef.close();
  }


}
