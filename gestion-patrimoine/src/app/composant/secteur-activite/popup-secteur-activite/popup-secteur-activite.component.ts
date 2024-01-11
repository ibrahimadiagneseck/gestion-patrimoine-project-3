import { Component, Inject, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormArray, FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from '@angular/material/dialog';
import { SecteurActivite } from 'src/app/model/secteur-activite.model';
import { Subscription } from 'rxjs';
import { Prestataires } from 'src/app/model/prestataires.model';


@Component({
  selector: 'app-popup-secteur-activite', 
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './popup-secteur-activite.component.html',
  styleUrl: './popup-secteur-activite.component.css'
})
export class PopupSecteurActiviteComponent implements OnInit, OnDestroy {

  checkArray: FormArray | undefined;
  public secteurActiviteForm!: FormGroup;
  
  public secteurActivitesSelect: SecteurActivite[] = [];

  public secteurActivites: SecteurActivite[] = [];
  public secteurActivite: SecteurActivite = new SecteurActivite();

  public prestataires: Prestataires[] = [];
  public prestataire: Prestataires = new Prestataires();


  private subscriptions: Subscription[] = [];

  constructor(
    public dialogRef: MatDialogRef<PopupSecteurActiviteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { secteurActivites: SecteurActivite[], prestataire: Prestataires },
    private matDialog: MatDialog,
    private fb: FormBuilder,

  ) {
    this.secteurActiviteForm = this.fb.group({
      checkArray: this.fb.array([])
    });
  }




  ngOnInit(): void {
    this.secteurActivites = this.data.secteurActivites;
    this.prestataire  = this.data.prestataire; 
    // console.log(this.secteurActivites);
  }


  validerSecteurActivites(): void {
    this.popupFermer()
  }


  isChecked(secteurActivite: SecteurActivite): boolean {
    // Implémentez la logique pour déterminer si la case à cocher doit être cochée
    // Par exemple, retournez true si secteurActivite est sélectionné, sinon false
    // À adapter selon votre logique métier
    
    if (this.checkArray && this.checkArray.controls.length > 0) {
      // Utilisez some pour vérifier si secteurActivite existe dans le FormArray
      return this.checkArray.controls.some(control => control.value === secteurActivite);
    }
    // Si le FormArray est undefined ou vide, retournez false
    return false;
  }



  onCheckboxChange(event: any, secteurActivite: SecteurActivite) {
    this.checkArray = this.secteurActiviteForm.get('checkArray') as FormArray;
  
    if (event.target.checked) {
      if (this.checkArray) {
        this.checkArray.push(new FormControl(secteurActivite));
        // console.log(this.checkArray.value);
      }
    } else {
      const index = this.checkArray.controls.findIndex(x => x.value === secteurActivite);
      this.checkArray.removeAt(index);
      // console.log(this.checkArray.value);
    }
  
    this.secteurActivitesSelect = this.checkArray.value;
    // console.log(this.secteurActivitesSelect);
  }
  

  


  popupFermer(): void {
    this.dialogRef.close();
  }



  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }


}