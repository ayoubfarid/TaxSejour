import { Component, OnInit } from '@angular/core';
import {CategorieService} from "../../controller/service/categorie.service";
import {Categorie} from "../../controller/model/categorie.model";

@Component({
  selector: 'app-categorie-create',
  templateUrl: './categorie-create.component.html',
  styleUrls: ['./categorie-create.component.css']
})
export class CategorieCreateComponent implements OnInit {

  constructor( private categorieseervice :CategorieService ) { }

  ngOnInit(): void {
  }
  public save(){
    this.categorieseervice.save() ;
  }
  get categorie(): Categorie {

    return this.categorieseervice.categorie;
  }


}
