package duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public abstract class FileHandler {
    public static void writeFile(TaskList list, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        for(int i = 0; i < list.size(); i++) {
            writer.write(list.saveTask(i) + "\n");
        }
        writer.close();
    }

    public static void readFile(TaskList list, File file) throws FileNotFoundException {
        Scanner s = new Scanner(file);
        while (s.hasNext()){
            String[] taskInfo = s.nextLine().split(",");
            if (taskInfo[0].equals("duke.Task")) {
                Task todo = new Task(Boolean.parseBoolean(taskInfo[1]), taskInfo[2]);
                list.loadTask(todo);
            } else if (taskInfo[0].equals("duke.Event")) {
                Task event = new Event(Boolean.parseBoolean(taskInfo[1]),taskInfo[2], taskInfo[3]);
                list.loadTask(event);
            } else {
                Task deadline = new Deadline(Boolean.parseBoolean(taskInfo[1]), taskInfo[2], taskInfo[3]);
                list.loadTask(deadline);
            }
        }
    }

    public static File loadFile() throws IOException {
        File file = new File("data/duke.txt");
        if (!file.exists()) {
            File dir = new File("data");
            dir.mkdir();
            File newFile = new File("data/duke.txt");
            newFile.createNewFile();
            return newFile;
        }
        return file;
    }
}