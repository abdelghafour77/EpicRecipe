import { Component, OnInit } from "@angular/core";
import { Category } from "app/core/models/category";
import { Recipe } from "app/core/models/recipe";
import { CategoryService } from "app/core/services/category.service";
import { RecipeService } from "app/core/services/recipe.service";

@Component({
	selector: "app-add-recipe",
	templateUrl: "./add-recipe.component.html",
	styleUrl: "./add-recipe.component.css",
})
export class AddRecipeComponent implements OnInit {
	toSave: Recipe = new Recipe();
	categories: Category[] = [];
	constructor(private recipeService: RecipeService, private categorieService: CategoryService) {}

	ngOnInit() {
		this.categorieService.getCategories().subscribe((data) => {
			this.categories = data;
		});
	}

	onSubmit() {}
	onCancel() {}
}
