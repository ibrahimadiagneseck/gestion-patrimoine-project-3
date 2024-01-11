import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { User } from "src/app/model/user.model";
import { Observable, Subject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakProfile } from 'keycloak-js';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

    user = new User();

    public isLoggedIn = false;
    public userProfile: KeycloakProfile | null = null;

    constructor(
        private readonly keycloak: KeycloakService
    ) {}

    sessionStorageGetItem(): User | void {
        if(sessionStorage.getItem('userdetails')){
            return JSON.parse(sessionStorage.getItem('userdetails') || "");
        }
    }

    async sessionStorageSetItem(): Promise<User | void> {
        this.isLoggedIn = await this.keycloak.isLoggedIn();

        if (this.isLoggedIn) {
            this.userProfile = await this.keycloak.loadUserProfile();
            this.user.authStatus = 'AUTH';
            this.user.name = this.userProfile.firstName || "";
            this.user.email = this.userProfile.email || "";

            window.sessionStorage.setItem("userdetails", JSON.stringify(this.user));
        } else {
            this.keycloak.login(); // lancer immediatement l'authentification keycloak au demarrage de la page
        }
    }





}
