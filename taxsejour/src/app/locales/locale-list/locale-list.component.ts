import { Component, OnInit } from '@angular/core';
import {LocaleService} from '../../controller/service/locale.service';
import {Locale} from '../../controller/model/locale.model';

@Component({
  selector: 'app-locale-list',
  templateUrl: './locale-list.component.html',
  styleUrls: ['./locale-list.component.css']
})
export class LocaleListComponent implements OnInit {

  constructor(private localService: LocaleService) { }

  get locales(): Array<Locale>{
    return this.localService.locales;
  }

  public delete(index: number){
    this.locales.splice(index, 1);
  }

  public update(index: number, locale: Locale){
    this.localService.update(index, locale);
  }

  ngOnInit(): void {
  }

}
