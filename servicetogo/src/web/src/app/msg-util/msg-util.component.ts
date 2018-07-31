import { Component, OnInit, Input, OnChanges, SimpleChanges,EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-msg-util',
  templateUrl: './msg-util.component.html',
  styleUrls: ['./msg-util.component.css']
})
export class MsgUtilComponent implements OnInit, OnChanges {
  @Input('alertMessage') alertMessage: string;
  @Input('hide') hide: number;
  @Output() msgHidden= new EventEmitter<number>();
  constructor() { }

  ngOnInit() {
  }

  hideAlert(){
    this.msgHidden.emit(1);
  }
  ngOnChanges(changes: SimpleChanges) {
    if(changes['hide']){
      this.hide = changes['hide'].currentValue;
    }
    if(changes.alertMessage){
      this.alertMessage=changes.alertMessage.currentValue;
    }
    console.log(changes);
  }
}
