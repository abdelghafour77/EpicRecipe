import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Recipe } from "../models/recipe";

@Injectable({
	providedIn: "root",
})
export class RecipeService {
	constructor(private http: HttpClient) {}

	private apiUrl = "http://localhost:8888/RECIPE-SERVICE/api/v1/recipes";

	getTopRecipes(): Observable<Recipe[]> {
		return this.http.get<Recipe[]>(this.apiUrl + "/top/3");
	}

	getRecipeById(id: string): Observable<Recipe> {
		return this.http.get<Recipe>(this.apiUrl + "/" + id);
	}

	getAllRecipes(): Observable<Recipe[]> {
		return this.http.get<Recipe[]>(this.apiUrl);
	}
	saveRecipe(recipe: Recipe): Observable<Recipe> {
		console.log("Recipe to save from service :", recipe);
		return this.http.post<Recipe>(this.apiUrl, recipe);
	}
	uploadFile(formData: FormData): Observable<any> {
		return this.http.post<any>(this.apiUrl + "/upload", formData);
	}
}
