import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Node} from './model/node';
import {Observable} from 'rxjs';
import {environment} from '../environments/environment';
import {map} from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class NodeService {
  ENVIRONMENT = environment;
  constructor(private http: HttpClient) { }

  getAllNodes(): Observable<Node[]> {

    return  this.http.get<Node[]>(this.ENVIRONMENT.apiURL + this.ENVIRONMENT.apiV1Path + '/nodes').pipe(map(this.dataConversion));
  }

  dataConversion(data:[any]): any {
    let removeValFromIndex = [];
    data.reverse();
    data.forEach(function(node, index, object) {
      if (node.parentTree && node.parentTree.length > 0) {
        let lastParent = node.parentTree[node.parentTree.length-1]
        for(let i2 of object){
           if(lastParent == i2.id){
             if(i2.children == undefined)
               i2.children = [];
             i2.children.push(node);
             break;
           }
        }
        removeValFromIndex.push(index);
      }
    });
    for (let i = removeValFromIndex.length -1; i >= 0; i--)
      data.splice(removeValFromIndex[i],1);
    return data;
  }

}
