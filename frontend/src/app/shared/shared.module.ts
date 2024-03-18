import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { NavbarComponent } from "./components/navbar/navbar.component";
import { FooterComponent } from "./components/footer/footer.component";
import { SpeedDialComponent } from "./components/speed-dial/speed-dial.component";
import { CategoryComponent } from "./components/category/category.component";
import { RouterModule } from "@angular/router";

@NgModule({
	declarations: [NavbarComponent, FooterComponent, SpeedDialComponent, CategoryComponent],
	imports: [CommonModule, RouterModule],
	exports: [NavbarComponent, FooterComponent, SpeedDialComponent, CategoryComponent],
})
export class SharedModule {}
