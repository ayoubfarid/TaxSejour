import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import {AppRoutingModule, routingComponent} from './app-routing.module';
import { AppComponent } from './app.component';
import { TautaxsejoursComponent } from './tautaxsejours/tautaxsejours.component';
import { TautaxesejourListeComponent } from './tautaxsejours/tautaxesejour-liste/tautaxesejour-liste.component';
import { TautaxesejourCreateComponent } from './tautaxsejours/tautaxesejour-create/tautaxesejour-create.component';
import {FormsModule} from "@angular/forms";
import { CategoriesComponent } from './categories/categories.component';
import { CategorieCreateComponent } from './categories/categorie-create/categorie-create.component';
import { CategorieListeComponent } from './categories/categorie-liste/categorie-liste.component';
import {HttpClientModule} from '@angular/common/http';
import { RedevablesComponent } from './redevables/redevables.component';
import { RedevableCreateComponent } from './redevables/redevable-create/redevable-create.component';
import { RedevableListeComponent } from './redevables/redevable-liste/redevable-liste.component';
import { TypesredevableComponent } from './typesredevable/typesredevable.component';
import { TyperedevableCreateComponent } from './typesredevable/typeredevable-create/typeredevable-create.component';
import { TyperedevableListComponent } from './typesredevable/typeredevable-list/typeredevable-list.component';
import { LocalesComponent } from './locales/locales.component';
import { LocaleCreateComponent } from './locales/locale-create/locale-create.component';
import { LocaleListComponent } from './locales/locale-list/locale-list.component';
import { TaxesejourCreateComponent } from './taxesejours/taxesejour-create/taxesejour-create.component';
import { TaxesejourListComponent } from './taxesejours/taxesejour-list/taxesejour-list.component';
import { DashboardComponent } from './dashboard/dashboard.component';

@NgModule({
    declarations: [
        AppComponent,
        TautaxsejoursComponent,
        TautaxesejourListeComponent,
        TautaxesejourCreateComponent,
        LocalesComponent,
        LocaleCreateComponent,
        LocaleListComponent,
        TaxesejourCreateComponent,
        TaxesejourListComponent,
        routingComponent,
        RedevableCreateComponent,
        RedevableListeComponent,
        TyperedevableCreateComponent,
        CategorieCreateComponent,
        CategorieListeComponent,
        TyperedevableListComponent,
        DashboardComponent

    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
