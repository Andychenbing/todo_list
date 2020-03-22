@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class BookControllerTest {

	@Autowired
	private BookRestController bookController;

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(restController).build();
	}

	@Test
	public void testAddBook() throws Exception {
		Book book = new Book();
		book.setTitle("添加书籍");
		book.setType(1);
		article.setSummary("哈利波特");
		Gson gosn = new Gson();
		RequestBuilder builder = MockMvcRequestBuilders
				.post("/restful/book")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(gosn.toJson(book));

		MvcResult result = mvc.perform(builder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}

	@Test
	public void testUpdateBook() throws Exception {
		Book book = new Book();
		book.setTitle("更新书籍");
		book.setType(1);
		book.setSummary("更新书籍信息");
		Gson gosn = new Gson();
		RequestBuilder builder = MockMvcRequestBuilders
				.put("/restful/book/1")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(gosn.toJson(book));
		MvcResult result = mvc.perform(builder).andReturn();
	}

	@Test
	public void testQueryBook() throws Exception {
		RequestBuilder builder = MockMvcRequestBuilders
				.get("/restful/book/1")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_UTF8);
		MvcResult result = mvc.perform(builder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}

	@Test
	public void testDeleteBook() throws Exception {
		RequestBuilder builder = MockMvcRequestBuilders
				.delete("/restful/book/1")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_UTF8);
		MvcResult result = mvc.perform(builder).andReturn();
	}
}