import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  private url='http://localhost:8080/api/user';

  constructor(private httpClient:HttpClient) { }
  getUser():Observable<User[]>{
    return this.httpClient.get<User[]>(this.url);
  }
}
