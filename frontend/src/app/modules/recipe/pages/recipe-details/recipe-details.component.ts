import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Recipe } from "app/core/models/recipe";
import { Comment } from "app/core/models/comment";
import { RecipeStep } from "app/core/models/recipe-step";
import { RecipeService } from "app/core/services/recipe.service";
import { DatePipe } from "@angular/common";

@Component({
	selector: "app-recipe-details",
	templateUrl: "./recipe-details.component.html",
	styleUrl: "./recipe-details.component.css",
})
export class RecipeDetailsComponent implements OnInit {
	recipe: Recipe = new Recipe();
	steps: RecipeStep[] = [];
	comments: Comment[] = [];
	id: string = "";

	constructor(private route: ActivatedRoute, private recipeService: RecipeService, private datePipe: DatePipe) {}

	ngOnInit(): void {
		this.id = this.route.snapshot.params["id"];
		this.recipeService.getRecipeById(this.id).subscribe((recipe) => {
			this.recipe = recipe;
			// if (this.recipe.createdAt) {
			// 	this.recipe.createdAt = this.datePipe.transform(this.recipe.createdAt, "medium");
			// }
		});
	}
}
