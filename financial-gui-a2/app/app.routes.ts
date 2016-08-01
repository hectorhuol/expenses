import { provideRouter, RouterConfig }  from '@angular/router';
import { ExpensesComponent } from './expenses.component';
import { CardDetailComponent } from './card-detail.component';
import { CategoryDetailComponent } from './category-detail.component';

const routes: RouterConfig = [
  {
    path: '',
    redirectTo: '/expenses',
    pathMatch: 'full'
  },
  {
    path: 'expenses',
    component: ExpensesComponent
  },
  {
    path: 'cards',
    component: CardDetailComponent
  },
  { path: 'categories',
    component: CategoryDetailComponent
  }
];

export const appRouterProviders = [
  provideRouter(routes)
];
