import { Component } from '@angular/core';
import { UserItem } from './models/user-item.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'adds-users';
  public name: string;
  public age: number;
  public email: string;
  public gender: string;
  public userList: Array<UserItem>

  constructor() {
    this.name = "";
    this.age = 0;
    this.email = "";
    this.gender = "";
    this.userList = [];
  }

  negativeAge(): boolean {
    return this.age < 0;
  }

  addUser(): void {
    this.userList.push(new UserItem(this.name, this.age, this.email, this.gender));
  }
}
