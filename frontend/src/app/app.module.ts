import { APP_INITIALIZER, NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { HttpClientModule } from "@angular/common/http";

import { KeycloakAngularModule, KeycloakService } from "keycloak-angular";
import { RecipesComponent } from "./shared/components/recipes/recipes.component";
import { UsersComponent } from "./shared/components/users/users.component";
import { RouteListComponent } from "./route-list/route-list.component";
import { HeroSectionComponent } from "./shared/components/hero-section/hero-section.component";
import { CardDisheComponent } from "./shared/components/card-dishe/card-dishe.component";
import { CardAboutUsComponent } from "./shared/components/card-about-us/card-about-us.component";
import { LandingPageComponent } from "./shared/pages/landing-page/landing-page.component";
import { SharedModule } from "./shared/shared.module";

function initializeKeycloak(keycloak: KeycloakService) {
	return () =>
		keycloak.init({
			config: {
				url: "http://localhost:9090",
				realm: "EpicRecipe",
				clientId: "frontend-angular",
			},
			initOptions: {
				onLoad: "check-sso",
				silentCheckSsoRedirectUri: window.location.origin + "/assets/silent-check-sso.html",
			},
		});
}

@NgModule({
	declarations: [
		AppComponent,
		RecipesComponent,
		UsersComponent,
		RouteListComponent,
		HeroSectionComponent,
		CardDisheComponent,
		CardAboutUsComponent,
		LandingPageComponent,
	],
	imports: [BrowserModule, AppRoutingModule, KeycloakAngularModule, HttpClientModule, SharedModule],
	providers: [
		// {
		// 	provide: APP_INITIALIZER,
		// 	useFactory: initializeKeycloak,
		// 	multi: true,
		// 	deps: [KeycloakService],
		// },
	],
	bootstrap: [AppComponent],
})
export class AppModule {}
