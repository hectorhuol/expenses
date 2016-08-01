import { Component, EventEmitter, Input, OnInit, OnDestroy, Output } from '@angular/core';
import { Category } from './domain/category';
import { ActivatedRoute } from '@angular/router';
import { CategoryService } from './services/category.service';

@Component({
  selector: 'my-category-detail',
  templateUrl: 'app/html/category-detail.component.html',
  styleUrls: ['app/styles/category-detail.component.css']
})

export class CategoryDetailComponent implements OnInit {
  category: Category;
  categories: Category[];
  @Output() updateCategory = new EventEmitter();
  error: any;
  sub: any;
  navigated = false; // true if navigated here

  constructor(private categoryService: CategoryService, private route: ActivatedRoute) {
  }

  getCategories() {
    this.categoryService.getCategories().then(categories => this.categories = categories);
  }

  ngOnInit() {
    this.category = new Category();
    this.getCategories();
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
