import { UnitType } from "../enums/unit-type";

export interface IngredientInterface {
	name?: string;
	unityType?: UnitType;
}
export class Ingredient implements IngredientInterface {
	constructor(public name?: string, public unityType?: UnitType) {}
}
