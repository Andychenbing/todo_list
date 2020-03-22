
package com.wdzl.controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@RestController
@RequestMapping("/restful")
public class BookRestController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/book", method = POST, produces = "application/json")
	public WebResponse<Map<String, Object>> saveBook(@RequestBody Book book) {
		book.setId(1L);
	    bookService.saveBook(book);
		Map<String, Object> ret = new HashMap<>();
		ret.put("id", book.getId());
		WebResponse<Map<String, Object>> response = WebResponse.getSuccessResponse(ret);
		return response;
	}

	@RequestMapping(value = "/book/{id}", method = DELETE, produces = "application/json")
	public WebResponse<?> deleteArticle(@PathVariable Long id) {
		Book book = bookService.getById(id);
		book.setStatus(-1);
	    bookService.updateBook(book);
		WebResponse<Object> response = WebResponse.getSuccessResponse(null);
		return response;
	}

	@RequestMapping(value = "/book/{id}", method = PUT, produces = "application/json")
	public WebResponse<Object> updateArticle(@PathVariable Long id, @RequestBody Book book) {
		book.setId(id);
		bookService.updateBook(book);
		WebResponse<Object> response = WebResponse.getSuccessResponse(null);
		return response;
	}

	@RequestMapping(value = "/book/{id}", method = GET, produces = "application/json")
	public WebResponse<Article> getBook(@PathVariable Long id) {
		Book book = bookService.getById(id);
		WebResponse<Book> response = WebResponse.getSuccessResponse(book);
		return response;
	}
}
