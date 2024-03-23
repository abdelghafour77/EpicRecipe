import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Tag } from "../models/tag";
import { Observable } from "rxjs";

@Injectable({
	providedIn: "root",
})
export class TagService {
	constructor(private http: HttpClient) {}

	private apiUrl = "http://localhost:8888/RECIPE-SERVICE/api/v1/tag";

	getAllTags(): Observable<Tag[]> {
		return this.http.get<Tag[]>(this.apiUrl);
	}
}
