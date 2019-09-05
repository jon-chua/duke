package duke.main;

import duke.exception.DukeException;
import duke.task.Task;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    TaskList() {
        this.tasks = new ArrayList<>();
    }

    TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Gets all tasks present.
     *
     * @return The list of all tasks.
     */
    public ArrayList<Task> getAllTasks() {
        return tasks;
    }

    /**
     * Returns the task given the zero based index of the task.
     *
     * @param zeroBasedIndex The given index to be returned.
     */
    public Task get(int zeroBasedIndex) {
        return tasks.get(zeroBasedIndex);
    }

    /**
     * Marks a task as done given the zero based index of the task.
     *
     * @param zeroBasedIndex The given index to be deleted.
     */
    public void markTaskAsDone(int zeroBasedIndex) {
        tasks.get(zeroBasedIndex).markAsDone();
    }

    /**
     * Adds a task to the back of the list.
     *
     * @param task The task to be added.
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a task from the list given the zero based index of the task.
     *
     * @param zeroBasedIndex The given index to be deleted.
     */
    public void delete(int zeroBasedIndex) throws DukeException {
        if (zeroBasedIndex < 0 || zeroBasedIndex >= tasks.size()) {
            throw new DukeException("OOPS!!! The index to remove cannot be less than 0 or "
                    + "greater than the length of the list.");
        }

        tasks.remove(zeroBasedIndex);
    }

    /**
     * Returns the size of the task list.
     *
     * @return The size of the list.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Finds tasks in the list containing the given String in their description.
     *
     * @param toFind The criteria to filter tasks.
     * @return An ArrayList containing all tasks containing thg given String in their description.
     */
    public ArrayList<Task> find(String toFind) {
        ArrayList<Task> filteredTasks = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getDescription().contains(toFind)) {
                filteredTasks.add(t);
            }
        }
        return filteredTasks;
    }
}
