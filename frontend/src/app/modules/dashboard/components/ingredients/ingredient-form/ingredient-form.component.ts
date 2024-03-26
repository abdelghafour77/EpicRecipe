import { Component, OnInit } from "@angular/core";
import { UnitType } from "app/core/enums/unit-type";
import { Ingredient } from "app/core/models/ingredient";
import { IngredientService } from "app/core/services/ingredient.service";

@Component({
	selector: "app-ingredient-form",
	templateUrl: "./ingredient-form.component.html",
	styleUrl: "./ingredient-form.component.css",
})
export class IngredientFormComponent implements OnInit {
	toSave: Ingredient = new Ingredient();

	constructor(private ingredientService: IngredientService) {}

	ngOnInit() {}

	onSubmit() {
		this.ingredientService.create(this.toSave).subscribe();
	}
	unitTypes: UnitType[] = Object.values(UnitType);
}
