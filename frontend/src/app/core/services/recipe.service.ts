import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { Recipe } from '../models/recipe';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  // private apiUrl = 'http://localhost:8888/RECIPE-SERVICE/api/v1/recipes';
  private apiUrl = 'http://localhost:8081/api/v1/recipes';

  constructor(private http: HttpClient) {}

  getUsers(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.apiUrl);
  }
}
