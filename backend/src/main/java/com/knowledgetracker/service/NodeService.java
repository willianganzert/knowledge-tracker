package com.knowledgetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knowledgetracker.domain.Node;
import com.knowledgetracker.repository.NodeRepository;

@Service
public class NodeService {
	@Autowired
	private NodeRepository nodeRepository;
	public List<Node> getNodes(){
		return nodeRepository.findAll(); 
	}
	public List<Node> getNodesBasedOnMainNode(long nodeId){
		return nodeRepository.getNodesBasedOnMainNode(nodeId); 
	}
	public Node createNodes(Node node){
		return nodeRepository.save(node); 
	}
}
