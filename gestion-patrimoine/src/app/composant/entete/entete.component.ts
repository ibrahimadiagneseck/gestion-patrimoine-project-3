import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { User } from 'src/app/model/user.model';

@Component({
  selector: 'app-entete',
  templateUrl: './entete.component.html',
  styleUrls: ['./entete.component.css']
})
export class EnteteComponent implements OnInit {

  user = new User();

  constructor(
    private readonly keycloak: KeycloakService
  ) { }
  
  ngOnInit(): void {
    if(sessionStorage.getItem('userdetails')) {
      this.user = JSON.parse(sessionStorage.getItem('userdetails') || "");
    }
  }

  public logout() {
    let redirectURI: string = "http://localhost:4200/connexion";
    this.keycloak.logout(redirectURI);
  }
}