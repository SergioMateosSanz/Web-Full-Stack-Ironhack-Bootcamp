import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Pet } from '../models/pet.model';
import { PetService } from '../service/pet.service';

@Component({
  selector: 'app-pet-item',
  templateUrl: './pet-item.component.html',
  styleUrls: ['./pet-item.component.css']
})
export class PetItemComponent implements OnInit {

  @Input()
  pet: Pet;
  
  adopt: boolean;
  adopterName: string;

  @Output()
  resetFilterEvent: EventEmitter<any> = new EventEmitter();

  constructor(private petService: PetService) {
    this.pet = new Pet(0, "", "", 0, true);
    this.adopt = false;
    this.adopterName = "";
  }

  ngOnInit(): void {
  }

  adoptPet():void{
    this.adopt = true;
  }

  submit():void{
    this.pet.available = false;

    console.log(`adopter name: ${this.adopterName}`);
    //llamada a la API para creat nuevo adopter y marcar pet como unavailable
    this.petService.adoptPet(this.adopterName, this.pet.id).subscribe(dataResult => {
      console.log(dataResult);

      this.resetFilterEvent.emit();

      alert("Congratulations " + dataResult.adopter.name + ", you have adopted " + dataResult.pet.name);
    });
  }

  isDisable(): boolean{
    if(this.adopterName === ""){
      return true;
    }
    return false;
  }

}
