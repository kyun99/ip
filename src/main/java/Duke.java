import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?");
        Scanner in = new Scanner(System.in);
        TaskList list = new TaskList();
        String request = in.nextLine();
        while (!request.equals("bye")) {
            try {
                if (request.equals("list")) {
                    list.printTasks();
                } else if (request.startsWith("done")) { //Should check if it is a task or a command instead
                    list.doneTask(request);
                } else {
                    list.addTask(request);
                }
                request = in.nextLine();
            } catch (Exception ex) {
                System.out.println("Heyyyy, I can't do that...");
                request = in.nextLine();
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
