import { Component, OnInit } from "@angular/core";
import { Tag } from "app/core/models/tag";
import { TagService } from "app/core/services/tag.service";

@Component({
	selector: "app-tags",
	templateUrl: "./tags.component.html",
	styleUrl: "./tags.component.css",
})
export class TagsComponent implements OnInit {
	tags: Tag[] = [];

	constructor(private tagService: TagService) {}

	ngOnInit() {
		this.tagService.getAllTags().subscribe((tags) => {
			this.tags = tags;
			console.log(this.tags);
		});
	}
}
