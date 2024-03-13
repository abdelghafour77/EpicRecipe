import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { RecipeComponent } from "./recipe.component";
import { RecipeDetailsComponent } from "./pages/recipe-details/recipe-details.component";
import { RecipesComponent } from "./recipes/recipes.component";

const routes: Routes = [
	{
		path: "",
		component: RecipeComponent,
		children: [
			{ path: "all", component: RecipesComponent },
			{ path: ":id", component: RecipeDetailsComponent },
		],
	},
];

@NgModule({
	imports: [RouterModule.forChild(routes)],
	exports: [RouterModule],
})
export class RecipeRoutingModule {}
