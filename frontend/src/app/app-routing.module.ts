import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RecipesComponent } from './shared/components/recipes/recipes.component';
import { AuthGuard } from './core/guards/auth.guard';
import { UsersComponent } from './shared/components/users/users.component';
import { RouteListComponent } from './route-list/route-list.component';

const routes: Routes = [
  { path: 'routes', component: RouteListComponent },
  // {
  //   path: '',
  //   redirectTo: 'recipes',
  //   pathMatch: 'full',
  // },
  // {
  //   path: '**',
  //   redirectTo: 'recipes',
  // },
  {
    path: 'recipe',
    loadChildren: () =>
      import('./modules/recipe/recipe.module').then((m) => m.RecipeModule),
  },
  {
    path: 'auth',
    loadChildren: () =>
      import('./modules/auth/auth.module').then((m) => m.AuthModule),
  },
  // {
  //   path: '',
  //   redirectTo: 'recipes',
  //   pathMatch: 'full',
  // },
  // {
  //   path: '**',
  //   redirectTo: 'recipes',
  // },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
