import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  private url='http://localhost:8080/api/user';

  constructor(private http:HttpClient) { }
  createUser(user: Object): Observable<Object> {
    return this.http.post(`${this.url}`, user);
  }

  updateUser( user: User): Observable<User> {
    return this.http.put<User>(`${this.url}/${user.id}`, user);
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }

  getUser(): Observable<any> {
    return this.http.get(`${this.url}`);
  }
}
