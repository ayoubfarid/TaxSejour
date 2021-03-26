import { Component, OnInit } from '@angular/core';
import {CategorieService} from "../../controller/service/categorie.service";
import {Categorie} from "../../controller/model/categorie.model";

@Component({
  selector: 'app-categorie-liste',
  templateUrl: './categorie-liste.component.html',
  styleUrls: ['./categorie-liste.component.css']
})
export class CategorieListeComponent implements OnInit {

  constructor( private categorieseervice :CategorieService ) { }

  ngOnInit(): void {
  }

  get categories(): Array<Categorie> {

    return this.categorieseervice.categories;
  }

}
