import { Component, ElementRef, OnInit, QueryList, ViewChildren } from "@angular/core";
import { Category } from "app/core/models/category";
import { Ingredient } from "app/core/models/ingredient";
import { Recipe } from "app/core/models/recipe";
import { RecipeStep } from "app/core/models/recipe-step";
import { Tag } from "app/core/models/tag";
import { CategoryService } from "app/core/services/category.service";
import { IngredientService } from "app/core/services/ingredient.service";
import { RecipeService } from "app/core/services/recipe.service";
import { TagService } from "app/core/services/tag.service";

interface UploadEvent {
	originalEvent: Event;
	files: File[];
}
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
	selectedIngredients: number[] = [];
	categories: Category[] = [];
	ingredients: Ingredient[] = [];
	tags: Tag[] = [];
	steps: RecipeStep[] = [];
	image?: File;

	uploadedFiles: any[] = [];

	constructor(
		private recipeService: RecipeService,
		private categorieService: CategoryService,
		private tagService: TagService,
		private ingredientService: IngredientService,
	) {
		this.toSave = new Recipe();
	}

	ngOnInit() {
		const Step = new RecipeStep();
		Step.step = "";
		Step.id = this.steps.length + 1;
		Step.stepNumber = this.steps.length + 1;
		this.steps.push(Step);

		this.categorieService.getCategories().subscribe((data) => {
			this.categories = data;
		});
		this.tagService.getAllTags().subscribe((data) => {
			this.tags = data;
		});
		this.ingredientService.getAllIngredients().subscribe((data) => {
			this.ingredients = data;
		});
	}
	cloneStep() {
		const lastStep = this.steps[this.steps.length - 1];
		const clonedStep = new RecipeStep();
		clonedStep.stepNumber = this.steps.length + 1;
		clonedStep.id = this.steps.length + 1;
		clonedStep.step = "";
		this.steps.push(clonedStep);
		// console.log("Step:", this.steps);
	}
	// for simple input file
	// onFileSelected(event: any) {
	// 	console.log("old File selected:", event);
	// 	const file = event.target.files[0] as File;
	// 	this.image = file;
	// 	console.log("Selected file:", file);
	// }
	onFileSelected(event: any) {
		console.log("new File selected:", event);
		const file = event.files[0];
		this.image = file;
		console.log("Selected file:", file);
	}
	onSubmit() {
		// get the category object using the selected category id
		const category = this.categories.find((c) => c.id == (this.selectedCategory as number)) as Category;
		this.toSave.category = category;

		// get array of tags objects
		const tags: Tag[] = this.selectedTags.map((id) => this.tags.find((t) => t.id === id)).filter((tag) => tag !== undefined) as Tag[];
		this.toSave.tags = tags;

		// get array of ingredients objects
		const ingredients: Ingredient[] = this.selectedIngredients
			.map((id) => this.ingredients.find((i) => i.id === id))
			.filter((ingredient) => ingredient !== undefined) as Ingredient[];
		this.toSave.ingredients = ingredients;

		this.toSave.steps = this.steps;

		const imageExt = this.image?.name.split(".").pop();
		this.toSave.image = Date.now() + "." + imageExt;

		console.log("image name:", this.toSave.image);

		console.log("Recipe to save:", this.toSave);

		console.log("new files:", this.uploadedFiles);

		this.recipeService.saveRecipe(this.toSave).subscribe(
			(response) => {
				console.log("Recipe saved successfully:", response);
				this.uploadFile(response.id || 0, response.image || "");
			},
			(error) => {
				console.error("Error saving recipe:", error);
			},
		);
	}
	uploadFile(id: number, fileName: string) {
		const formData = new FormData();
		if (this.image) {
			formData.append("image", this.image);
		}

		formData.append("recipeId", id.toString());
		formData.append("fileName", fileName);

		this.recipeService.uploadFile(formData).subscribe(
			(response) => {
				console.log("File uploaded successfully:", response);
			},
			(error) => {
				console.error("Error uploading file:", error);
			},
		);
	}
}
