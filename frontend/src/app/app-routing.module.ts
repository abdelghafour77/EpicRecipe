import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
// import { RecipesComponent } from "./shared/components/recipes/recipes.component";
// import { AuthGuard } from "./core/guards/auth.guard";
// import { UsersComponent } from "./shared/components/users/users.component";
import { RouteListComponent } from "./route-list/route-list.component";
import { LandingPageComponent } from "./shared/pages/landing-page/landing-page.component";

const routes: Routes = [
	{ path: "", component: LandingPageComponent },
	// { path: "routes", component: RouteListComponent },
	{
		path: "recipe",
		loadChildren: () => import("./modules/recipe/recipe.module").then((m) => m.RecipeModule),
	},
	{
		path: "auth",
		loadChildren: () => import("./modules/auth/auth.module").then((m) => m.AuthModule),
	},
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule],
})
export class AppRoutingModule {}
