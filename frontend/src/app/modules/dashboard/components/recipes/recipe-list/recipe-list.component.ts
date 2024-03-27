import { Component, Input, OnInit } from "@angular/core";
import { Category } from "app/core/models/category";
import { Recipe } from "app/core/models/recipe";
import { CategoryService } from "app/core/services/category.service";

@Component({
	selector: "app-recipe-list",
	templateUrl: "./recipe-list.component.html",
	styleUrl: "./recipe-list.component.css",
})
export class RecipeListComponent implements OnInit {
	@Input() recipes!: Recipe[];

	toSave: Recipe = new Recipe();

	categories: Category[] = [];

	ngOnInit(): void {
		this.categoryService.getCategories().subscribe((categories) => {
			this.categories = categories;
		});
	}

	constructor(private categoryService: CategoryService) {}

	handleClick(recipe: Recipe) {
		this.toSave.id = recipe.id;
		this.toSave.title = recipe.title;
		this.toSave.description = recipe.description;
		this.toSave.ingredients = recipe.ingredients;
	}

	onSubmit() {
		throw new Error("Method not implemented.");
	}
	onDelete() {
		throw new Error("Method not implemented.");
	}
}
