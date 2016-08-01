import { Component, OnInit, Input } from '@angular/core';
import { ROUTER_DIRECTIVES } from '@angular/router';
import { Expense } from './domain/expense';
import { CardService } from './services/card.service';
import { CategoryService } from './services/category.service';
import { ExpenseService } from './services/expense.service';
import { Router } from '@angular/router';
import { Category } from './domain/category';
import { Card } from './domain/card';
import { User } from './domain/user';

@Component({
  selector: 'my-expenses',
  templateUrl: 'app/html/expenses.component.html',
  directives: [ROUTER_DIRECTIVES],
  styleUrls:  ['app/styles/expenses.component.css']
})

export class ExpensesComponent implements OnInit {
  expense: Expense;
  user: User;
  cards:Card[];
  categories:Category[];
  expenses:Expense[];
  @Input() selectedCard: Card;
  @Input() selectedCategory: Category;
  error: any;

  constructor(
    private router: Router,
    private expenseService: ExpenseService,
    private cardService: CardService,
    private categoryService: CategoryService) { }

  getExpenses() {
    this.expenseService.getExpenses().then(expenses => this.expenses = expenses);
  }

  getCards() {
    this.cardService.getCards().then(cards => this.cards = cards);
  }

  getCategories() {
    this.categoryService.getCategories().then(categories => this.categories = categories);
  }

  updateCards(savedCard: Card) {
    if (savedCard) { this.getCards(); }
  }

  updateCategories(savedCategory: Category) {
    if (savedCategory) { this.getCategories(); }
  }

  ngOnInit() {
    this.expense = new Expense();
    this.getExpenses();
    this.getCards();
    this.getCategories();
    this.getDefaultUser();
  }

  getDefaultUser(){
    this.user = new User();
    this.user.userId = '1';
    this.user.userName = 'Hector';
    this.user.password = 'password';
  }

  onSelectCard(card: Card) { this.selectedCard = card; }

  onSelectCategory(category: Category) { this.selectedCategory = category; }

  /*saveExpense() {
    this.expense.card=selectedCard;
    this.expense.category=selectedCategory;
    this.expenseService
        .save(this.expense)
        .then(expese => {
          this.expese = expese
        })
  }*/
}
