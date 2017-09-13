package com.molarmak;

import com.molarmak.entity.JournalEntry;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	private final String SPRING_BOOT_MATCH = "Spring Boot";
	private final String CLOUD_MATCH = "Cloud";

	private HttpMessageConverter mappingJackson2HttpMessageConverter;
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(),
			Charset.forName("utf-8"));
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {
		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
				.filter(converter -> converter instanceof MappingJackson2HttpMessageConverter)
				.findAny().get();
	}

	@Before
    public void setup() throws Exception {
	    this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getAll() throws Exception {
	    mockMvc.perform(get("/journal/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", iterableWithSize(4)))
                .andExpect(jsonPath("$[0]['title']",containsString(SPRING_BOOT_MATCH)));
    }

    @Test
    public void findByuddTitle() throws Exception {
        mockMvc.perform(get("/journal/findBy/title/"+CLOUD_MATCH))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", iterableWithSize(1)))
                .andExpect(jsonPath("$[0]['title']",containsString(CLOUD_MATCH)));
    }

    @Test
    public void add() throws Exception {
	    mockMvc.perform(post("/journal")
                .content(this.toJsonString(new JournalEntry("Spring Boot Testing", "Create Spring Boot Tests", "05/09/2016")))
                .contentType(contentType))
                .andExpect(status().isOk());
    }

    @SuppressWarnings("unchecked")
    protected String toJsonString(Object obj) throws Exception {
	    MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
	    this.mappingJackson2HttpMessageConverter.write(obj, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
	    return mockHttpOutputMessage.getBodyAsString();
    }

	@Test
	public void contextLoads() {
	}

}
