import { Component, OnInit } from "@angular/core";
import { Flowbite } from "app/core/config/flowbiteConfig";
import { initFlowbite } from "flowbite";

@Component({
	selector: "app-recipe",
	templateUrl: "./recipe.component.html",
	styleUrl: "./recipe.component.css",
})
@Flowbite()
export class RecipeComponent implements OnInit {
	constructor() {}

	ngOnInit() {
		initFlowbite();
	}
}
