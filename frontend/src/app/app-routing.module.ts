import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {NodeComponent} from './node/node.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';


const routes: Routes = [
  { path: 'node', component: NodeComponent },
  { path: 'node/:id',      component: NodeComponent },
  { path: '',   redirectTo: '/node', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
