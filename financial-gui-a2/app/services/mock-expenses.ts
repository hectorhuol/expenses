import { CardType } from '../domain/card-type';
import { Expense } from '../domain/expense';

export const EXPENSES: Expense[] = [
  {expenseId: '11', value: 10.0, dateAndHour:'18/07/2016', companions:[], card: {cardId: '12', name: 'DAVIVIENDA', cardType: CardType.CREDIT}, category: {categoryId: '11', name: 'RENT'}, user:null, location:'location', city:'city'},
  {expenseId: '12', value: 10.0, dateAndHour:'18/07/2016', companions:[], card: {cardId: '12', name: 'DAVIVIENDA', cardType: CardType.CREDIT}, category: {categoryId: '12', name: 'FOOD'}, user:null, location:'location', city:'city'}
];
