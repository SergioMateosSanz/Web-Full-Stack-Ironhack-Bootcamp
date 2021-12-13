import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-template-driven-form',
  templateUrl: './template-driven-form.component.html',
  styleUrls: ['./template-driven-form.component.css']
})
export class TemplateDrivenFormComponent implements OnInit {

  user: {
    name: string,
    occupation: string,
    email: string,
    subject: string,
    content: string
  }

  @ViewChild('form')
  form!: NgForm;

  constructor() {
    this.user = {
      name: '',
      occupation: '',
      email: '',
      subject: '',
      content: ''
    }
  }

  ngOnInit(): void {
  }

  onSubmitForm(): void {
    console.log('Submit botton pressed...');
    console.log(this.user);
    console.log(this.form.value);
  }

}
