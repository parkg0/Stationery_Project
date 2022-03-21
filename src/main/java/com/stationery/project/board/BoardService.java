package com.stationery.project.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;



public interface BoardService {
		//list
		public List<BoardDTO> list()throws Exception;
		
		//detail
		public BoardDTO detail(BoardDTO boardDTO)throws Exception;
				
		//update
		public int update(BoardDTO boardDTO)throws Exception;
		
		//delete
		public int delete(BoardDTO boardDTO)throws Exception;
}
