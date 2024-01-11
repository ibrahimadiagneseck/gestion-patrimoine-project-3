import { NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';

import { BureauLogistiqueMaterielRoutingModule } from './bureau-logistique-materiel-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatDialogModule } from '@angular/material/dialog';
// import { MatTableExporterModule } from 'mat-table-exporter';
import { ComposantModule } from 'src/app/composant/composant.module';
import { ReceptionVehiculeListeComponent } from './vehicules/reception-vehicule-liste/reception-vehicule-liste.component';
import { ConsultationVehiculeListeComponent } from './vehicules/consultation-vehicule-liste/consultation-vehicule-liste.component';
import { ReceptionVehiculeAjouterBordereauLivraisonBonEntreeComponent } from './vehicules/reception-vehicule-ajouter-bordereau-livraison-bon-entree/reception-vehicule-ajouter-bordereau-livraison-bon-entree.component';
import { ReceptionVehiculeDetailComponent } from './vehicules/reception-vehicule-detail/reception-vehicule-detail.component';
import { ConsultationVehiculeDetailComponent } from './vehicules/consultation-vehicule-detail/consultation-vehicule-detail.component';
import { ReceptionVehiculeListeDetailComponent } from './vehicules/reception-vehicule-liste-detail/reception-vehicule-liste-detail.component';
import { ReceptionVehiculeAjouterArticleBonEntreeVehiculeComponent } from './vehicules/reception-vehicule-ajouter-article-bon-entree-vehicule/reception-vehicule-ajouter-article-bon-entree-vehicule.component';


@NgModule({
  declarations: [
    
    ReceptionVehiculeAjouterBordereauLivraisonBonEntreeComponent,
    ReceptionVehiculeAjouterArticleBonEntreeVehiculeComponent,
    ReceptionVehiculeDetailComponent,
    ReceptionVehiculeListeComponent,
    ReceptionVehiculeListeDetailComponent,

    ConsultationVehiculeListeComponent,
    ConsultationVehiculeDetailComponent
  ],
  imports: [
    BrowserModule,
    CommonModule, // ngif ngfor
    FormsModule,
    ReactiveFormsModule, // pour formGroup
    BrowserAnimationsModule,
    HttpClientModule, // pour le backend

    NgbModule, // dropdown

    ComposantModule, // composant

    MatTableModule, MatPaginatorModule,

    // MatPaginator,

    MatExpansionModule,
    MatSlideToggleModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatDividerModule,
    MatDialogModule,

    // MatTableExporterModule,

    // MDCDialog

    BureauLogistiqueMaterielRoutingModule
  ],
  providers: [DatePipe],
})
export class BureauLogistiqueMaterielModule { }
