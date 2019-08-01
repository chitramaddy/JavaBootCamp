package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoJdbcTemplateImplTest {

    @Autowired
    TaskerDao taskerDao;

    @Before
    public void setUp() throws Exception {

        List<Task> tasks = taskerDao.getAllTasks();

        tasks.stream()
                .forEach(task -> taskerDao.deleteTask(task.getId()));
    }


    @Test
    public void createGetDeleteTask() {

        Task task = new Task();

        task.setDescription("Summative");
        task.setCreateDate(LocalDate.of(2019,07,25));
        task.setDueDate(LocalDate.of(2019,07,31));
        task.setCategory("Homework");

        task = taskerDao.createTask(task);

        Task fromDao = taskerDao.getTask(task.getId());
        assertEquals(fromDao, task);

        taskerDao.deleteTask(task.getId());
        fromDao = taskerDao.getTask(task.getId());

        assertNull(fromDao);
    }

    @Test
    public void getAllTasks() {

        Task task = new Task();

        task.setDescription("new task");
        task.setCreateDate(LocalDate.of(2019,07,25));
        task.setDueDate(LocalDate.of(2019, 07, 28));
        task.setCategory("Summative");

        taskerDao.createTask(task);

        task = new Task();
        task.setDescription("second new task");
        task.setCreateDate(LocalDate.of(2019,07,24));
        task.setDueDate(LocalDate.of(2019, 07, 28));
        task.setCategory("Homework");
        taskerDao.createTask(task);

        List<Task> taskList = taskerDao.getAllTasks();
        assertEquals(2, taskList.size());
    }

    @Test
    public void getTasksByCategory() {

        Task task = new Task();

        task.setDescription("task service");
        task.setCreateDate(LocalDate.of(2019,07,25));
        task.setDueDate(LocalDate.of(2019, 07, 28));
        task.setCategory("Summative");

        taskerDao.createTask(task);

        task = new Task();

        task.setDescription("ad service");
        task.setCreateDate(LocalDate.of(2019,07,25));
        task.setDueDate(LocalDate.of(2019, 07, 28));
        task.setCategory("Summative");

        taskerDao.createTask(task);

        List<Task> taskList = taskerDao.getTasksByCategory("Summative");
        assertEquals(2, taskList.size());

    }

    @Test
    public void updateTask() {

        Task task = new Task();

        task.setDescription("new task");
        task.setCreateDate(LocalDate.of(2019,07,25));
        task.setDueDate(LocalDate.of(2019, 07, 28));
        task.setCategory("Summative");

        task = taskerDao.createTask(task);

        task.setDescription("new task");
        task.setCreateDate(LocalDate.of(2019,07,25));
        task.setDueDate(LocalDate.of(2019, 07, 28));
        task.setCategory("Summative 7");

        taskerDao.updateTask(task);
        Task fromDao = taskerDao.getTask(task.getId());
        assertEquals(fromDao, task);

    }

}