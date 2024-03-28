import { Comment } from "./comment";
import { RecipeStep } from "./recipe-step";
import { Favorite } from "./favorite";
import { Ingredient } from "./ingredient";
import { Tag } from "./tag";
import { Category } from "./category";

export interface RecipeInterface {
	id?: number;
	title?: string;
	description?: string;
	createdAt?: Date | undefined;
	steps?: RecipeStep[];
	comments?: Comment[];
	favorites?: Favorite[];
	ingredients?: Ingredient[];
	tags?: Tag[];
	status?: string;
	category?: Category;
}

export class Recipe implements RecipeInterface {
	constructor(
		public id?: number,
		public title?: string,
		public description?: string,
		public createdAt?: Date | undefined,
		public steps?: RecipeStep[],
		public comments?: Comment[],
		public favorites?: Favorite[],
		public ingredients?: Ingredient[],
		public tags?: Tag[],
		public status?: string,
		public category?: Category,
	) {}
}
