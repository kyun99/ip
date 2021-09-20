package duke;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public int size() {
        return tasks.size();
    }

    public String saveTask(int taskIndex) {
        Task task = tasks.get(taskIndex);
        return task.saveFormat();
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task doneTask(int taskIndex) {
        Task task = tasks.get(taskIndex);
        task.setDone();
        return task;
    }

    public Task deleteTask(int taskIndex) {
        try {
            return tasks.remove(taskIndex);
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new ArrayIndexOutOfBoundsException("☹ OOPS!!! The format for 'delete' is 'delete <task number>'");
        } catch (IndexOutOfBoundsException ex) {
            throw new IndexOutOfBoundsException("☹ OOPS!!! The list does not have that many task ><");
        }
    }
}

