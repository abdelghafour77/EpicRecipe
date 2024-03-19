import { DatePipe } from "@angular/common";
import { Comment } from "./comment";
import { RecipeStep } from "./recipe-step";

export interface RecipeInterface {
	id?: number;
	title?: string;
	description?: string;
	createdAt?: Date | undefined;
	steps?: RecipeStep[];
	comments?: Comment[];
}

export class Recipe implements RecipeInterface {
	constructor(
		public id?: number,
		public title?: string,
		public description?: string,
		public createdAt?: Date | undefined,
		public steps?: RecipeStep[],
		public comments?: Comment[],
	) {}
}
