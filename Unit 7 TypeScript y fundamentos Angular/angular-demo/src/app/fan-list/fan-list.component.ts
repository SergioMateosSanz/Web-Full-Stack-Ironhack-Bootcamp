import { Component, OnInit } from '@angular/core';
import { Fan } from '../models/fan.model';
import { RandomUserService } from '../services/random-user.service';

@Component({
  selector: 'app-fan-list',
  templateUrl: './fan-list.component.html',
  styleUrls: ['./fan-list.component.css']
})
export class FanListComponent implements OnInit {

  public fanName: string;
  public fanAge: number;
  public fanCountry: string;
  public team: string;
  public madridFanList: Array<Fan>;
  public barcelonaFanList: Array<Fan>;

  constructor(
    private randomUserService: RandomUserService
    ) {
    this.fanName = "";
    this.fanAge = 0;
    this.fanCountry = "";
    this.team = "";
    this.madridFanList = [];
    this.barcelonaFanList = [];
  }

  ngOnInit(): void {
  }

  addFan(): void {
    const newFan = new Fan(this.fanName, this.fanAge, this.fanCountry);
    if (this.team === "madrid") {
      this.madridFanList.push(newFan);
    } else {
      this.barcelonaFanList.push(newFan);
    }

    this.fanName = "";
    this.fanAge = 0;
    this.fanCountry = "";
    this.team = "";
  }

  deleteFan(i: number, selectedTeam: string) {
    if (selectedTeam === "madrid") {
      this.madridFanList.splice(i, 1);
    } else {
      this.barcelonaFanList.splice(i, 1);
    }
  }

  sendAlertReceived(message: string): void {
    alert(message);
  }

  changeTeam(index: number, originTeam: string): void {
    let element: Fan;

    if (originTeam === "madrid") {
      element = this.madridFanList.splice(index, 1)[0];
      this.barcelonaFanList.push(element);
    } else {
      element = this.barcelonaFanList.splice(index, 1)[0];
      this.madridFanList.push(element);
    }
  }

  addRandomFan(selectedTeam: string): void {
    this.randomUserService.getRandomUser().subscribe(dataResult => {
      const name: string = dataResult.results[0].name.title + '' + dataResult.results[0].name.first + '' + dataResult.results[0].name.last;
      const age: number = dataResult.results[0].dob.age;
      const country: string = dataResult.results[0].location.country;
      const profilePicture: string = dataResult.results[0].picture.medium;

      const randomFan: Fan = new Fan(name, age, country, profilePicture);

      this.chooseTeam(randomFan, selectedTeam);
    })
  }

  private chooseTeam(randomFan: Fan, selectedTeam: string): void {

    if (selectedTeam === 'madrid') {
      this.madridFanList.push(randomFan);
    } else {
      this.barcelonaFanList.push(randomFan);
    }
  }
}
