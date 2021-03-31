import { Component, OnInit } from '@angular/core';
import {Locale} from '../../controller/model/locale.model';
import {LocaleService} from '../../controller/service/locale.service';

@Component({
  selector: 'app-locale-create',
  templateUrl: './locale-create.component.html',
  styleUrls: ['./locale-create.component.css']
})
export class LocaleCreateComponent implements OnInit {

  constructor(private localeService: LocaleService) { }

  ngOnInit(): void {
  }

  public save() {
    return this.localeService.save();
  }
  public validateSave() {
    return this.localeService.validateSave();
  }
  get locale(): Locale{
    return this.localeService.locale;
  }
}
