import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';

@Component({
  selector: 'app-confirmation-dialog',
  templateUrl: './confirmation-dialog.component.html',
  styleUrls: ['./confirmation-dialog.component.css']
})
export class ConfirmationDialogComponent implements OnInit {
  @Input() messageToShow:string="Do you want to delete?";
  @Output() onOptionClick=new EventEmitter<boolean>();
  constructor() { }

  ngOnInit() {
  }
  buttonClicked(option:string){
    if('Yes'==option){
      this.onOptionClick.next(true);
    }else{
      this.onOptionClick.next(false);
    }
  }
}
