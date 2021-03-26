import { Component, OnInit } from '@angular/core';
import {Tautaxesejour} from "../../controller/model/tautaxesejour.model";
import {TautaxsejourService} from "../../controller/service/tautaxsejour.service";

@Component({
  selector: 'app-tautaxesejour-liste',
  templateUrl: './tautaxesejour-liste.component.html',
  styleUrls: ['./tautaxesejour-liste.component.css']
})
export class TautaxesejourListeComponent implements OnInit {
  private _refcat:String;
  constructor( private tautaxesejourservice : TautaxsejourService ) { }

  ngOnInit(): void {
    this.tautaxesejourservice.findAll();
  }
  public delete(index:number)
  {
    this.tautaxesejourservice.delete(index);

  }
  get tautaxesejours(): Array<Tautaxesejour> {
    return this.tautaxesejourservice.tautaxesejours ;
  }
  public update(tautaxsejour:Tautaxesejour,index: number)
  {
    this.tautaxesejourservice.update(tautaxsejour,index);


  }
}
