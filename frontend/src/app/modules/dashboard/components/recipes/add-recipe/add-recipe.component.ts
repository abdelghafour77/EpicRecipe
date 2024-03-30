import { Component, ElementRef, OnInit, QueryList, ViewChildren } from "@angular/core";
import { Category } from "app/core/models/category";
import { Recipe } from "app/core/models/recipe";
import { RecipeStep } from "app/core/models/recipe-step";
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
	@ViewChildren("stepDiv") stepDivs!: QueryList<ElementRef>;

	toSave: Recipe = new Recipe();
	selectedCategory?: number;
	selectedTags: number[] = [];
	categories: Category[] = [];
	tags: Tag[] = [];
	steps: RecipeStep[] = [];

	constructor(private recipeService: RecipeService, private categorieService: CategoryService, private tagService: TagService) {
		this.toSave = new Recipe();
	}

	ngOnInit() {
		this.steps.push(new RecipeStep());
		this.categorieService.getCategories().subscribe((data) => {
			this.categories = data;
		});
		this.tagService.getAllTags().subscribe((data) => {
			this.tags = data;
		});
	}
	cloneStep() {
		const lastStep = this.steps[this.steps.length - 1];
		const clonedStep = new RecipeStep();
		clonedStep.step = ""; // Retain the description value
		// You may want to clear the image field of the cloned step
		this.steps = this.toSave.steps ? this.toSave.steps : [];
		this.steps.push(clonedStep); // Add the cloned step to the array

		console.log("Step:", this.steps);
	}
	onFileSelected(event: any) {
		const file = event.target.files[0] as File;
		this.toSave.image = file;
	}
	onFileSelectedStep(event: any, index: number) {
		const file = event.target.files[0] as File;
		this.steps[index].image = file; // Set image for the corresponding recipe step
	}
	onSubmit() {
		// get the category object using the selected category id
		const category = this.categories.find((c) => c.id == (this.selectedCategory as number)) as Category;
		this.toSave.category = category;

		// get array of tags objects
		const tags: Tag[] = this.selectedTags.map((id) => this.tags.find((t) => t.id === id)).filter((tag) => tag !== undefined) as Tag[];
		this.toSave.tags = tags;

		// get array of steps
		console.log("Steps:", this.steps);
		this.toSave.steps = this.steps;

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
