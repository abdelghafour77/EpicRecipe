import { UnitType } from "../enums/unit-type";

export interface IngredientInterface {
	id?: number;
	name?: string;
	unityType?: UnitType;
}
export class Ingredient implements IngredientInterface {
	constructor(public id?: number, public name?: string, public unityType?: UnitType) {}
}
