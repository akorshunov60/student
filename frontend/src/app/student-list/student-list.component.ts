import { Component, OnInit } from '@angular/core';
import {StudentService} from "../service/student.service";
import {Student} from "../service/student";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.less']
})
export class StudentListComponent implements OnInit {

  students: Student[] = [];

  constructor(public studentService: StudentService) { }

  ngOnInit(): void {
    this.retrieveAllStudents();
  }

  private retrieveAllStudents() {
    this.studentService.findAll().subscribe({
      next: students => {
        console.log(
          `New data from server! ${students}`
        );
        this.students = students;
      },
      error: err => {
        console.log(`Error ${err}`);
      }
    });
  }

  delete(id: number | null) {
    if(typeof id == "number") {
      this.studentService
        .deleteById(id)
        .subscribe(
          () => this.retrieveAllStudents()
        );
    }
  }
}
