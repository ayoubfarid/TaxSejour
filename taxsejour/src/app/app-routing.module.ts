import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {Redevable} from './controller/model/redevable.model';
import {RedevablesComponent} from './redevables/redevables.component';
import {TypesredevableComponent} from './typesredevable/typesredevable.component';
import {CategoriesComponent} from './categories/categories.component';
import {DashboardComponent} from './dashboard/dashboard.component';

const routes: Routes = [
  {path: 'dashboard', component: DashboardComponent},
  {path: 'Redevable', component: RedevablesComponent},
  {path: 'Categorie', component: CategoriesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}

export const routingComponent = [DashboardComponent, TypesredevableComponent, RedevablesComponent, CategoriesComponent];
