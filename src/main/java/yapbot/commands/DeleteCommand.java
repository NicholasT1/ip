package yapbot.commands;

import yapbot.exceptions.YapBotException;
import yapbot.tasks.Task;
import yapbot.util.Storage;
import yapbot.util.TaskList;
import yapbot.util.Ui;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(String commandDetails) throws YapBotException {
        if (commandDetails.isEmpty()) {
            throw new YapBotException("Error, User Input Prediction module offline."
                    + "\nTask number must be manually entered (eg. \"1\", \"2\").");
        }

        if (commandDetails.contains(" ")) {
            index = Integer.parseInt(commandDetails.substring(0, commandDetails.indexOf(" "))) - 1;
        } else {
            index = Integer.parseInt(commandDetails) - 1;
        }
    }

    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws YapBotException {

        Task task = tasks.deleteTask(index);
        String successMessage =  "Finding Task...Success\nTask deleted from database:\n  " + task;
        ui.printOutput(successMessage);

        return true;
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
