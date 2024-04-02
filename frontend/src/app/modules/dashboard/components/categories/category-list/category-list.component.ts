import { Component, Input } from "@angular/core";
import { Flowbite } from "app/core/config/flowbiteConfig";
import { Category } from "app/core/models/category";
import { CategoryService } from "app/core/services/category.service";

@Component({
	selector: "app-category-list",
	templateUrl: "./category-list.component.html",
	styleUrl: "./category-list.component.css",
})
@Flowbite()
export class CategoryListComponent {
	@Input() categories!: Category[];
	toSave: Category = new Category();
	constructor(private categoryService: CategoryService) {}

	ngOnInit() {}

	onSubmit() {
		// this.categoryService.update(this.toSave).subscribe();
	}
	handleClick(category: Category) {
		this.toSave.id = category.id;
		this.toSave.name = category.name;
	}
	onDelete() {
		// this.categoryService.delete(this.toSave.id).subscribe();
	}
}
