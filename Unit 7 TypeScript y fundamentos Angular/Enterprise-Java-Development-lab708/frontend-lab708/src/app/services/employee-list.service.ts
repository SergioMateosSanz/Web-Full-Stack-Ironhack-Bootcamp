import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeListService {

  readonly baseUrl = 'http://localhost:8080';

  constructor(
    private http: HttpClient
  ) { }

  getEmployeeList(): Observable<any> {
    return this.http.get(this.baseUrl + '/employees');
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(this.baseUrl + '/employees/'+ id);
  }
}
