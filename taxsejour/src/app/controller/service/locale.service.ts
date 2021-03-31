
import { Injectable } from '@angular/core';
import {Local} from 'protractor/built/driverProviders';
import {Locale} from '../model/locale.model';
import {HttpClient} from "@angular/common/http";


@Injectable({
  providedIn: 'root'
})
export class LocaleService {

  private _locale: Locale;
  private _locales: Array<Locale>;
  private _id: number;

  constructor(private http: HttpClient)  { }


  public save() {

    this.http.post<number>('http://localhost:8039/locale-api/monlocale/', this.locale).subscribe(
      data => {
        if (data > 0) {
          if (this.locale.id == null){
            this.locale.id = this.locales.length + 1;
            this.locales.push(this.myClone(this.locale));
          }else {
            this.locales[this._id] = this.myClone(this.locale);
          }
          this.locale = null;
        }
      }, error => {
        console.log('error');
      }
    );

  }

  public myClone(locale: Locale) {
    const cloneLocal = new Locale();
    cloneLocal.id = locale.id;
    cloneLocal.reference = locale.reference;
    cloneLocal.adresse = locale.adresse;
    cloneLocal.rue = locale.rue;
    cloneLocal.refRedevable = locale.refRedevable;
    cloneLocal.refCategorie = locale.refCategorie;
    return cloneLocal;
  }


  public update(index: number, locale: Locale) {
    this.locale = this.myClone(locale);
    this._id = index;
  }

  public validateSave(): boolean {
    return this.locale.reference != null && this.locale.refRedevable != null && this.locale.refCategorie != null
      &&
      this.locale.reference != '' && this.locale.refRedevable != '' && this.locale.refCategorie != '' && this.locale.rue != '';
  }

  public monInit() {
    for (let i = 0; i < 5; i++) {
      const mylocale = new Locale();
      mylocale.id = i + 1;
      mylocale.reference = 'L-' + i + 1;
      mylocale.adresse = 'marakech';
      mylocale.rue = 'marakech' + (i + 1) * 3;
      mylocale.refRedevable = 'R-' + (i + 1) * 10;
      mylocale.refCategorie = 'C-' + (i + 1) * 4;
      this.locales.push(mylocale);
    }
  }


  get locale(): Locale {
    if (this._locale == null) {
      this._locale = new Locale();
    }
    return this._locale;
  }

  set locale(value: Locale) {
    this._locale = value;
  }

  get locales(): Array<Locale> {
    if (this._locales == null) {
      this._locales = new  Array<Locale>();
    }
    return this._locales;
  }

  set locales(value: Array<Locale>) {
    this._locales = value;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }
}
