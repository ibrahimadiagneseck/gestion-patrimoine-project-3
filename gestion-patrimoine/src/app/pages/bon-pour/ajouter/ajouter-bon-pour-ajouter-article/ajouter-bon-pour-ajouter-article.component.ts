import { Component, Inject, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BonPour } from 'src/app/model/bon-pour.model';
import { ArticleBonPour } from 'src/app/model/article-bon-pour.model';
import { TypeObjet } from 'src/app/model/type-objet.model';
import { Subscription } from 'rxjs';
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ArticleBonPourService } from 'src/app/services/article-bon-pour.service';
import { BonPourService } from 'src/app/services/bon-pour.service';
import { TypeObjetService } from 'src/app/services/type-objet.service';
import { SecuriteService } from 'src/app/services/securite.service';
import { NotificationService } from 'src/app/services/notification.service';
import { NotificationType } from 'src/app/enum/notification-type.enum';
import { HttpErrorResponse } from '@angular/common/http';
import { Agent } from 'src/app/model/agent.model';
import { AgentService } from 'src/app/services/agent.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-ajouter-bon-pour-ajouter-article',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './ajouter-bon-pour-ajouter-article.component.html',
  styleUrl: './ajouter-bon-pour-ajouter-article.component.css'
})
export class AjouterBonPourAjouterArticleComponent implements OnInit, OnDestroy {


  public bonPours: BonPour[] = [];
  // public bonPour: BonPour | undefined;

  public articleBonPours: ArticleBonPour[] = [];
  public articleBonPour: ArticleBonPour | undefined;

  public typeObjets: TypeObjet[] = [];
  public typeObjet: TypeObjet | undefined;

  public agents: Agent[] = [];
  public agent: Agent | undefined;


  private subscriptions: Subscription[] = [];

  constructor(
    @Inject(MAT_DIALOG_DATA) public bonPour: BonPour,
    public dialogRef: MatDialogRef<AjouterBonPourAjouterArticleComponent>,
    private router: Router,
    private articleBonPourService: ArticleBonPourService,
    private bonPourService: BonPourService,
    private agentService: AgentService,
    private typeObjetService: TypeObjetService,
    private securiteService: SecuriteService,
    private matDialog: MatDialog,
    private notificationService: NotificationService
  ) {}

  private sendNotification(type: NotificationType, message: string, titre?: string): void {
    if (message) {
      this.notificationService.showAlert(type, message, titre);
    } else {
      this.notificationService.showAlert(type, 'Une erreur s\'est produite. Veuillez réessayer.', titre);
    }
  }

  ngOnInit(): void {
    this.listeTypeObjets();
    this.listeAgents();
  }


  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------
  public listeTypeObjets(): void {

    const subscription = this.typeObjetService.listeTypeObjets().subscribe({
      next: (response: TypeObjet[]) => {
        this.typeObjets = response;
        // console.log(this.typeObjets);
        
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
  public listeAgents(): void {

    const subscription = this.agentService.listeAgents().subscribe({
      next: (response: Agent[]) => {
        this.agents = response;
        // console.log(this.secteurActivites);
        
      },
      error: (errorResponse: HttpErrorResponse) => {
        // console.log(errorResponse);
      },
    });

    this.subscriptions.push(subscription);
  }
  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------


  popupFermer(): void {
    this.dialogRef.close();
  }


  // --------------------------------------------------------------------------

  private clickButton(buttonId: string): void {
    document.getElementById(buttonId)?.click();
  }

  // pour envoyer tous les formulaires
  public submitForm(): void { 
    this.clickButton('article-bon-pour-form');
  }


  // --------------------------------------------------------------------------
  
  // pour executer ajouterBonEntree
  public submitBonPourForm(): void { 
    this.clickButton('article-bon-pour-form')
  }

  public ajouterArticleBonPour(ArticleBonPourForm: NgForm): void {

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


    // BONPOUR AGENT
    ArticleBonPourForm.value.identifiantBP = this.bonPour;
    ArticleBonPourForm.value.matriculeAgent = this.agents[0];

    console.log(ArticleBonPourForm.value);
    
    this.subscriptions.push(this.articleBonPourService.ajouterArticleBonPour(ArticleBonPourForm.value).subscribe({
        next: (response: ArticleBonPour) => {
          console.log(response);
          this.popupFermer();
          this.sendNotification(NotificationType.SUCCESS, `Ajout réussie de l'article`);
        },
        error: (errorResponse: HttpErrorResponse) => {
          console.log(errorResponse);
          // this.sendNotification(NotificationType.ERROR, errorResponse.error);
        }
      })
    );
  }
  // --------------------------------------------------------------------------



  // onSubmit(): void {
  //   // console.log(this.vehiculeForm.value);
  //   // this.AjouterVehicule();
  // }

}
