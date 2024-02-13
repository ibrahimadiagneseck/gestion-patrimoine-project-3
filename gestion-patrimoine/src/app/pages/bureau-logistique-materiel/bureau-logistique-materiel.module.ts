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
import { ReceptionVehiculeListeComponent } from './vehicules/reception/reception-vehicule-liste/reception-vehicule-liste.component';
import { ConsultationVehiculeListeComponent } from './vehicules/consultation/consultation-vehicule-liste/consultation-vehicule-liste.component';
import { ReceptionVehiculeAjouterBonEntreeComponent } from './vehicules/reception/reception-vehicule-ajouter-bon-entree/reception-vehicule-ajouter-bon-entree.component';
import { ReceptionVehiculeDetailComponent } from './vehicules/reception/reception-vehicule-detail/reception-vehicule-detail.component';
import { ConsultationVehiculeDetailComponent } from './vehicules/consultation/consultation-vehicule-detail/consultation-vehicule-detail.component';
import { ReceptionVehiculeListeDetailComponent } from './vehicules/reception/reception-vehicule-liste-detail/reception-vehicule-liste-detail.component';
import { ReceptionVehiculeAjouterArticleComponent } from './vehicules/reception/reception-vehicule-ajouter-article/reception-vehicule-ajouter-article.component';
import { ConsultationReceptionVehiculeListeComponent } from './vehicules/consultation/consultation-reception-vehicule-liste/consultation-reception-vehicule-liste.component';
import { ConsultationReceptionVehiculeDetailComponent } from './vehicules/consultation/consultation-reception-vehicule-detail/consultation-reception-vehicule-detail.component';
import { ReceptionVehiculeModifierBonEntreeComponent } from './vehicules/reception/reception-vehicule-modifier-bon-entree/reception-vehicule-modifier-bon-entree.component';
import { DotationVehiculeListeComponent } from './vehicules/dotation/dotation-vehicule-liste/dotation-vehicule-liste.component';
import { DotationVehiculeDetailComponent } from './vehicules/dotation/dotation-vehicule-detail/dotation-vehicule-detail.component';
import { DotationVehiculeAjouterBonSortieComponent } from './vehicules/dotation/dotation-vehicule-ajouter-bon-sortie/dotation-vehicule-ajouter-bon-sortie.component';
import { DotationVehiculeNonDoteListeComponent } from './vehicules/dotation/dotation-vehicule-non-dote-liste/dotation-vehicule-non-dote-liste.component';
import { DotationVehiculeDetailBonSortieComponent } from './vehicules/dotation/dotation-vehicule-detail-bon-sortie/dotation-vehicule-detail-bon-sortie.component';
import { DotationVehiculeDetailBonSortieDetailComponent } from './vehicules/dotation/dotation-vehicule-detail-bon-sortie-detail/dotation-vehicule-detail-bon-sortie-detail.component';
import { DotationVehiculeNonDoteAjouterComponent } from './vehicules/dotation/dotation-vehicule-non-dote-ajouter/dotation-vehicule-non-dote-ajouter.component';
import { DotationVehiculeVehiculeAjouterComponent } from './vehicules/dotation/dotation-vehicule-vehicule-ajouter/dotation-vehicule-vehicule-ajouter.component';


@NgModule({
  declarations: [

    ReceptionVehiculeAjouterBonEntreeComponent,
    ReceptionVehiculeModifierBonEntreeComponent,
    ReceptionVehiculeAjouterArticleComponent,
    ReceptionVehiculeDetailComponent,
    ReceptionVehiculeListeComponent,
    ReceptionVehiculeListeDetailComponent,

    ConsultationVehiculeListeComponent,
    ConsultationVehiculeDetailComponent,
    ConsultationReceptionVehiculeListeComponent,
    ConsultationReceptionVehiculeDetailComponent,

    DotationVehiculeListeComponent,
    DotationVehiculeNonDoteListeComponent,
    DotationVehiculeDetailComponent,
    DotationVehiculeAjouterBonSortieComponent,
    DotationVehiculeDetailBonSortieComponent,
    DotationVehiculeDetailBonSortieDetailComponent,
    DotationVehiculeNonDoteAjouterComponent,
    DotationVehiculeVehiculeAjouterComponent

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
