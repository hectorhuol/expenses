import { Component } from '@angular/core';
import { ROUTER_DIRECTIVES } from '@angular/router';
import { ExpenseService }     from './services/expense.service';
import { CardService }     from './services/card.service';
import { CategoryService }     from './services/category.service';

@Component({
  selector: 'expenses-app',
  templateUrl: 'app/html/app.component.html',
  directives: [ROUTER_DIRECTIVES],
  providers: [ExpenseService, CardService, CategoryService],
  styleUrls: ['app/styles/app.component.css']
})
export class AppComponent {
  title = 'My Expenses Tracking Tool';
}
