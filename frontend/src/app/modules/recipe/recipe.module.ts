import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { RecipeComponent } from "./recipe.component";
import { RecipeDetailsComponent } from "./pages/recipe-details/recipe-details.component";
import { RouterOutlet } from "@angular/router";
import { RecipeRoutingModule } from "./recipe-routing.module";
import { SharedModule } from "app/shared/shared.module";
import { RecipesComponent } from "./recipes/recipes.component";
import { CommentComponent } from './comment/comment.component';
import { RatingComponent } from './rating/rating.component';

@NgModule({
	declarations: [RecipeComponent, RecipeDetailsComponent, RecipesComponent, CommentComponent, RatingComponent],
	imports: [CommonModule, RouterOutlet, RecipeRoutingModule, SharedModule],
})
export class RecipeModule {}
