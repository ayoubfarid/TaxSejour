import {Injectable} from '@angular/core';
import {Typeredevable} from "../model/typeredevable.model";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class TyperedevableService {
  private _type: Typeredevable;
  private _typeList: Array<Typeredevable>;
  private url: string = "http://localhost:8039/app-redevable/type/";
  private statumsg: String = null;
  private _checkvalue :Typeredevable;
  private _index:number;
  constructor(private http: HttpClient) {
  }

  public save() {
    this.check(this.type);
    if (this._checkvalue == null) {

      if (this.verifyNull(this.type)) {
        this.http.post<number>(this.url, this._type).subscribe(
          data => {
            if (data == 1) {
              this._typeList.push(this.cloneType(this._type));
              this.statumsg = "type was saved";
            } else if (data == -1) {
              this.statumsg = "Type deja exist";
            }
          },
          error => {
            console.log(error);
          }
        );
        this._checkvalue = null;
      }
      else
      {
        alert("les champs sont vide");
      }
    } else {
      this.http.put(this.url + "/edit/",this.type).subscribe(
        data => {
          if (data == 1) {
            this.statumsg = "type was changed";
            this._typeList[this._index] =this.type;
          } else if (data = -1) {
            this.statumsg = "type didnt exist";
            console.log(this.statumsg);
          }
        }, error => {

        }
      );
    }
  }
  public verifyNull(type :Typeredevable): boolean{
    if(type.code==null|| type.libelle==null){
      return false;
    }
    else {
      return true;
    }
  }
  public check(checkvo:Typeredevable) {
    this.http.get<Typeredevable>(this.url+"code/"+checkvo.code).subscribe(
      data => {
        this._checkvalue = data;
      },error => {
        console.log(error);
      }
    );

  }
  public findAll() {
    this.http.get<Array<Typeredevable>>(this.url).subscribe(
      data => {
        console.log(data);
        this._typeList = data;
      }, error => {
        console.log(error);
      }
    );
  }

  public edit1(c: Typeredevable, i: number) {

    this._type = null;
  }
  public edit(c:Typeredevable ,i:number){
    this.type=this.cloneType(c);
    this._index=i;
  }
  public delete(c: Typeredevable, i:number) {
    this.http.delete(this.url+"/libelle/"+c.libelle).subscribe(
      data => {
        if (data>0){
          this.typeList.splice(i,1);
          this.statumsg=data+" object was deleted!";
        }
      }, error => {
        console.log(error);
      }
    );
  }

  get type(): Typeredevable {
    if (this._type == null) {
      this._type = new Typeredevable();
    }
    return this._type;
  }

  set type(value: Typeredevable) {
    this._type = value;
  }

  get typeList(): Array<Typeredevable> {
    if (this._typeList == null) {
      this._typeList = new Array<Typeredevable>();
    }
    return this._typeList;
  }

  set typeList(value: Array<Typeredevable>) {
    this._typeList = value;
  }

  private cloneType(type: Typeredevable) {
    const myClone = new Typeredevable();
    myClone.code = type.code;
    myClone.libelle = type.libelle;
    myClone.id = type.id;
    return myClone;
  }
}


