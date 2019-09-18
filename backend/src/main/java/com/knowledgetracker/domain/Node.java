package com.knowledgetracker.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.knowledgetracker.domain.hibernatetypes.LongArrayUserType;

@Entity
@Table(name = "kt_node")
@TypeDef(name = "LongArrayUserType", typeClass = LongArrayUserType.class)
public class Node extends AuditModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "node_sequence")
    @SequenceGenerator(name = "node_sequence")
	private long id;
	
	@Type(type = "LongArrayUserType")
	private long[] parentTree;
	
	@Enumerated(EnumType.ORDINAL)
	private NodeType type;
	@JsonProperty("name")
	private String title;
	
	private String content;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long[] getParentTree() {
		return parentTree;
	}

	public void setParentTree(long[] parentTree) {
		this.parentTree = parentTree;
	}

	public NodeType getType() {
		return type;
	}

	public void setType(NodeType type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
