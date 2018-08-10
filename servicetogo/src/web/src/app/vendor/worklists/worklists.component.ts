import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-worklists',
  templateUrl: './worklists.component.html',
  styleUrls: ['./worklists.component.css']
})
export class WorklistsComponent implements OnInit {
  tabname:string='skillqueue';
  constructor() { }

  ngOnInit() {
  }
  onClickUnassigned(event){
    this.tabname="skillqueue";
    event.preventDefault();
  }
  onClickMyworklist(event){
    this.tabname="myworklist";
    event.preventDefault();
  }
  onClickAllworklist(event){
    this.tabname="allworklist";
    event.preventDefault();
  }
}
