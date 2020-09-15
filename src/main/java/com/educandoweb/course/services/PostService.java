package com.educandoweb.course.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.domain.Post;
import com.educandoweb.course.repository.PostRepository;
import com.educandoweb.course.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public List<Post> findAll() {
		return repo.findAll();

	}

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}
	
	public List findByTitle(String text) {
		//return repo.findByTitleContainingIgnoreCase(text);
			return repo.searchTitle(text);
 	}
	

  public List<Post> fullSearch(String text, Date minDate, Date maxDate){
	     //maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
	  //isto era para arrumar a data , para considerar o dia corretamente
	  // no teste que fiz não foi necessário usar,, ele acrescenta 24h na hora.
	      System.out.println(maxDate);
	     return  repo.fullSearch(text, minDate, maxDate);
  }
	
}
