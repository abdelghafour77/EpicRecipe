import { Component, Input } from "@angular/core";
import { Recipe } from "app/core/models/recipe";

@Component({
	selector: "app-recipe-list",
	templateUrl: "./recipe-list.component.html",
	styleUrl: "./recipe-list.component.css",
})
export class RecipeListComponent {
	onDeleteRecipe(_t32: Recipe) {
		// open drawer with delete confirmation
	}
	onEditRecipe(_t32: Recipe) {
		// throw new Error("Method not implemented.");
		// open drawer with recipe form
	}
	@Input() recipes!: Recipe[];

	constructor() {}
}
