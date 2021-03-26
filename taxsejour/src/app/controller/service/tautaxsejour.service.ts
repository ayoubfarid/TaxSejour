import { Injectable } from '@angular/core';
import {Tautaxesejour} from "../model/tautaxesejour.model";
import { Categorie } from "../model/categorie.model";
import {HttpClient} from "@angular/common/http";
import {CategorieService} from "./categorie.service";
@Injectable({
  providedIn: 'root'
})
export class TautaxsejourService {

  private _tautaxesejour: Tautaxesejour;
  private _tautaxesejours: Array<Tautaxesejour>;
  private _index: number;

  constructor( private http:HttpClient  ) {

  }

  public delete(index:number)
  {
    this.http.delete<void>('http://localhost:8039/gestiontaxesejour/tautaxesejour/id/'+this.tautaxesejours[index].id).subscribe(
      data=>{


          this.tautaxesejours.splice(index,1);
      }
    );


  }

  public update(tautaxsejour:Tautaxesejour,index: number)
  {
    this.tautaxesejour = this.clone(tautaxsejour);
    this._index = index ;
  }
  /*
  public save(){
    if( this.tautaxesejour.id == null )
    {
      this.tautaxesejour.id = this.tautaxesejours.length+1;
      this.tautaxesejours.push(this.clone(this.tautaxesejour));

    }else{
  this.tautaxesejours[this._index] = this.clone(this.tautaxesejour);

    }
    this.tautaxesejour = null ;
  }*/



  public save(){
    console.log(this.tautaxesejour);
    if( this.tautaxesejour.id == null )
    {
     this.http.post<number>('http://localhost:8039/gestiontaxesejour/',this.tautaxesejour).subscribe(
      data=>{
        if ( data > 0 ){
          this.tautaxesejour.id = this.tautaxesejours.length+1;
          this._tautaxesejours.push(this.clone(this.tautaxesejour));
        }
         },error=>{
             console.log('Error');
           }
   );
    }else{
      this.tautaxesejours[this._index] = this.clone(this.tautaxesejour);

    }
    this._tautaxesejour = null ;
  }

  public findAll(){
    this.http.get<Array<Tautaxesejour>>('http://localhost:8039/gestiontaxesejour/tautaxesejour').subscribe(
      data=>{

        console.log(data);

        this.tautaxesejours = data ;

      },error=>{
        console.log('Error');
      }
    );

  }
  get tautaxesejour(): Tautaxesejour {
    if( this._tautaxesejour == null )
    this._tautaxesejour = new Tautaxesejour();
    return this._tautaxesejour;
  }
  /*public delete(index:number)
  {
    this.tautaxesejours.slice(index,1);
  }*/


  set tautaxesejour(value: Tautaxesejour) {
    this._tautaxesejour = value;
  }


  get tautaxesejours(): Array<Tautaxesejour> {
    if ( this._tautaxesejours == null)
      this._tautaxesejours = new Array<Tautaxesejour>();

    return this._tautaxesejours;
  }

  set tautaxesejours(value: Array<Tautaxesejour>) {
    this._tautaxesejours = value;
  }


  private clone(tautaxesejour: Tautaxesejour)  {
    console.log(tautaxesejour);
    const  myClone = new Tautaxesejour();
    myClone.montantNuite = tautaxesejour.montantNuite;
    myClone.id = tautaxesejour.id;
    myClone.categorie.ref= tautaxesejour.categorie.ref;

    return myClone;
  }
}
