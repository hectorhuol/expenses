import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { Card } from '../domain/card';
import { CARDS } from './mock-cards';

@Injectable()
export class CardService {
  //private cardsUrl = 'app/card';  // URL to web api

  constructor(private http: Http) { }

  getCards(): Promise<Card[]> {
    return Promise.resolve(CARDS);
    //return this.http.get(this.cardsUrl)
    //           .toPromise()
    //           .then(response => response.json())
    //           .catch(this.handleError);
  }

  /*save(card: Card): Promise<Card>  {
    if (card.cardId) {
      return this.put(card);
    }
    return this.post(card);
  }

  // Add new Hero
  private post(card: Card): Promise<Card> {
    let headers = new Headers({
      'Content-Type': 'application/json'});
    return this.http
               .post(this.cardsUrl, JSON.stringify(card), {headers: headers})
               .toPromise()
               .then(res => res.json())
               .catch(this.handleError);
  }

  // Update existing Hero
  private put(card: Card) {
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    let url = `${this.cardsUrl}/${card.cardId}`;
    return this.http
               .put(url, JSON.stringify(card), {headers: headers})
               .toPromise()
               .then(() => card)
               .catch(this.handleError);
  }

  private handleError(error: any) {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }*/
}
