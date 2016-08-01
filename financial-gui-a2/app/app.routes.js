"use strict";
var router_1 = require('@angular/router');
var expenses_component_1 = require('./expenses.component');
var card_detail_component_1 = require('./card-detail.component');
var category_detail_component_1 = require('./category-detail.component');
var routes = [
    {
        path: '',
        redirectTo: '/expenses',
        pathMatch: 'full'
    },
    {
        path: 'expenses',
        component: expenses_component_1.ExpensesComponent
    },
    {
        path: 'cards',
        component: card_detail_component_1.CardDetailComponent
    },
    { path: 'categories',
        component: category_detail_component_1.CategoryDetailComponent
    }
];
exports.appRouterProviders = [
    router_1.provideRouter(routes)
];
//# sourceMappingURL=app.routes.js.map