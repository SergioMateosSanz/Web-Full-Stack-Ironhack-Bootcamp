import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-text-editor',
  templateUrl: './text-editor.component.html',
  styleUrls: ['./text-editor.component.css']
})
export class TextEditorComponent implements OnInit {

  public text: string;
  public px: number;

  constructor() { 
    this.text = "";
    this.px = 20;
  }

  ngOnInit(): void {
  }

  isLengthLongerThanSeven(): boolean {
    return this.text.length > 7;
  }

  isSizeBiggerThanLongerThanThirty(): boolean {
    return this.px > 30;
  }

  increaseFontSize(): void {
    this.px = this.px + 1;
  }

  decreaseFontSize(): void {
    this.px = this.px - 1;
  }

}
