import { Component, OnInit } from "@angular/core";
import { Recipe } from "app/core/models/recipe";
import { RecipeService } from "app/core/services/recipe.service";

@Component({
	selector: "app-recipes",
	templateUrl: "./recipes.component.html",
	styleUrl: "./recipes.component.css",
})
export class RecipesComponent implements OnInit {
	recipes: Recipe[] = [];

	constructor(private recipeService: RecipeService) {}

	ngOnInit() {
		this.recipeService.getAllRecipes().subscribe((recipes) => {
			this.recipes = recipes;
			console.log(this.recipes);
		});
	}
}
