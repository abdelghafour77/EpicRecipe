import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { SignInComponent } from "./pages/sign-in/sign-in.component";
import { SignUpComponent } from "./pages/sign-up/sign-up.component";
import { ForgotPasswordComponent } from "./pages/forgot-password/forgot-password.component";
import { NewPasswordComponent } from "./pages/new-password/new-password.component";
import { AuthComponent } from "./auth.component";
import { AuthRoutingModule } from "./auth-routing.module";

@NgModule({
	declarations: [SignInComponent, SignUpComponent, ForgotPasswordComponent, NewPasswordComponent, AuthComponent],
	imports: [CommonModule, AuthRoutingModule],
})
export class AuthModule {}
