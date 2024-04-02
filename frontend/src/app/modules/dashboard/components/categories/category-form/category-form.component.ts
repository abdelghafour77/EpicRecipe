import { Component, OnInit } from "@angular/core";
import { Category } from "app/core/models/category";
import { CategoryService } from "app/core/services/category.service";

@Component({
	selector: "app-category-form",
	templateUrl: "./category-form.component.html",
	styleUrl: "./category-form.component.css",
})
export class CategoryFormComponent implements OnInit {
	toSave: Category = new Category();
	image?: File;

	constructor(private categoryService: CategoryService) {}

	ngOnInit() {}

	onFileSelected(event: any) {
		console.log("new File selected:", event);
		const file = event.files[0];
		this.image = file;
		console.log("Selected file:", file);
	}

	onSubmit() {
		const imageExt = this.image?.name.split(".").pop();
		this.toSave.image = Date.now() + "." + imageExt;

		this.categoryService.saveCategory(this.toSave).subscribe(
			(response) => {
				console.log("Category saved");
				this.uploadFile(response.id || 0, response.image || "");
			},
			(error) => {
				console.error("Error saving category", error);
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

		this.categoryService.uploadFile(formData).subscribe(
			(response) => {
				console.log("File uploaded successfully:", response);
			},
			(error) => {
				console.error("Error uploading file:", error);
			},
		);
	}
}
