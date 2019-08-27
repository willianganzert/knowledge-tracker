package com.knowledgetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.knowledgetracker.domain.Node;

@Repository
public interface NodeRepository extends JpaRepository<Node,Long>{
	@Query(value="select * from kt_node order by array_length(parent_tree, 1) ASC NULLS FIRST", 
			  nativeQuery = true)
	List<Node> findAll();
	
	@Query(value="select * from kt_node where id = ?1 or ?1 = ANY (parent_tree) order by array_length(parent_tree, 1) ASC NULLS FIRST", 
			  nativeQuery = true)
	List<Node> getNodesBasedOnMainNode(Long nodeId);
}
