import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot } from "@angular/router";
import { KeycloakAuthGuard, KeycloakService } from "keycloak-angular";

@Injectable({
	providedIn: "root",
})
export class AdminGuard extends KeycloakAuthGuard {
	constructor(protected override readonly router: Router, protected readonly keycloak: KeycloakService) {
		super(router, keycloak);
	}

	public async isAccessAllowed(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
		// Check if the user has the admin role.
		const hasAdminRole = this.roles.includes("ADMIN");

		// If the user doesn't have the admin role, redirect to the 401 page.
		if (!hasAdminRole) {
			this.router.navigate(["/"]);
			return false;
		}

		return true;
	}
}
