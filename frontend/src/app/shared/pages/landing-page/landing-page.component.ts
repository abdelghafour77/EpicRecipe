import { Component, OnInit } from "@angular/core";
import { Flowbite } from "app/core/config/flowbiteConfig";
import { Category } from "app/core/models/category";
import { LandingPage } from "app/core/models/landing-page";
import { Recipe } from "app/core/models/recipe";
import { CategoryService } from "app/core/services/category.service";
import { RecipeService } from "app/core/services/recipe.service";

@Component({
	selector: "app-landing-page",
	templateUrl: "./landing-page.component.html",
	styleUrl: "./landing-page.component.css",
})
@Flowbite()
export class LandingPageComponent implements OnInit {
	landingPage: LandingPage = new LandingPage();
	categories: Category[] = [];
	recipes: Recipe[] = [];

	constructor(private categoryService: CategoryService, private recipeService: RecipeService) {}

	ngOnInit(): void {
		this.categoryService.getCategories().subscribe((categories) => {
			this.landingPage.categories = categories;
		});
		this.recipeService.getTopRecipes().subscribe((recipes) => {
			this.landingPage.recipes = recipes;
		});

		this.landingPage.categories = this.categories;
		this.landingPage.recipes = this.recipes;
	}
}
