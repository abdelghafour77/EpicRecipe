import { Component, Input } from "@angular/core";
import { Category } from "app/core/models/category";

@Component({
	selector: "app-category",
	templateUrl: "./category.component.html",
	styleUrl: "./category.component.css",
})
export class CategoryComponent {
	@Input() categories!: Category[];

	constructor() {}
}
