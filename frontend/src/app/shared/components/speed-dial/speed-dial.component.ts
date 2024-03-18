import { Component } from "@angular/core";
import { Location } from "@angular/common";

@Component({
	selector: "app-speed-dial",
	templateUrl: "./speed-dial.component.html",
	styleUrl: "./speed-dial.component.css",
})
export class SpeedDialComponent {
	currentUrl: string;

	constructor(private location: Location) {
		this.currentUrl = window.location.href;
	}
	printPage() {
		window.print();
	}
}
