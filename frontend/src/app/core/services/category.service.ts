import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Category } from "../models/category";
import { Observable } from "rxjs";
@Injectable({
	providedIn: "root",
})
export class CategoryService {
	constructor(private http: HttpClient) {}

	private apiUrl = "http://localhost:8888/RECIPE-SERVICE/api/v1/category";

	getCategories(): Observable<Category[]> {
		return this.http.get<Category[]>(this.apiUrl);
	}

	saveCategory(category: Category): Observable<Category> {
		return this.http.post<Category>(this.apiUrl, category);
	}
	uploadFile(formData: FormData): Observable<any> {
		return this.http.post<any>(this.apiUrl + "/upload", formData);
	}
}
