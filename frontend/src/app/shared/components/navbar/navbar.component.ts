import { Component, OnInit } from "@angular/core";
import { Flowbite } from "app/core/config/flowbiteConfig";
import { KeycloakService } from "keycloak-angular";
import { KeycloakProfile } from "keycloak-js";

@Component({
	selector: "app-navbar",
	templateUrl: "./navbar.component.html",
	styleUrl: "./navbar.component.css",
})
@Flowbite()
export class NavbarComponent implements OnInit {
	isMenuOpen: boolean = false;
	public profile!: KeycloakProfile;
	userRoles: string[] = [];

	constructor(public keycloakService: KeycloakService) {}

	async ngOnInit() {
		const isLoggedIn: boolean = await this.keycloakService.isLoggedIn();
		if (isLoggedIn) {
			const profile: KeycloakProfile = await this.keycloakService.loadUserProfile();
			this.profile = profile;
			const roles: string[] = await this.keycloakService.getUserRoles();
			this.userRoles = roles;
			console.log("profile: " + this.profile);
			console.log("roles: " + this.userRoles);
		}
	}

	toggleMenu() {
		this.isMenuOpen = !this.isMenuOpen;
	}

	async handleLogin() {
		await this.keycloakService.login({
			redirectUri: window.location.origin,
		});
	}
	async handleRegister() {
		await this.keycloakService.register({
			redirectUri: window.location.origin,
		});
	}

	handleLogout() {
		this.keycloakService.logout(window.location.origin);
	}
}
