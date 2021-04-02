import { Component, OnInit } from '@angular/core';
import {TyperedevableService} from "../controller/service/typeredevable.service";
@Component({
  selector: 'app-typesredevable',
  templateUrl: './typesredevable.component.html',
  styleUrls: ['./typesredevable.component.css']
})
export class TypesredevableComponent implements OnInit {

  constructor(private  typeservice:TyperedevableService) { }

  ngOnInit(): void {
  }


}
