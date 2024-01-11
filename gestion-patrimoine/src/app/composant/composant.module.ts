import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoaderComponent } from './loader/loader.component';
import { EnteteComponent } from './entete/entete.component';
import { MenuComponent } from './menu/menu.component';
import { PopupConfirmationSupprimerComponent } from './popup-confirmation-supprimer/popup-confirmation-supprimer.component';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatDialogModule } from '@angular/material/dialog';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from '../app-routing.module';
import { BonEntreeAjouterComponent } from './bon-entree-ajouter/bon-entree-ajouter.component';
import { ArticleBonEntreeAjouterComponent } from './article-bon-entree-ajouter/article-bon-entree-ajouter.component';
import { BordereauLivraisonAjouterComponent } from './bordereau-livraison-ajouter/bordereau-livraison-ajouter.component';
import { VehiculeAjouterComponent } from './vehicule-ajouter/vehicule-ajouter.component';
import { PrestataireAjouterComponent } from './prestataire-ajouter/prestataire-ajouter.component';
import { PopupSecteurActiviteComponent } from './popup-secteur-activite/popup-secteur-activite.component';
import { BonEntreeDetailComponent } from './bon-entree-detail/bon-entree-detail.component';
import { ArticleBonEntreeDetailComponent } from './article-bon-entree-detail/article-bon-entree-detail.component';
import { BordereauLivraisonDetailComponent } from './bordereau-livraison-detail/bordereau-livraison-detail.component';
import { VehiculeDetailComponent } from './vehicule-detail/vehicule-detail.component';
import { PrestataireDetailComponent } from './prestataire-detail/prestataire-detail.component';
import { SecteurActiviteDetailComponent } from './secteur-activite-detail/secteur-activite-detail.component';





@NgModule({
  declarations: [
    // composants
    LoaderComponent,
    EnteteComponent,
    MenuComponent,
    PopupConfirmationSupprimerComponent,

    BonEntreeAjouterComponent,
    BonEntreeDetailComponent,

    ArticleBonEntreeAjouterComponent,
    ArticleBonEntreeDetailComponent,

    BordereauLivraisonAjouterComponent,
    BordereauLivraisonDetailComponent,

    VehiculeAjouterComponent,
    VehiculeDetailComponent,

    PrestataireAjouterComponent,
    PrestataireDetailComponent,

    SecteurActiviteDetailComponent,

    PopupSecteurActiviteComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    NgbModule, // dropdown

    MatExpansionModule,
    MatSlideToggleModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatDividerModule,
    MatDialogModule,
    
    AppRoutingModule  
  ],
  exports: [
    // composants
    LoaderComponent,
    EnteteComponent,
    MenuComponent,
    PopupConfirmationSupprimerComponent,

    BonEntreeAjouterComponent,
    BonEntreeDetailComponent,

    ArticleBonEntreeAjouterComponent,
    ArticleBonEntreeDetailComponent,

    BordereauLivraisonAjouterComponent,
    BordereauLivraisonDetailComponent,

    VehiculeAjouterComponent,
    VehiculeDetailComponent,

    PrestataireAjouterComponent,
    PrestataireDetailComponent,

    SecteurActiviteDetailComponent,

    PopupSecteurActiviteComponent,
  ]
})
export class ComposantModule { }
