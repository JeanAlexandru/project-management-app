import {Component, OnInit} from '@angular/core';
import {CdkDragDrop, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';
import {Task} from "../../shared/model/task";
import {State} from "../../shared/model/state";

@Component({
  selector: 'app-drag-list',
  templateUrl: './drag-list.component.html',
  styleUrls: ['./drag-list.component.css']
})
export class DragListComponent implements OnInit{

  todo = [ ];

  done = [ ];

  inProgress = [ ];



  ngOnInit(): void {
    const tasks = [
      new Task('Get up','Get up early', State.DONE),
      new Task('Brush teeth','Brush teeth at least two times a day', State.IN_PROGRESS),
      new Task('Take a shower','Take a shower every day', State.TODO),
      new Task('Check e-mail','Check e-mail activation', State.IN_PROGRESS),
      new Task('Walk dog','Walk the dog in the park', State.IN_PROGRESS)
    ];

    this.inProgress = tasks.filter(task => task.state === State.IN_PROGRESS);
    this.todo = tasks.filter(task => task.state === State.TODO);
    this.done = tasks.filter(task => task.state === State.DONE);
  }

  drop(event: CdkDragDrop<string[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex);
    }
  }
}
