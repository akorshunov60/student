import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Student} from "./student";

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(public http: HttpClient) { }

  public findAll() {
    return this.http.get<Student[]>("api/v1/student/all");
  }

  public findById(id: number) {
    return this.http.get<Student>(`api/v1/student/${id}/id`);
  }

  public deleteById(id: number) {
    return this.http.delete<Student>(`api/v1/student/${id}/id`);
  }

  public create(student: Partial<Student>) {
    return this.http.post<Student>('api/v1/student', student);
  }

  public save(student: Student) {
    return this.http.put<Student>('api/v1/student', student);
  }
}
