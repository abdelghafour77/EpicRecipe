import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Category } from "../models/category";
import { Observable } from "rxjs"; // Add missing import
@Injectable({
	providedIn: "root",
})
export class CategoryService {
	constructor(private http: HttpClient) {}

	private apiUrl = "http://localhost:8888/RECIPE-SERVICE/api/v1/category";

	getCategories(): Observable<Category[]> {
		return this.http.get<Category[]>(this.apiUrl);
	}
}
