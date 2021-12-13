import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-template-driven-form',
  templateUrl: './template-driven-form.component.html',
  styleUrls: ['./template-driven-form.component.css']
})
export class TemplateDrivenFormComponent implements OnInit {

  user: {
    email: string,
    password: string,
    role: string
  }

  @ViewChild('form')
  form!: NgForm;

  constructor() {
    this.user = {
      email: '',
      password: '',
      role: ''
    }
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    console.log('Creating user...');
    console.log(this.user);
    console.log(this.form.value);
  }

  doSomething(): void {
    console.log('Doing something...');
  }

}
