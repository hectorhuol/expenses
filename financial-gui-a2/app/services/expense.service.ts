import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { Expense } from '../domain/expense';
import { EXPENSES } from './mock-expenses'

@Injectable()
export class ExpenseService {
  private expensesUrl = 'app/expense';  // URL to web api

  constructor(private http: Http) { }

  getExpenses(): Promise<Expense[]> {
    return Promise.resolve(EXPENSES);
    //return this.http.get(this.expensesUrl)
    //           .toPromise()
    //           .then(response => response.json())
    //           .catch(this.handleError);
  }

  /*save(expense: Expense): Promise<Expense>  {
    if (expense.expenseId) {
      return this.put(expense);
    }
    return this.post(expense);
  }

  // Add new Hero
  private post(expense: Expense): Promise<Expense> {
    let headers = new Headers({
      'Content-Type': 'application/json'});
    return this.http
               .post(this.expensesUrl, JSON.stringify(expense), {headers: headers})
               .toPromise()
               .then(res => res.json())
               .catch(this.handleError);
  }

  // Update existing Hero
  private put(expense: Expense) {
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    let url = `${this.expensesUrl}/${expense.expenseId}`;
    return this.http
               .put(url, JSON.stringify(expense), {headers: headers})
               .toPromise()
               .then(() => expense)
               .catch(this.handleError);
  }

  private handleError(error: any) {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }*/
}
