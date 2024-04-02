import { Component, OnInit } from "@angular/core";
import { Category } from "app/core/models/category";
import { CategoryService } from "app/core/services/category.service";

@Component({
	selector: "app-categories",
	templateUrl: "./categories.component.html",
	styleUrl: "./categories.component.css",
})
export class CategoriesComponent implements OnInit {
	categories: Category[] = [];
	constructor(private categoryService: CategoryService) {}

	ngOnInit(): void {
		this.categoryService.getCategories().subscribe((categories) => {
			this.categories = categories;
		});
	}
}
