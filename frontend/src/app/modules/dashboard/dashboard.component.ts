import { Component, OnInit } from "@angular/core";
import { Flowbite } from "app/core/config/flowbiteConfig";
import { initFlowbite } from "flowbite";

@Component({
	selector: "app-dashboard",
	templateUrl: "./dashboard.component.html",
	styleUrl: "./dashboard.component.css",
})
@Flowbite()
export class DashboardComponent implements OnInit {
	constructor() {}

	ngOnInit() {
		initFlowbite();
	}
}
