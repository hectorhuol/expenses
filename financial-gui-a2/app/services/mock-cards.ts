import { Card } from '../domain/card';
import { CardType } from '../domain/card-type';

export const CARDS: Card[] = [
  {cardId: '11', name: 'BANCOLOMBIA', cardType: CardType.DEBIT},
  {cardId: '12', name: 'DAVIVIENDA', cardType: CardType.CREDIT}
];
