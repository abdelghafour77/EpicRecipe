import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard.component';


const routes: Routes = [
  {
    path: '',
    component: DashboardComponent,
    children: [
      { path: '', redirectTo: 'sign-in', pathMatch: 'full' },
    //   { path: 'sign-in', component: SignInComponent, data: { returnUrl: window.location.pathname } },
    //   { path: 'sign-up', component: SignUpComponent },
    //   { path: 'forgot-password', component: ForgotPasswordComponent },
    //   { path: 'new-password', component: NewPasswordComponent },
    //   { path: 'two-steps', component: TwoStepsComponent },
      { path: '**', redirectTo: 'sign-in', pathMatch: 'full' },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DashboardRoutingModule {}
