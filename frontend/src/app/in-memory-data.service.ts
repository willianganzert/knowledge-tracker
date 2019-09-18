import { Injectable } from '@angular/core';
import {InMemoryDbService, RequestInfo} from 'angular-in-memory-web-api';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService{

  constructor() {
    }

  createDb(reqInfo?: RequestInfo): {} | Observable<{}> | Promise<{}> {
    const heroes = [
      { id: 11, name: 'Dr Nice' },
      { id: 12, name: 'Narco' },
      { id: 13, name: 'Bombasto' },
      { id: 14, name: 'Celeritas' },
      { id: 15, name: 'Magneta' },
      { id: 16, name: 'RubberMan' },
      { id: 17, name: 'Dynama' },
      { id: 18, name: 'Dr IQ' },
      { id: 19, name: 'Magma' },
      { id: 20, name: 'Tornado' }
    ];
    const nodes = [
      {createdAt:'2019-08-25T03:27:22.147+0000',updatedAt:'2019-08-25T03:27:22.147+0000',id:1,parentTree:null,type:null,content:null,name:null},
      {createdAt:'2019-08-25T03:44:50.551+0000',updatedAt:'2019-08-25T03:44:50.551+0000',id:52,parentTree:null,type:'LINK',content:'test',name:'Test'},
      {createdAt:'2019-08-25T12:53:21.288+0000',updatedAt:'2019-08-25T12:53:21.288+0000',id:152,parentTree:null,type:'LINK',content:'test3',name:'Test3'},
      {createdAt:'2019-08-25T03:49:53.717+0000',updatedAt:'2019-08-25T03:49:53.745+0000',id:102,parentTree:[52],type:'LINK',content:'test',name:'Test'},
      {createdAt:'2019-08-25T03:51:48.762+0000',updatedAt:'2019-08-25T03:51:48.763+0000',id:103,parentTree:[52,102],type:'LINK',content:'test',name:'Test'},
      {createdAt:'2019-08-25T03:55:00.846+0000',updatedAt:'2019-08-25T03:55:00.847+0000',id:105,parentTree:[52,102],type:'LINK',content:'test2',name:'Test2'},
      {createdAt:'2019-08-25T03:53:09.494+0000',updatedAt:'2019-08-25T03:53:09.495+0000',id:104,parentTree:[52,102,103],type:'LINK',content:'test',name:'Test'},
      {createdAt:'2019-08-25T03:55:53.673+0000',updatedAt:'2019-08-25T03:55:53.674+0000',id:106,parentTree:[52,102,105],type:'LINK',content:'test2',name:'Test2'}];
    return {heroes, nodes};
  }
}
