import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Employee } from '../models/employee.model';
import { EmployeeListService } from '../services/employee-list.service';

@Component({
  selector: 'app-employee-item',
  templateUrl: './employee-item.component.html',
  styleUrls: ['./employee-item.component.css']
})
export class EmployeeItemComponent implements OnInit {

  @Input('employeeProperty')
  employee!: Employee;
  
  public isDetails: boolean;

  @Output()
  sendAlertEvent: EventEmitter<string> = new EventEmitter();

  constructor(private employeeListService: EmployeeListService) {
    this.isDetails = false;
   }

  ngOnInit(): void {
  }

  showDetails(): void {
    this.isDetails = true;
  }

  deleteEmployee(id: number): void {
    this.employeeListService.deleteEmployee(id).subscribe(dataResult => {
      this.sendAlertEvent.emit();
    })
  }

}
