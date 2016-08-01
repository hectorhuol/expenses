import { Component, EventEmitter, Input, OnInit, OnDestroy, Output } from '@angular/core';
import { Card } from './domain/card';
import { CardType } from './domain/card-type';
import { ActivatedRoute } from '@angular/router';
import { CardService } from './services/card.service';

@Component({
  selector: 'my-card-detail',
  templateUrl: 'app/html/card-detail.component.html',
  styleUrls: ['app/styles/card-detail.component.css']
})

export class CardDetailComponent implements OnInit {
  card: Card;
  cards: Card[];
  types: string[] = [CardType[CardType.DEBIT],CardType[CardType.CREDIT]];
  selectedType: string;
  @Output() updateCard = new EventEmitter();
  error: any;
  sub: any;
  navigated = false; // true if navigated here

  constructor(private cardService: CardService, private route: ActivatedRoute) {
  }

  getCards() {
    this.cardService.getCards().then(cards => this.cards = cards);
  }

  ngOnInit() {
    this.card = new Card();
    this.getCards();
  }

  onSelectCardType(type:string){
    this.selectedType = type;
  }

  /*save() {
    this.card.cardType=selectedType;
    this.cardService
        .save(this.card)
        .then(card => {
          this.card = card;
          this.updateCard.emit(card);
        })
        .catch(error => this.error = error);
  }*/
}
