import { Component, OnInit } from '@angular/core';
import {NodeService} from '../node.service';
import {Node} from '../model/node';

@Component({
  selector: 'kt-node',
  templateUrl: './node.component.html',
  styleUrls: ['./node.component.css']
})
export class NodeComponent implements OnInit {
  data: Node[];
  constructor(private nodeService: NodeService) { }

  ngOnInit() {
      this.nodeService.getAllNodes().subscribe((data) => {
        this.data = data;
      });
  }

}
