import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakProfile } from 'keycloak-js';
import { User } from 'src/app/model/user.model';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-connexion',
  template: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent implements OnInit {

  user = new User();
  
  constructor(
    private loginService: LoginService
  ) { }

  public async ngOnInit() {
    this.loginService.sessionStorageSetItem();
  }

  // public login() {
  //   this.keycloak.login();
  // }

  
}
