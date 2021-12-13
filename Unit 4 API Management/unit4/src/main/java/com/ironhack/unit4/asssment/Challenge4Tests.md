package booksExample;

import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_returnAllBooksWithMatchingTitles_when_titleIsProvided() throws Exception {
        this.mockMvc.perform(get("/books").param("title", "Oliver Twist"))
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is("Oliver Twist")))
                .andExpect(jsonPath("$[0].isbn", is(4)));
    }
  
      @Test
    public void should_returnAllBooksWithMatchingAuthor_when_authorIsProvided() throws Exception {
        this.mockMvc.perform(get("/books").param("author", "Charles Dickens"))
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].title", is("Great Expectations")))
                .andExpect(jsonPath("$[0].isbn", is(1)))
                .andExpect(jsonPath("$[1].title", is("Oliver Twist")))
                .andExpect(jsonPath("$[1].isbn", is(4)));
    }

@Test
public void should_returnAllBooks_when_noTitleOrAuthorProvided() throws Exception {
this.mockMvc.perform(get("/books"))
.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
.andExpect(jsonPath("$", hasSize(8)))
.andExpect(jsonPath("$[0].title", is("Great Expectations")))
.andExpect(jsonPath("$[0].isbn", is(1)))
.andExpect(jsonPath("$[7].title", is("Aleph")))
.andExpect(jsonPath("$[7].isbn", is(8)));
}

@Test
public void should_returnListofSingleBookWithMatchingTitleAndAuthor_when_titleAndAuthorIsProvided() throws Exception {
this.mockMvc.perform(get("/books").param("author", "Charles Dickens").param ("title", "Great Expectations"))
.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
.andExpect(jsonPath("$", hasSize(1)))
.andExpect(jsonPath("$[0].title", is("Great Expectations")))
.andExpect(jsonPath("$[0].isbn", is(1)));
}

}