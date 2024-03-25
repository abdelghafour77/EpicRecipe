export interface IngredientInterface {
	name?: string;
	unityType?: string;
}
export class Ingredient implements IngredientInterface {
	constructor(public name?: string, public unityType?: string) {}
}
