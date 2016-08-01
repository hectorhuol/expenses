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
var card_1 = require('./domain/card');
var card_type_1 = require('./domain/card-type');
var router_1 = require('@angular/router');
var card_service_1 = require('./services/card.service');
var CardDetailComponent = (function () {
    function CardDetailComponent(cardService, route) {
        this.cardService = cardService;
        this.route = route;
        this.types = [card_type_1.CardType[card_type_1.CardType.DEBIT], card_type_1.CardType[card_type_1.CardType.CREDIT]];
        this.updateCard = new core_1.EventEmitter();
        this.navigated = false; // true if navigated here
    }
    CardDetailComponent.prototype.getCards = function () {
        var _this = this;
        this.cardService.getCards().then(function (cards) { return _this.cards = cards; });
    };
    CardDetailComponent.prototype.ngOnInit = function () {
        this.card = new card_1.Card();
        this.getCards();
    };
    CardDetailComponent.prototype.onSelectCardType = function (type) {
        this.selectedType = type;
    };
    __decorate([
        core_1.Output(), 
        __metadata('design:type', Object)
    ], CardDetailComponent.prototype, "updateCard", void 0);
    CardDetailComponent = __decorate([
        core_1.Component({
            selector: 'my-card-detail',
            templateUrl: 'app/html/card-detail.component.html',
            styleUrls: ['app/styles/card-detail.component.css']
        }), 
        __metadata('design:paramtypes', [card_service_1.CardService, router_1.ActivatedRoute])
    ], CardDetailComponent);
    return CardDetailComponent;
}());
exports.CardDetailComponent = CardDetailComponent;
//# sourceMappingURL=card-detail.component.js.map