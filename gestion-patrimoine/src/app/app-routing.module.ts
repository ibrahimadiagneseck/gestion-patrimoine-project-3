import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './pages/connexion/connexion.component';
import { ErreurComponent } from './pages/erreur/erreur.component';
import { AccueilComponent } from './pages/accueil/accueil.component';
import { AuthKeyClockGuard } from './routeGuards/auth.route';
import { PrestataireSecteurListeComponent } from './pages/prestataire/prestataire-secteur-liste/prestataire-secteur-liste.component';
import { ReceptionVehiculeListeComponent } from './pages/bureau-logistique-materiel/vehicules/reception/reception-vehicule-liste/reception-vehicule-liste.component';
import { ConsultationVehiculeListeComponent } from './pages/bureau-logistique-materiel/vehicules/consultation/consultation-vehicule-liste/consultation-vehicule-liste.component';
import { ReceptionVehiculeDetailComponent } from './pages/bureau-logistique-materiel/vehicules/reception/reception-vehicule-detail/reception-vehicule-detail.component';

const routes: Routes = [

  { path: '', redirectTo: '/connexion', pathMatch: 'full'},
  { path: 'connexion', component: ConnexionComponent },

  { path: 'accueil', component: AccueilComponent, canActivate: [AuthKeyClockGuard], data: {
    roles: ['USER','ADMIN']
  }},

  { path: 'prestataire', component: PrestataireSecteurListeComponent, canActivate: [AuthKeyClockGuard], data: {
    roles: ['USER']
  }},



  { path: 'erreur', component: ErreurComponent },
  // { path: '**', redirectTo: 'erreur', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
