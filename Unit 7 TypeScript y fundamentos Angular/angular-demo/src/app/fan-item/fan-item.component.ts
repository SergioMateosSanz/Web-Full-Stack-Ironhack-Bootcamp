import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Fan } from '../models/fan.model';

@Component({
  selector: 'app-fan-item',
  templateUrl: './fan-item.component.html',
  styleUrls: ['./fan-item.component.css']
})
export class FanItemComponent implements OnInit {

  @Input('fanProperty')
  fan!: Fan;

  @Input('index')
  index!: number;

  @Output()
  removeFanEvent: EventEmitter<number> = new EventEmitter();

  @Output()
  sendAlertEvent: EventEmitter<string> = new EventEmitter();

  @Output()
  sendConmuteEvent: EventEmitter<any> = new EventEmitter();

  constructor() { 
  }

  ngOnInit(): void {
  }

  removeFan(): void {
    this.removeFanEvent.emit(this.index);
  }

  sendAlert(): void {
    this.sendAlertEvent.emit("alert from child");
  }

  conmuteTeam(): void {
    this.sendConmuteEvent.emit();
  }
}
