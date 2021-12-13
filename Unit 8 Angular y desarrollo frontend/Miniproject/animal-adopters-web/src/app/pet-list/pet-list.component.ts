import { Component, OnInit } from '@angular/core';
import { Pet } from '../models/pet.model';
import { PetService } from '../service/pet.service';

@Component({
  selector: 'app-pet-list',
  templateUrl: './pet-list.component.html',
  styleUrls: ['./pet-list.component.css']
})
export class PetListComponent implements OnInit {

  petList: Array<Pet>;
  type: string;
  ageStart: number;
  ageEnd: number;

  constructor(private petService: PetService) {
    this.petList = [];
    this.type = "";
    this.ageStart = -1;
    this.ageEnd = 100;
  }

  ngOnInit(): void {
    this.applyFilter();
  }

  applyFilter(): void{
    this.petService.getPetlist(this.type, this.ageStart, this.ageEnd).subscribe(dataResult => {
      // console.log(dataResult);
      this.petList = dataResult;
    })
  }

  resetFilter(): void{
    this.type = "";
    this.ageStart = -1;
    this.ageEnd = 100;

    this.applyFilter();
  }

}
