import { Component, OnInit } from '@angular/core';
import {TyperedevableService} from "../../controller/service/typeredevable.service";
import {RedevableService} from "../../controller/service/redevable.service";

@Component({
  selector: 'app-redevable-create',
  templateUrl: './redevable-create.component.html',
  styleUrls: ['./redevable-create.component.css']
})
export class RedevableCreateComponent implements OnInit {

  constructor(private redevableService: RedevableService) {
  }

  ngOnInit(): void {

  }

  public save() {
    return this.redevableService.save();
  }
  redevable(){
    return this.redevableService.redevable;
  }

}
