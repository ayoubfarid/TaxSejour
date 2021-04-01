import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Redevable} from '../model/redevable.model';

@Injectable({
  providedIn: 'root'
})
export class RedevableService {

  private _redevable: Redevable;
  private _redevabllist: Array<Redevable>;
  private url = 'http://localhost:8039/app-redevable/';
  private statumsg: String = null;
  private _checkvalue: number;
  private _index: number;
  constructor(private http: HttpClient) {
  }

  public save() {
    this.check(this.redevable);
    if (this._checkvalue = 1) {
      this.http.put(this.url + 'update/', this.redevable).subscribe(
        data => {
          if (data == 1) {
            this.statumsg = 'Redevable was changed';
            this._redevabllist[this._index] = this.redevable;
          } else if (data = -1) {
            this.statumsg = 'Redevable didnt exist';
            console.log(this.statumsg);
          }
        }, error => {
             console.log(error);
        }
      );
    } else {
      if (this.verifyNull(this.redevable)) {
        this.http.post<number>(this.url, this._redevable).subscribe(
          data => {
            if (data == 1) {
              this._redevabllist.push(this.cloneType(this._redevable));
              this.statumsg = 'type was saved';
            } else if (data == -1) {
              this.statumsg = 'Type deja exist';
            }
          },
          error => {
            console.log(error);
          }
        );
        this._checkvalue = 0;
      }
      else
      {
        alert('les champs sont vide');
      }
    }
  }
  public verifyNull(redevable: Redevable): boolean{
    if (redevable.ref == null || redevable.type == null){
      return false;
    }
    else {
      return true;
    }
  }
  public check(checkvo: Redevable):number {
    this._checkvalue
    this.http.get<number>(this.url + '/Redvable/findByReference/' + checkvo.ref).subscribe(
      data => {
        this._checkvalue = data;
      }, error => {
        console.log(error);
      }
    );
    return
  }
  public findAll() {
    this.http.get<Array<Redevable>>(this.url).subscribe(
      data => {
        console.log(data);
        this._redevabllist = data;
      }, error => {
        console.log(error);
      }
    );
  }

  public edit(c: Redevable , i: number){
    this.redevable = c;
    this._index = i;
  }
  public delete(c: Redevable, i: number) {
    this.http.delete<number>(this.url + 'ref/' + c.ref).subscribe(
      data => {
        if (data > 0){
          this.redevabllist.splice(i, 1);
          this.statumsg = data + ' object was deleted!';
        }
      }, error => {
        console.log(error);
      }
    );
  }

  get redevable(): Redevable {
    if (this._redevable == null) {
      this._redevable = new Redevable();
    }
    return this._redevable;
  }

  set redevable(value: Redevable) {
    this._redevable = value;
  }

  get redevabllist(): Array<Redevable> {
    if (this._redevabllist == null) {
      this._redevabllist = new Array<Redevable>();
    }
    return this._redevabllist;
  }

  set redevabllist(value: Array<Redevable>) {
    this._redevabllist = value;
  }

  private cloneType(type: Redevable) {
    const myClone = new Redevable();
    myClone.ref = type.ref;
    myClone.type = type.type;
    myClone.id = type.id;
    return myClone;
  }
}
