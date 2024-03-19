import { Category } from "./category";
import { Recipe } from "./recipe";

export interface LandingPageInterface {
	categories?: Category[];
	recipes?: Recipe[];
}

export class LandingPage implements LandingPageInterface {
	constructor(public categories?: Category[], public recipes?: Recipe[]) {}
}
