import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { DashboardComponent } from "./dashboard.component";
import { DashBodyComponent } from "./components/dash-body/dash-body.component";
import { SharedModule } from "app/shared/shared.module";
import { DashboardRoutingModule } from "./dashboard-routing.module";
import { RouterOutlet } from "@angular/router";
import { RecipesComponent } from "./components/recipes/recipes.component";
import { CategoriesComponent } from "./components/categories/categories.component";
import { UsersComponent } from "./components/users/users.component";
import { TagsComponent } from "./components/tags/tags.component";
import { ReportsComponent } from "./components/reports/reports.component";
import { RecipeFormComponent } from "./components/recipes/recipe-form/recipe-form.component";
import { RecipeListComponent } from "./components/recipes/recipe-list/recipe-list.component";
import { TagFormComponent } from "./components/tags/tag-form/tag-form.component";
import { TagListComponent } from "./components/tags/tag-list/tag-list.component";
import { IngredientsComponent } from "./components/ingredients/ingredients.component";
import { IngredientListComponent } from "./components/ingredients/ingredient-list/ingredient-list.component";
import { IngredientFormComponent } from "./components/ingredients/ingredient-form/ingredient-form.component";
import { CategoryFormComponent } from "./components/categories/category-form/category-form.component";
import { CategoryListComponent } from "./components/categories/category-list/category-list.component";
import { UserFormComponent } from "./components/users/user-form/user-form.component";
import { UserListComponent } from "./components/users/user-list/user-list.component";
import { ReportListComponent } from "./components/reports/report-list/report-list.component";
import { FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { AddRecipeComponent } from './components/recipes/add-recipe/add-recipe.component';

@NgModule({
	declarations: [
		DashboardComponent,
		DashBodyComponent,
		RecipesComponent,
		CategoriesComponent,
		UsersComponent,
		TagsComponent,
		ReportsComponent,
		RecipeFormComponent,
		RecipeListComponent,
		TagFormComponent,
		TagListComponent,
		IngredientsComponent,
		IngredientListComponent,
		IngredientFormComponent,
		CategoryFormComponent,
		CategoryListComponent,
		UserFormComponent,
		UserListComponent,
		ReportListComponent,
  AddRecipeComponent,
	],
	imports: [CommonModule, RouterOutlet, DashboardRoutingModule, SharedModule, ReactiveFormsModule, SharedModule, FormsModule],
})
export class DashboardModule {}
