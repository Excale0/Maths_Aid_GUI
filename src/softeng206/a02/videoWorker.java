package softeng206.a02;

import javafx.concurrent.Task;

/**
 * Created by Raymond Wang on 2/09/17.
 */
public class videoWorker extends creationWorker {

    public videoWorker(String creationName){
        _creationName = creationName;
    }

    @Override
    protected Void call() throws Exception {
        _processor.createFFMPEGVideo(_creationName);

        return null;
    }
}
