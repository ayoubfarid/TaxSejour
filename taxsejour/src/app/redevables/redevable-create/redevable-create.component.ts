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
    if (this.redevable().type=='1'){
      this.redevable().type ='personne morale';
    }
    else if(this.redevable().type=='2'){
      this.redevable().type='personne physique';
    }else{
      alert('please select type');
    }
    return this.redevableService.save();
  }
  redevable(){
    return this.redevableService.redevable;
  }

}
