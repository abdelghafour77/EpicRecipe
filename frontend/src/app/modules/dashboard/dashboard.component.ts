import { Component, OnInit } from "@angular/core";
import { Flowbite } from "app/core/config/flowbiteConfig";
import { initFlowbite } from "flowbite";
import { KeycloakService } from "keycloak-angular";
import { KeycloakProfile } from "keycloak-js";

@Component({
	selector: "app-dashboard",
	templateUrl: "./dashboard.component.html",
	styleUrl: "./dashboard.component.css",
})
@Flowbite()
export class DashboardComponent implements OnInit {
	public profile!: KeycloakProfile;
	userRoles: string[] = [];
	constructor(public keycloakService: KeycloakService) {}

	async ngOnInit() {
		initFlowbite();
		const isLoggedIn: boolean = await this.keycloakService.isLoggedIn();
		if (isLoggedIn) {
			const profile: KeycloakProfile = await this.keycloakService.loadUserProfile();
			this.profile = profile;
			const roles: string[] = await this.keycloakService.getUserRoles();
			this.userRoles = roles;
		}
	}
	handleLogout() {
		this.keycloakService.logout(window.location.origin);
	}
}
