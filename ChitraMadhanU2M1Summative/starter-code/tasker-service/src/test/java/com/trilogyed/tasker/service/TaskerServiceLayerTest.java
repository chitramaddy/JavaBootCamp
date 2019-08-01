package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class TaskerServiceLayerTest {

    TaskerDao taskerDao;
    DiscoveryClient discoveryClient;
    RestTemplate restTemplate;

    TaskerServiceLayer taskerService;

    @Before
    public void setUp() throws Exception {

        setUpTaskerDaoMock();
        setUpRestTemplateMock();
        setUpDiscoveryClientMock();

        taskerService = new TaskerServiceLayer(taskerDao, discoveryClient, restTemplate,
                "adserver-service", "http://", "/ad" );
    }

    private void setUpRestTemplateMock() {

        restTemplate = mock(RestTemplate.class);

        doReturn("BOGO large 2 topping pizzas!").when(restTemplate)
                .getForObject("http://localhost:6107/ad", String.class);
    }

    private void setUpDiscoveryClientMock(){

        discoveryClient = mock(DiscoveryClient.class);

        List<ServiceInstance> instances = new LinkedList<>();

        DefaultServiceInstance defaultServiceInstance = new DefaultServiceInstance("","","localhost",6107,true);

        instances.add(defaultServiceInstance);
        System.out.println(instances.get(0));

        doReturn(instances).when(discoveryClient).getInstances("adserver-service");
    }


    private void setUpTaskerDaoMock(){

        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);

        Task task = new Task();
        task.setId(1);
        task.setDescription("Summative");
        task.setCreateDate(LocalDate.of(2019,07,25));
        task.setDueDate(LocalDate.of(2019,07,31));
        task.setCategory("Homework");

        Task task1 = new Task();
        task1.setDescription("Summative");
        task1.setCreateDate(LocalDate.of(2019,07,25));
        task1.setDueDate(LocalDate.of(2019,07,31));
        task1.setCategory("Homework");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        doReturn(task).when(taskerDao).createTask(task1);
        doReturn(task).when(taskerDao).getTask(1);
        doReturn(taskList).when(taskerDao).getAllTasks();
        doReturn(taskList).when(taskerDao).getTasksByCategory("Homework");
    }
    @Test
    public void getAdvertisement() {

        List<ServiceInstance> instances = discoveryClient.getInstances("adserver-service");

        String Advertisement = restTemplate.getForObject("http://localhost:6107/ad", String.class);

    }

    @Test
    public void createAndFetchTask() {

        TaskViewModel task = new TaskViewModel();

        task.setDescription("Summative");
        task.setCreateDate(LocalDate.of(2019,07,25));
        task.setDueDate(LocalDate.of(2019,07,31));
        task.setCategory("Homework");
        taskerService.newTask(task);

        TaskViewModel fromService = taskerService.fetchTask(task.getId());
        assertEquals(task, fromService);
    }

    @Test
    public void fetchAllTasks() {

        TaskViewModel task = new TaskViewModel();

        task.setDescription("Summative");
        task.setCreateDate(LocalDate.of(2019,07,25));
        task.setDueDate(LocalDate.of(2019,07,31));
        task.setCategory("Homework");
        task = taskerService.newTask(task);

        List<TaskViewModel> taskViewModels = taskerService.fetchAllTasks();
        assertEquals(1, taskViewModels.size());
    }

    @Test
    public void fetchTasksByCategory() {

        TaskViewModel task = new TaskViewModel();

        task.setDescription("Summative");
        task.setCreateDate(LocalDate.of(2019,07,25));
        task.setDueDate(LocalDate.of(2019,07,31));
        task.setCategory("Homework");
        task = taskerService.newTask(task);

        List<TaskViewModel> taskViewModels = taskerService.fetchTasksByCategory("Homework");

        assertEquals(1, taskViewModels.size());
    }
}