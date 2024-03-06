import { RecipeSteps } from "./recipe_steps";

export interface Recipe {
    id: number;
    title: string;
    description: string;
    steps: RecipeSteps[];
}
