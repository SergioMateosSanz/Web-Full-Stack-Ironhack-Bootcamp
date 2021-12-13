import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pet } from '../models/pet.model';

@Injectable({
  providedIn: 'root'
})
export class PetService {

  readonly baseUrl: string = "http://localhost:8080";

  constructor(
    private http: HttpClient
  ) { }

  getPetlist(type: string, startAge: number ,endAge: number): Observable<Array<Pet>>{

    let params = new HttpParams();
    
    params = params.append('type', type);
    params = params.append('minAge', startAge);
    params = params.append('maxAge', endAge);

    // console.log(params);

    return this.http.get<Array<Pet>>(this.baseUrl + '/pets', {params: params});
  }

  adoptPet(adopterName: string, petID: number): Observable<any>{

    console.log(adopterName + ' ' + petID);

    // let params = new HttpParams();
    // params = params.append('nameAdopter', adopterName);
    // params = params.append('pet', petID);


    // return this.http.post(this.baseUrl + '/adopter', {params: params})

    const body = {
      nameAdopter: adopterName,
      pet: petID
    }

    return this.http.post<any>(this.baseUrl + '/adopter', body);
  }

}
