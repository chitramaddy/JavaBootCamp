package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

    @Autowired
    TaskerDao dao;

    @Autowired
    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate;

    @Value("${randomAdServerServiceName}")
    private String randomAdserverServiceName;

    @Value("${serviceProtocol}")
    private String serviceProtocol;

    @Value("${servicePath}")
    private String servicePath;

    @Autowired
    public TaskerServiceLayer() {

    }

    public TaskerServiceLayer(TaskerDao dao, DiscoveryClient discoveryClient,
                              RestTemplate restTemplate, String randomAdserverServiceName,
                              String serviceProtocol, String servicePath) {
        this.dao = dao;
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
        this.randomAdserverServiceName = randomAdserverServiceName;
        this.serviceProtocol = serviceProtocol;
        this.servicePath = servicePath;
    }

    public String getAdvertisement(){
        List<ServiceInstance> instances = discoveryClient.getInstances(randomAdserverServiceName);
        String randomAdserverUri = serviceProtocol + instances.get(0).getHost() + ":" + instances.get(0).getPort() + servicePath;
        String advertisement = restTemplate.getForObject(randomAdserverUri, String.class);

        return advertisement;

    }

    public TaskViewModel fetchTask(int id) {

            Task task = dao.getTask(id);
            TaskViewModel tvm = new TaskViewModel();

            tvm.setId(task.getId());
            tvm.setDescription(task.getDescription());
            tvm.setCreateDate(task.getCreateDate());
            tvm.setDueDate(task.getDueDate());
            tvm.setCategory(task.getCategory());
            tvm.setAdvertisement(getAdvertisement());

            return tvm;

    }

    public List<TaskViewModel> fetchAllTasks() {

        List<Task> taskList = dao.getAllTasks();
        List<TaskViewModel>taskViewModels = new ArrayList<>();

        for(Task task:taskList){
            TaskViewModel tvm = new TaskViewModel();

            tvm.setId(task.getId());
            tvm.setDescription(task.getDescription());
            tvm.setCreateDate(task.getCreateDate());
            tvm.setDueDate(task.getDueDate());
            tvm.setCategory(task.getCategory());
            tvm.setAdvertisement(getAdvertisement());

            taskViewModels.add(tvm);

        }
        return taskViewModels;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<Task> taskList = dao.getTasksByCategory(category);
        List<TaskViewModel>taskViewModels = new ArrayList<>();

        for(Task task:taskList){
            TaskViewModel tvm = new TaskViewModel();

            tvm.setId(task.getId());
            tvm.setDescription(task.getDescription());
            tvm.setCreateDate(task.getCreateDate());
            tvm.setDueDate(task.getDueDate());
            tvm.setCategory(task.getCategory());
            tvm.setAdvertisement(getAdvertisement());

            taskViewModels.add(tvm);

        }
        return taskViewModels;
    }

    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        task = dao.createTask(task);
        taskViewModel.setId(task.getId());
        taskViewModel.setAdvertisement(getAdvertisement());

        return taskViewModel;
    }

    public void deleteTask(int id) {
        dao.deleteTask(id);

    }

    public void updateTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());
        task.setId(taskViewModel.getId());

        dao.updateTask(task);
    }
}
