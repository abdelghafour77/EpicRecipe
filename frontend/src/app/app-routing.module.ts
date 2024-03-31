import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { LandingPageComponent } from "./shared/pages/landing-page/landing-page.component";
import { DragAndDropComponent } from "./shared/components/drag-and-drop/drag-and-drop.component";

const routes: Routes = [
	{ path: "", component: LandingPageComponent },
	{
		path: "recipe",
		loadChildren: () => import("./modules/recipe/recipe.module").then((m) => m.RecipeModule),
	},
	{
		path: "dashboard",
		loadChildren: () => import("./modules/dashboard/dashboard.module").then((m) => m.DashboardModule),
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
