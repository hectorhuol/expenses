import { Companion }     from './companion'
import { Card }     from './card'
import { Category }     from './category'
import { User }     from './user'

export class Expense {
  expenseId:string;
  value:number;
  dateAndHour:string;
  companions:Array<Companion>;
  card:Card;
  category:Category;
  user:User;
  location:string;
  city:string;
}
