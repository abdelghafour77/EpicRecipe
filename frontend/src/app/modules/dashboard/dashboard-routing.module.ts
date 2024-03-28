import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { DashboardComponent } from "./dashboard.component";
import { DashBodyComponent } from "./components/dash-body/dash-body.component";
import { RecipesComponent } from "./components/recipes/recipes.component";
import { CategoriesComponent } from "./components/categories/categories.component";
import { UsersComponent } from "./components/users/users.component";
import { TagsComponent } from "./components/tags/tags.component";
import { ReportsComponent } from "./components/reports/reports.component";
import { IngredientsComponent } from "./components/ingredients/ingredients.component";
import { AddRecipeComponent } from "./components/recipes/add-recipe/add-recipe.component";

// const routes: Routes = [
//   {
//     path: '',
//     component: DashboardComponent,
//     children: [
//       { path: '', redirectTo: 'sign-in', pathMatch: 'full' },
//     //   { path: 'sign-in', component: SignInComponent, data: { returnUrl: window.location.pathname } },
//     //   { path: 'sign-up', component: SignUpComponent },
//     //   { path: 'forgot-password', component: ForgotPasswordComponent },
//     //   { path: 'new-password', component: NewPasswordComponent },
//     //   { path: 'two-steps', component: TwoStepsComponent },
//       { path: '**', redirectTo: 'sign-in', pathMatch: 'full' },
//     ],
//   },
// ];
const routes: Routes = [
	{
		path: "",
		component: DashboardComponent,
		children: [
			{ path: "", component: DashBodyComponent },
			{ path: "recipes", component: RecipesComponent },
			{ path: "recipes/new", component: AddRecipeComponent },
			{ path: "ingredients", component: IngredientsComponent },
			{ path: "categories", component: CategoriesComponent },
			{ path: "users", component: UsersComponent },
			{ path: "tags", component: TagsComponent },
			{ path: "reports", component: ReportsComponent },

			// { path: ":id", component: RecipeDetailsComponent },
		],
	},
];

@NgModule({
	imports: [RouterModule.forChild(routes)],
	exports: [RouterModule],
})
export class DashboardRoutingModule {}
