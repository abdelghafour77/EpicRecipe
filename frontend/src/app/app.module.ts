import { APP_INITIALIZER, NgModule, LOCALE_ID } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { HttpClientModule } from "@angular/common/http";

import { KeycloakAngularModule, KeycloakService } from "keycloak-angular";
import { HeroSectionComponent } from "./shared/components/hero-section/hero-section.component";
import { CardDisheComponent } from "./shared/components/card-dishe/card-dishe.component";
import { CardAboutUsComponent } from "./shared/components/card-about-us/card-about-us.component";
import { LandingPageComponent } from "./shared/pages/landing-page/landing-page.component";
import { SharedModule } from "./shared/shared.module";
import { DatePipe } from "@angular/common";
import { provideAnimations } from "@angular/platform-browser/animations";

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
	declarations: [AppComponent, HeroSectionComponent, CardDisheComponent, CardAboutUsComponent, LandingPageComponent],
	imports: [BrowserModule, AppRoutingModule, KeycloakAngularModule, HttpClientModule, SharedModule],
	providers: [
		provideAnimations(),
		DatePipe,
		{ provide: LOCALE_ID, useValue: "en-US" },
		{
			provide: APP_INITIALIZER,
			useFactory: initializeKeycloak,
			multi: true,
			deps: [KeycloakService],
		},
	],
	bootstrap: [AppComponent],
})
export class AppModule {}
