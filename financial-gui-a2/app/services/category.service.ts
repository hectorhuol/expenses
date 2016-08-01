import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { Category } from '../domain/category';
import { CATEGORIES } from './mock-categories';

@Injectable()
export class CategoryService {
  private categoriesUrl = 'app/category';  // URL to web api

  constructor(private http: Http) { }

  getCategories(): Promise<Category[]> {
    return Promise.resolve(CATEGORIES);
    //return this.http.get(this.categoriesUrl)
    //           .toPromise()
    //           .then(response => response.json())
    //           .catch(this.handleError);
  }

  /*save(category: Category): Promise<Category>  {
    if (category.categoryId) {
      return this.put(category);
    }
    return this.post(category);
  }

  // Add new Hero
  private post(category: Category): Promise<Category> {
    let headers = new Headers({
      'Content-Type': 'application/json'});
    return this.http
               .post(this.categoriesUrl, JSON.stringify(category), {headers: headers})
               .toPromise()
               .then(res => res.json())
               .catch(this.handleError);
  }

  // Update existing Hero
  private put(category: Category) {
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    let url = `${this.categoriesUrl}/${card.cardId}`;
    return this.http
               .put(url, JSON.stringify(category), {headers: headers})
               .toPromise()
               .then(() => category)
               .catch(this.handleError);
  }

  private handleError(error: any) {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }*/
}
