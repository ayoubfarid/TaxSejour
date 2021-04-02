import {Component, ViewChild, AfterViewInit, OnInit} from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit , AfterViewInit{
  title = 'taxsejour';

  @ViewChild('tooglemenu') menu;
constructor() {
}
// tslint:disable-next-line:typedef
ngOnInit() {
}

// tslint:disable-next-line:typedef
  ngAfterViewInit(){
    console.log(this.menu);

}

}
