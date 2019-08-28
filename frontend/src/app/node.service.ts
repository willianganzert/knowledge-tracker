import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Node} from './model/node';
import {Observable} from 'rxjs';
import {environment} from '../environments/environment';
@Injectable({
  providedIn: 'root'
})
export class NodeService {
  ENVIRONMENT = environment;
  constructor(private http: HttpClient) { }

  getAllNodes(): Observable<Node[]> {

    return  this.http.get<Node[]>(this.ENVIRONMENT.apiURL + this.ENVIRONMENT.apiV1Path + '/nodes');
  }

}
