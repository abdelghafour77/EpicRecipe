import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RecipesComponent } from './components/recipes/recipes.component';
import { AuthGuard } from './guards/auth.guard';
import { UsersComponent } from './components/users/users.component';

const routes: Routes = [
  {
    path: 'recipes',
    component: RecipesComponent,
    canActivate: [AuthGuard],
    data: { roles: ['USER'] },
  },
  {
    path: 'users',
    component: UsersComponent,
    canActivate: [AuthGuard],
    data: { roles: ['USER'] },
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
  // {
  //   path: 'recipes',
  //   loadChildren: () =>
  //     import('./recipes/recipes.module').then((m) => m.RecipesModule),
  // },
  // {
  //   path: 'auth',
  //   loadChildren: () =>
  //     import('./auth/auth.module').then((m) => m.AuthModule),
  // },
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
