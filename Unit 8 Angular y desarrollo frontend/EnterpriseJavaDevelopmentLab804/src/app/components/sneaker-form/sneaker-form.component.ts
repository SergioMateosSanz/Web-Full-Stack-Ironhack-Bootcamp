import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CustomValidators } from 'src/app/utils/custom-validators';
import { Sneaker } from 'src/app/utils/sneaker';

@Component({
  selector: 'app-sneaker-form',
  templateUrl: './sneaker-form.component.html',
  styleUrls: ['./sneaker-form.component.css']
})
export class SneakerFormComponent implements OnInit {

  public sneakerList: Array<Sneaker>;

  public registerForm: FormGroup;
  public modelNameInput: FormControl;
  public priceInput: FormControl;
  public specialEditionInput: FormControl;
  public authorInput: FormControl;
  public creationDateInput: FormControl;
  public artistCollaboratorInput: FormControl;

  constructor() {
    this.sneakerList = [];
    this.modelNameInput = new FormControl('', [Validators.required]);
    this.priceInput = new FormControl('', [Validators.required, Validators.min(0)]);
    this.specialEditionInput = new FormControl('', [Validators.required]);
    this.authorInput = new FormControl('', [Validators.required]);
    this.creationDateInput = new FormControl('', [Validators.required]);
    this.artistCollaboratorInput = new FormControl('');
    this.registerForm = new FormGroup({
      modelName: this.modelNameInput,
      price: this.priceInput,
      specialEdition: this.specialEditionInput,
      author: this.authorInput,
      creationDate: this.creationDateInput,
      artistCollaborator: this.artistCollaboratorInput
    }, [CustomValidators.isSpecialEditionAndArtistCollaboratorMustBeInformed]);
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    const modelName: string = this.modelNameInput.value;
    const price: number = this.priceInput.value;
    const specialEdition: boolean = this.specialEditionInput.value;
    const author: string = this.authorInput.value;
    const creationDate: Date = this.creationDateInput.value;
    const artistCollaborator: string = this.artistCollaboratorInput.value;
    const sneaker: Sneaker = new Sneaker(modelName, price, specialEdition, author, creationDate, artistCollaborator);

    this.sneakerList.push(sneaker);
  }
}
