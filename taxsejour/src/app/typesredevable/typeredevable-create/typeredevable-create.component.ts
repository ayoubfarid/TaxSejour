import {Component, OnInit} from '@angular/core';
import {TyperedevableService} from "../../controller/service/typeredevable.service";
import {Typeredevable} from "../../controller/model/typeredevable.model";

@Component({
  selector: 'app-typeredevable-create',
  templateUrl: './typeredevable-create.component.html',
  styleUrls: ['./typeredevable-create.component.css']
})
export class TyperedevableCreateComponent implements OnInit {

  constructor(private typeservice: TyperedevableService) {
  }

  ngOnInit(): void {

  }

  public save() {
    return this.typeservice.save();
  }
 type(){
    return this.typeservice.type;
 }
}
