import { Component, OnInit } from '@angular/core';
import {StudentService} from "../service/student.service";
import {Student} from "../service/student";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.less']
})
export class StudentFormComponent implements OnInit {

  public student = new Student(null, "", "");

  private mode: 'create' | 'edit' = 'create';

  constructor(public studentService: StudentService,
              public route: ActivatedRoute,
              public router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(param => {
      if (param['id']) {
        this.mode = 'edit';
        this.studentService.findById(param['id'])
          .subscribe({
            next: student => {
              this.student = student;
            },
            error: err => {
              console.log(`Error ${err}`);
            }
          });
      }
    });
  }

  save() {
    console.log(this.student);
    if(this.mode == 'create') {
      this.studentService
        .create(this.student)
        .subscribe(
          () => this.onSave()
        );
    } else {
      this.studentService
        .save(this.student)
        .subscribe(
          () => this.onSave()
        );
    }
  }

  private onSave() {
    this.router.navigateByUrl('/student');
  }
}
