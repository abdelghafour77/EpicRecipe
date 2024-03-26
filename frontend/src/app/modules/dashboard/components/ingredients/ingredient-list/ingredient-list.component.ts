import { Component, Input } from "@angular/core";
import { UnitType } from "app/core/enums/unit-type";
import { Ingredient } from "app/core/models/ingredient";
import { IngredientService } from "app/core/services/ingredient.service";

@Component({
	selector: "app-ingredient-list",
	templateUrl: "./ingredient-list.component.html",
	styleUrl: "./ingredient-list.component.css",
})
export class IngredientListComponent {
	@Input() ingredients!: Ingredient[];
	toSave: Ingredient = new Ingredient();
	unitTypes: UnitType[] = Object.values(UnitType);
	constructor(private ingredientService: IngredientService) {}

	ngOnInit() {}

	onSubmit() {
		this.ingredientService.update(this.toSave).subscribe();
	}
	handleClick(ingredient: Ingredient) {
		this.toSave.id = ingredient.id;
		this.toSave.name = ingredient.name;
		this.toSave.unityType = ingredient.unityType;
		console.log(ingredient);
	}
	onDelete() {
		console.log(this.toSave);

		this.ingredientService.delete(this.toSave).subscribe();
		// remove the ingredient from the list
		this.ingredients = this.ingredients.filter((item) => item.id !== this.toSave.id);

		// close the drawer
		// this.drawer.close();
	}
}
