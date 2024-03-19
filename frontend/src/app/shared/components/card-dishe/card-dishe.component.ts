import { Component, Input } from "@angular/core";
import { Recipe } from "app/core/models/recipe";

@Component({
	selector: "app-card-dishe",
	templateUrl: "./card-dishe.component.html",
	styleUrl: "./card-dishe.component.css",
})
export class CardDisheComponent {
	@Input() recipes!: Recipe[];

	constructor() {}
}
