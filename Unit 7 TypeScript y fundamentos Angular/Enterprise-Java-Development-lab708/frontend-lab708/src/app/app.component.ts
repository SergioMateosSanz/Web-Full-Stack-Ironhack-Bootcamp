import { Component } from '@angular/core';
import { Employee } from './models/employee.model';
import { EmployeeListService } from './services/employee-list.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend-lab708';
  public employeeList: Array<Employee>;

  constructor(private employeeListService: EmployeeListService) {
    this.employeeList = [];
  }

  loadEmployeeList(): void {
    this.employeeListService.getEmployeeList().subscribe(dataResult => {
      for (let i = 0; i < dataResult.length; i++) {
        const employee: Employee = new Employee(dataResult[i].id, dataResult[i].name, dataResult[i].phoneNumber, dataResult[i].officeNumber,
          dataResult[i].position, dataResult[i].manager);
        this.employeeList.push(employee);
      }
    })
  }

  sendAlertReceived(): void {
    this.employeeList = [];
    this.loadEmployeeList();
  }
}
