import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Ingredient } from "../models/ingredient";
import { HttpClient } from "@angular/common/http";

@Injectable({
	providedIn: "root",
})
export class IngredientService {
	constructor(private http: HttpClient) {}

	private apiUrl = "http://localhost:8888/RECIPE-SERVICE/api/v1/ingredient";

	getAllIngredients(): Observable<Ingredient[]> {
		return this.http.get<Ingredient[]>(this.apiUrl);
	}
}
