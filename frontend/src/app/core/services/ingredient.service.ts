import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Ingredient } from "../models/ingredient";
import { HttpClient, HttpHeaders } from "@angular/common/http";

const httpOptions = {
	headers: new HttpHeaders({ "Content-Type": "application/json" }),
};

@Injectable({
	providedIn: "root",
})
export class IngredientService {
	constructor(private http: HttpClient) {}

	private apiUrl = "http://localhost:8888/RECIPE-SERVICE/api/v1/ingredient";

	getAllIngredients(): Observable<Ingredient[]> {
		return this.http.get<Ingredient[]>(this.apiUrl);
	}

	create(ingredient: Ingredient): Observable<Ingredient> {
		return this.http.post<Ingredient>(this.apiUrl + "/save", ingredient, httpOptions);
	}

	update(ingredient: Ingredient): Observable<Ingredient> {
		return this.http.put<Ingredient>(this.apiUrl + "/" + ingredient?.id + "/update", ingredient, httpOptions);
	}

	delete(ingredient: Ingredient): Observable<Ingredient> {
		return this.http.delete<Ingredient>(this.apiUrl + "/" + ingredient?.id + "/delete", httpOptions);
	}
}
