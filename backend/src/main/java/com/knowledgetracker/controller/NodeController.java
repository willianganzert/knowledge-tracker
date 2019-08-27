package com.knowledgetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knowledgetracker.domain.Node;
import com.knowledgetracker.service.NodeService;

@RestController
@RequestMapping("nodes")
public class NodeController {
	@Autowired
	private NodeService nodeService;
	
	@GetMapping({"","/{nodeId}"})
	public ResponseEntity<List<Node>> getNodes(@PathVariable(name="nodeId", required=false) Long nodeId){		
		if(nodeId != null) {
			return  new ResponseEntity<>(nodeService.getNodesBasedOnMainNode(nodeId), HttpStatus.OK);
		}
		return  new ResponseEntity<>(nodeService.getNodes(), HttpStatus.OK);
	}	
	@PostMapping
	public ResponseEntity<Node> createNode(@RequestBody Node node){		
		return  new ResponseEntity<>(nodeService.createNodes(node), HttpStatus.OK);
	}	
}
