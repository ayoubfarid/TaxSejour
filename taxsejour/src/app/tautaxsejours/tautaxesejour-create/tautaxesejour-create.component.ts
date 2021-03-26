import { Component, OnInit } from '@angular/core';
import {TautaxsejourService} from "../../controller/service/tautaxsejour.service";
import {Tautaxesejour} from "../../controller/model/tautaxesejour.model";
import {CategorieService} from "../../controller/service/categorie.service";
import {Categorie} from "../../controller/model/categorie.model";
@Component({
  selector: 'app-tautaxesejour-create',
  templateUrl: './tautaxesejour-create.component.html',
  styleUrls: ['./tautaxesejour-create.component.css']
})
export class TautaxesejourCreateComponent implements OnInit {


  constructor(private tautaxesejourservice :  TautaxsejourService,private categorieservice : CategorieService) { }

  ngOnInit(): void {
  this.categorieservice.findAll();
    this.tautaxesejourservice.findAll();
  }

 public save(){

    this.tautaxesejourservice.save();
 }
  get tautaxesejour(): Tautaxesejour {
    return this.tautaxesejourservice.tautaxesejour;
  }


  get categories(): Array<Categorie> {
    return this.categorieservice.categories;
  }








}
