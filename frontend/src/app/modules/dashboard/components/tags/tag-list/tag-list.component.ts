import { Component, Input } from "@angular/core";
import { Tag } from "app/core/models/tag";

@Component({
	selector: "app-tag-list",
	templateUrl: "./tag-list.component.html",
	styleUrl: "./tag-list.component.css",
})
export class TagListComponent {
	@Input() tags!: Tag[];
}
