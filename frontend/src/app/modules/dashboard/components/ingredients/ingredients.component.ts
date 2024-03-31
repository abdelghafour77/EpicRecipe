import { Component, OnInit } from "@angular/core";
import { Ingredient } from "app/core/models/ingredient";
import { IngredientService } from "app/core/services/ingredient.service";

@Component({
	selector: "app-ingredients",
	templateUrl: "./ingredients.component.html",
	styleUrl: "./ingredients.component.css",
})
export class IngredientsComponent implements OnInit {
	ingredients: Ingredient[] = [];
	constructor(private ingredientService: IngredientService) {}

	ngOnInit(): void {
		this.ingredientService.getAllIngredients().subscribe((ingredients) => {
			this.ingredients = ingredients;
		});
	}
}
