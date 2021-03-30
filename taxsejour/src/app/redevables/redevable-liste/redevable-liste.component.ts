import { Component, OnInit } from '@angular/core';
import {Typeredevable} from "../../controller/model/typeredevable.model";
import {RedevableService} from "../../controller/service/redevable.service";
import {Redevable} from "../../controller/model/redevable.model";

@Component({
  selector: 'app-redevable-liste',
  templateUrl: './redevable-liste.component.html',
  styleUrls: ['./redevable-liste.component.css']
})
export class RedevableListeComponent implements OnInit {

  constructor(private  redevableService:RedevableService) { }

  ngOnInit(): void {
    return this.redevableService.findAll();
  }
  public edit(c:Redevable , i :number) {
    return this.redevableService.edit(c,i);
  }

  public delete(c :Redevable , i :number) {
    return this.redevableService.delete(c,i);
  }
  get redvableList(): Array<Redevable> {

    return this.redevableService.redevabllist;
  }

}
