"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var router_1 = require('@angular/router');
var expense_1 = require('./domain/expense');
var card_service_1 = require('./services/card.service');
var category_service_1 = require('./services/category.service');
var expense_service_1 = require('./services/expense.service');
var router_2 = require('@angular/router');
var category_1 = require('./domain/category');
var card_1 = require('./domain/card');
var user_1 = require('./domain/user');
var ExpensesComponent = (function () {
    function ExpensesComponent(router, expenseService, cardService, categoryService) {
        this.router = router;
        this.expenseService = expenseService;
        this.cardService = cardService;
        this.categoryService = categoryService;
    }
    ExpensesComponent.prototype.getCards = function () {
        var _this = this;
        this.cardService.getCards().then(function (cards) { return _this.cards = cards; });
    };
    ExpensesComponent.prototype.getCategories = function () {
        var _this = this;
        this.categoryService.getCategories().then(function (categories) { return _this.categories = categories; });
    };
    ExpensesComponent.prototype.updateCards = function (savedCard) {
        if (savedCard) {
            this.getCards();
        }
    };
    ExpensesComponent.prototype.updateCategories = function (savedCategory) {
        if (savedCategory) {
            this.getCategories();
        }
    };
    ExpensesComponent.prototype.ngOnInit = function () {
        this.expense = new expense_1.Expense();
        this.getCards();
        this.getCategories();
        this.getDefaultUser();
    };
    ExpensesComponent.prototype.getDefaultUser = function () {
        this.user = new user_1.User();
        this.user.userId = '1';
        this.user.userName = 'Hector';
        this.user.password = 'password';
    };
    ExpensesComponent.prototype.onSelectCard = function (card) { this.selectedCard = card; };
    ExpensesComponent.prototype.onSelectCategory = function (category) { this.selectedCategory = category; };
    __decorate([
        core_1.Input(), 
        __metadata('design:type', card_1.Card)
    ], ExpensesComponent.prototype, "selectedCard", void 0);
    __decorate([
        core_1.Input(), 
        __metadata('design:type', category_1.Category)
    ], ExpensesComponent.prototype, "selectedCategory", void 0);
    ExpensesComponent = __decorate([
        core_1.Component({
            selector: 'my-expenses',
            templateUrl: 'app/html/expenses.component.html',
            directives: [router_1.ROUTER_DIRECTIVES],
            styleUrls: ['app/styles/expenses.component.css']
        }), 
        __metadata('design:paramtypes', [router_2.Router, expense_service_1.ExpenseService, card_service_1.CardService, category_service_1.CategoryService])
    ], ExpensesComponent);
    return ExpensesComponent;
}());
exports.ExpensesComponent = ExpensesComponent;
//# sourceMappingURL=expenses.component.js.map