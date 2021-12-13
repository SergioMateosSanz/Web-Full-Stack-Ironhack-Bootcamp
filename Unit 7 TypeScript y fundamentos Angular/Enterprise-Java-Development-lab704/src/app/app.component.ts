import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Enterprise-Java-Development-lab704';
  backgorundColorOne: string;
  backgorundColorTwo: string;
  backgorundColorThree: string;
  textColorOne: string;
  textColorTwo: string;
  textColorThree: string;

  constructor() {
    this.backgorundColorOne = "darkkhaki";
    this.backgorundColorTwo = "brown";
    this.backgorundColorThree = "green";
    this.textColorOne = "mediumblue";
    this.textColorTwo = "lime";
    this.textColorThree = "hotpink";
  }

  changeColor(): void {
    if (this.backgorundColorOne === "darkkhaki") {
      this.backgorundColorOne = "brown";
      this.textColorOne = "lime";
    } else {
      if (this.backgorundColorOne === "brown") {
        this.backgorundColorOne = "green";
        this.textColorOne = "hotpink";
      } else {
        this.backgorundColorOne = "darkkhaki";
        this.textColorOne = "mediumblue";
      }
    }
    if (this.backgorundColorTwo === "darkkhaki") {
      this.backgorundColorTwo = "brown";
      this.textColorTwo = "lime";
    } else {
      if (this.backgorundColorTwo === "brown") {
        this.backgorundColorTwo = "green";
        this.textColorTwo = "hotpink";
      } else {
        this.backgorundColorTwo = "darkkhaki";
        this.textColorTwo = "mediumblue";
      }
    }
    if (this.backgorundColorThree === "darkkhaki") {
      this.backgorundColorThree = "brown";
      this.textColorThree = "lime";
    } else {
      if (this.backgorundColorThree === "brown") {
        this.backgorundColorThree = "green";
        this.textColorThree = "hotpink";
      } else {
        this.backgorundColorThree = "darkkhaki";
        this.textColorThree = "mediumblue";
      }
    }
  }
}
