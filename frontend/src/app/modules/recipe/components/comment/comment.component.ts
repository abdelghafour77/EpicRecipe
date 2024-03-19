import { Component, Input } from "@angular/core";
import { Comment } from "app/core/models/comment";

@Component({
	selector: "app-comment",
	templateUrl: "./comment.component.html",
	styleUrl: "./comment.component.css",
})
export class CommentComponent {
	@Input() comments!: Comment[];

	constructor() {}
}
