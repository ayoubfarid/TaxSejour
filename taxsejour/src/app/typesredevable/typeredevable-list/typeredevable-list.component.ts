import { Component, OnInit } from '@angular/core';
import {TyperedevableService} from "../../controller/service/typeredevable.service";
import {Typeredevable} from "../../controller/model/typeredevable.model";

@Component({
  selector: 'app-typeredevable-list',
  templateUrl: './typeredevable-list.component.html',
  styleUrls: ['./typeredevable-list.component.css']
})
export class TyperedevableListComponent implements OnInit {

  constructor(private  typeservice:TyperedevableService) { }

  ngOnInit(): void {
    return this.typeservice.findAll();
  }
  public edit(c:Typeredevable , i :number) {
    return this.typeservice.edit(c,i);
  }

  public delete(c :Typeredevable , i :number) {
    return this.typeservice.delete(c,i);
  }
  get typeList(): Array<Typeredevable> {

    return this.typeservice.typeList;
  }

}
