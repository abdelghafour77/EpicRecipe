import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { NavbarComponent } from "./components/navbar/navbar.component";
import { FooterComponent } from "./components/footer/footer.component";
import { SpeedDialComponent } from "./components/speed-dial/speed-dial.component";
import { CategoryComponent } from "./components/category/category.component";
import { RouterModule } from "@angular/router";
import { FileDragNDropDirective } from "./directives/file-drag-n-drop.directive";
import { DragAndDropComponent } from "./components/drag-and-drop/drag-and-drop.component";
import { ProgressComponent } from "./components/progress/progress.component";

@NgModule({
	declarations: [
		NavbarComponent,
		FooterComponent,
		SpeedDialComponent,
		CategoryComponent,
		FileDragNDropDirective,
		DragAndDropComponent,
		ProgressComponent,
	],
	imports: [CommonModule, RouterModule],
	exports: [NavbarComponent, FooterComponent, SpeedDialComponent, CategoryComponent, FileDragNDropDirective, DragAndDropComponent, ProgressComponent],
})
export class SharedModule {}
