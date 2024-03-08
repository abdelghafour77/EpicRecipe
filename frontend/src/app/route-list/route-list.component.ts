import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-route-list',
  templateUrl: './route-list.component.html',
  styleUrl: './route-list.component.css'
})
export class RouteListComponent {
  routes: any[];

  constructor(private router: Router) {
    this.routes = this.router.config;
  }
}
