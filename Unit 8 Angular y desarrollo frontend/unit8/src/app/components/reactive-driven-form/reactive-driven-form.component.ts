import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CustomValidators } from 'src/app/utils/custom-validators';

@Component({
  selector: 'app-reactive-driven-form',
  templateUrl: './reactive-driven-form.component.html',
  styleUrls: ['./reactive-driven-form.component.css']
})
export class ReactiveDrivenFormComponent implements OnInit {

  public genders: Array<string>;

  public registerForm: FormGroup;
  public nameInput: FormControl;
  public emailInput: FormControl;
  public ageInput: FormControl;
  public genderInput: FormControl;
  public passwordInput: FormControl;
  public passwordConfirmationInput: FormControl;

  constructor() {
    this.genders = ["male", "female", "other"];
    this.nameInput = new FormControl('', [Validators.required, CustomValidators.noPepito, CustomValidators.noContainDigits]);
    this.emailInput = new FormControl('', [Validators.required, Validators.email]);
    this.ageInput = new FormControl('', [Validators.required, CustomValidators.validAge(18, 99)]);
    this.genderInput = new FormControl('', [Validators.required]);
    this.passwordInput = new FormControl('', [Validators.required, Validators.minLength(8)]);
    this.passwordConfirmationInput = new FormControl('', [Validators.required, Validators.minLength(8)]);
    this.registerForm = new FormGroup({
      name: this.nameInput,
      email: this.emailInput,
      age: this.ageInput,
      gender: this.genderInput,
      password: this.passwordInput,
      passwordConfirmation: this.passwordConfirmationInput
    }, [CustomValidators.passwordsEquals]);
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    console.log(this.registerForm.value);
  }
}
