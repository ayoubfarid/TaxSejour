import { Injectable } from '@angular/core';
import { Categorie } from "../model/categorie.model";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {findAll} from "@angular/compiler-cli/ngcc/src/utils";

@Injectable({
  providedIn: 'root'
})
export class CategorieService {


  private _categorie : Categorie;
  private _categories : Array<Categorie>;

  constructor(private http:HttpClient ) { }


  public save(){
    this.http.post<String>('http://localhost:8039/redevable/cate/Categorie',this.categorie).subscribe(
      data=>{
        if ( data == '' )
        console.log(data);
      this._categories.push(this.clone(this.categorie));
      this._categorie = null ;

    },error=>{
        console.log('Error');
      }
    );

  }

  public findAll() {
    this.http.get<Array<Categorie>>('http://localhost:8039/redevable/cate/Categorie').subscribe(
      data=>{

          console.log(data);

        this.categories = data ;


      },error=>{
        console.log('Error');
      }
    );

  }

  get categorie(): Categorie {
    if( this._categorie == null  )
      this._categorie = new Categorie();
    return this._categorie;
  }

  set categorie(value: Categorie) {
    this._categorie = value;
  }
  get categories(): Array<Categorie> {
    if ( this._categories == null)
      this._categories = new Array<Categorie>();

    return this._categories;
  }
  /*get categories(): Array<Categorie> {
    if ( this._categories == null)
      this._categories = new Array<Categorie>();

    return this.http<Array<Categorie>>>.get('http://localhost:8039/redevable/cate/Categorie');
  }*/

  set categories(value: Array<Categorie>) {
    this._categories = value;
  }


  private clone(categorie: Categorie) {
    const  myClone = new Categorie();
    myClone.ref = categorie.ref;
    myClone.libelle = categorie.libelle ;
    myClone.id = categorie.id;
    return myClone;
  }
}
