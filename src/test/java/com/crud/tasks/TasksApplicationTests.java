package com.crud.tasks;

import static org.assertj.core.api.Assertions.assertThat;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CoreConfiguration;
import com.crud.tasks.controller.TaskController;
import com.crud.tasks.controller.TrelloController;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.mapper.TrelloMapper;
import com.crud.tasks.scheduler.EmailScheduler;
import com.crud.tasks.service.DbService;
import com.crud.tasks.service.SimpleEmailService;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.client.TrelloClient;
import com.crud.tasks.trello.config.TrelloConfig;
import com.crud.tasks.trello.facade.TrelloFacade;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TasksApplicationTests {

	@Autowired
	private TaskController taskController;
	@Autowired
	private TrelloController trelloController;
	@Autowired
	private AdminConfig adminConfig;
	@Autowired
	private CoreConfiguration coreConfiguration;
	@Autowired
	private TaskMapper taskMapper;
	@Autowired
	private TrelloMapper trelloMapper;
	@Autowired
	private EmailScheduler emailScheduler;
	@Autowired
	private DbService dbService;
	@Autowired
	private SimpleEmailService simpleEmailService;
	@Autowired
	private TrelloService trelloService;
	@Autowired
	private TrelloClient trelloClient;
	@Autowired
	private TrelloConfig trelloConfig;
	@Autowired
	private TrelloFacade trelloFacade;
	@Autowired
	private TrelloValidator trelloValidator;

	@Test
	public void contextLoads() throws Exception {
		assertThat(taskController).isNotNull();
		assertThat(trelloController).isNotNull();
		assertThat(adminConfig).isNotNull();
		assertThat(coreConfiguration).isNotNull();
		assertThat(taskMapper).isNotNull();
		assertThat(trelloController).isNotNull();
		assertThat(emailScheduler).isNotNull();
		assertThat(dbService).isNotNull();
		assertThat(simpleEmailService).isNotNull();
		assertThat(trelloService).isNotNull();
		assertThat(trelloClient).isNotNull();
		assertThat(trelloConfig).isNotNull();
		assertThat(trelloFacade).isNotNull();
		assertThat(trelloValidator).isNotNull();
	}
}
