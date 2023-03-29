package org.bigjoe.demo.entity;

import java.util.List;

import lombok.Data;

@Data
public class PageVo {

	private int pageCount = 0;
	private long recordCount = 0;
	private List<?> list;  
}
