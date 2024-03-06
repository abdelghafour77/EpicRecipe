import {Component, OnInit} from '@angular/core';
import {KeycloakService} from "keycloak-angular";
import {KeycloakProfile} from "keycloak-js";
import { initFlowbite } from 'flowbite';
import { Flowbite } from './config/flowbiteConfig';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
@Flowbite()
export class AppComponent implements OnInit{
  title = 'EpicRecipe';
  public profile! : KeycloakProfile;
  constructor(public keycloakService : KeycloakService) {
  }

  ngOnInit() {
    initFlowbite();
    if(this.keycloakService.isLoggedIn()){
      this.keycloakService.loadUserProfile().then(profile=>{
        this.profile=profile;
      });
    }
  }

  async handleLogin() {
    await this.keycloakService.login({
      redirectUri: window.location.origin
    });
  }

  async handleRegister() {
    await this.keycloakService.register(
      {
        redirectUri: window.location.origin
      }
    );
  }

  handleLogout(){
    this.keycloakService.logout(window.location.origin);
  }
}