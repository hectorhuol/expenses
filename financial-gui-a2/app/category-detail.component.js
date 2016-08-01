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
var category_1 = require('./domain/category');
var router_1 = require('@angular/router');
var category_service_1 = require('./services/category.service');
var CategoryDetailComponent = (function () {
    function CategoryDetailComponent(categoryService, route) {
        this.categoryService = categoryService;
        this.route = route;
        this.updateCategory = new core_1.EventEmitter();
        this.navigated = false; // true if navigated here
    }
    CategoryDetailComponent.prototype.getCategories = function () {
        var _this = this;
        this.categoryService.getCategories().then(function (categories) { return _this.categories = categories; });
    };
    CategoryDetailComponent.prototype.ngOnInit = function () {
        this.category = new category_1.Category();
        this.getCategories();
    };
    __decorate([
        core_1.Output(), 
        __metadata('design:type', Object)
    ], CategoryDetailComponent.prototype, "updateCategory", void 0);
    CategoryDetailComponent = __decorate([
        core_1.Component({
            selector: 'my-category-detail',
            templateUrl: 'app/html/category-detail.component.html',
            styleUrls: ['app/styles/category-detail.component.css']
        }), 
        __metadata('design:paramtypes', [category_service_1.CategoryService, router_1.ActivatedRoute])
    ], CategoryDetailComponent);
    return CategoryDetailComponent;
}());
exports.CategoryDetailComponent = CategoryDetailComponent;
//# sourceMappingURL=category-detail.component.js.map