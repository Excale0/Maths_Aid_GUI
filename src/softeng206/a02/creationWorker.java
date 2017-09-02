package softeng206.a02;

import javafx.concurrent.Task;

/**
 * Created by Raymond Wang on 3/09/17.
 */
public abstract class creationWorker extends Task<Void> {
    protected String _creationName;
    protected BashCommandProcessor _processor = new BashCommandProcessor();
}
