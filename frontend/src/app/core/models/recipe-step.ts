export interface RecipeStepInterface {
	id?: number;
	stepNumber?: number;
	step?: string;
}

export class RecipeStep implements RecipeStepInterface {
	constructor(public id?: number, public stepNumber?: number, public step?: string) {}
}
