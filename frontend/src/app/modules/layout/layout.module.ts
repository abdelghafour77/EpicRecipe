import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutComponent } from './layout.component';
import { FooterComponent } from './components/footer/footer.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { BottomNavbarComponent } from './components/bottom-navbar/bottom-navbar.component';



@NgModule({
  declarations: [
    LayoutComponent,
    FooterComponent,
    NavbarComponent,
    SidebarComponent,
    BottomNavbarComponent
  ],
  imports: [
    CommonModule
  ]
})
export class LayoutModule { }
