import { Component, OnInit } from '@angular/core';
import {RedevableListeComponent} from './redevable-liste/redevable-liste.component';
import {RedevableService} from '../controller/service/redevable.service';

@Component({
  selector: 'app-redevables',
  templateUrl: './redevables.component.html',
  styleUrls: ['./redevables.component.css']
})
export class RedevablesComponent implements OnInit {

  constructor(private listservice:RedevableService) { }

  ngOnInit(): void {
  }
}
