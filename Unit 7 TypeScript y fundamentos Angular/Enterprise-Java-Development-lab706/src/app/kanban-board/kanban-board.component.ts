import { Component, OnInit } from '@angular/core';
import { TaskItem } from '../models/task-item.model';

@Component({
  selector: 'app-kanban-board',
  templateUrl: './kanban-board.component.html',
  styleUrls: ['./kanban-board.component.css']
})
export class KanbanBoardComponent implements OnInit {

  public taskName: string;
  public toDoList: Array<TaskItem>;
  public doneList: Array<TaskItem>;
  public postponeList: Array<TaskItem>;

  constructor() {
    this.taskName = "";
    this.toDoList = [];
    this.doneList = [];
    this.postponeList = [];
   }

  ngOnInit(): void {
  }

  addTask(): void {
    this.toDoList.push(new TaskItem(this.taskName,""));
    this.taskName = "";
  }

  clear(): void {
    this.doneList = [];
  }

  restore(): void {
    let element: Array<TaskItem>;
    element = this.postponeList.splice(0, this.postponeList.length);
    console.log(element);
    console.log(element.length);
    for (let i = 0; i < element.length; i++) {
      this.toDoList.push(element[i]);
    }
  }

  completeTask(index: number): void {
    let element: TaskItem;
    element = this.toDoList.splice(index, 1)[0];
    element.backgroundColor = "green";
    this.doneList.push(element);
  }

  postponeTask(index: number): void {
    let element: TaskItem;
    element = this.toDoList.splice(index, 1)[0];
    this.postponeList.push(element);
  }

  deleteTask(index: number): void {
    this.toDoList.splice(index, 1);
  }

}
