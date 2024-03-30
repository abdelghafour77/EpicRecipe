import { Component, OnInit } from "@angular/core";
import { Category } from "app/core/models/category";
import { Recipe } from "app/core/models/recipe";
import { Tag } from "app/core/models/tag";
import { CategoryService } from "app/core/services/category.service";
import { RecipeService } from "app/core/services/recipe.service";
import { TagService } from "app/core/services/tag.service";

@Component({
	selector: "app-add-recipe",
	templateUrl: "./add-recipe.component.html",
	styleUrl: "./add-recipe.component.css",
})
export class AddRecipeComponent implements OnInit {
	toSave: Recipe = new Recipe();
	selectedCategory?: number;
	selectedTags: number[] = [];
	categories: Category[] = [];
	tags: Tag[] = [];

	constructor(private recipeService: RecipeService, private categorieService: CategoryService, private tagService: TagService) {
		this.toSave = new Recipe();
	}

	ngOnInit() {
		this.categorieService.getCategories().subscribe((data) => {
			this.categories = data;
		});
		this.tagService.getAllTags().subscribe((data) => {
			this.tags = data;
		});
	}
	onFileSelected(event: any) {
		const file = event.target.files[0] as File;
		this.toSave.image = file;
	}
	onSubmit() {
		// get the category object using the selected category id
		const category = this.categories.find((c) => c.id == (this.selectedCategory as number)) as Category;
		this.toSave.category = category;

		// get array of tags objects
		const tags: Tag[] = this.selectedTags.map((id) => this.tags.find((t) => t.id === id)).filter((tag) => tag !== undefined) as Tag[];
		this.toSave.tags = tags;

		console.log("Recipe to save:", this.toSave);

		// this.recipeService.saveRecipe(this.toSave).subscribe(
		// 	(response) => {
		// 		console.log("Recipe saved successfully:", response);
		// 	},
		// 	(error) => {
		// 		console.error("Error saving recipe:", error);
		// 	},
		// );
	}
	onCancel() {}
	onChange(event: any) {}
}
