import { Component, Input } from "@angular/core";
import { Ingredient } from "app/core/models/ingredient";

@Component({
	selector: "app-ingredient-list",
	templateUrl: "./ingredient-list.component.html",
	styleUrl: "./ingredient-list.component.css",
})
export class IngredientListComponent {
	@Input() ingredients!: Ingredient[];
}
