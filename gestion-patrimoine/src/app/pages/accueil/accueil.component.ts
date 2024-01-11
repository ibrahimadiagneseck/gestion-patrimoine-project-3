import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { User } from 'src/app/model/user.model';
import { LoginService } from 'src/app/services/login.service';


@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {

  user = new User();

  constructor(
    private loginService: LoginService
  ) {}

  ngOnInit() {
    
    const result = this.loginService.sessionStorageGetItem();

    if (result instanceof User) {
      this.user = result;
    }
  }
  
}
