package softeng206.a02;

import javafx.concurrent.Task;

/**
 * Created by Raymond Wang on 3/09/17.
 */
public class audioCreationWorker extends creationWorker {

    public audioCreationWorker(String creationName){
        _creationName = creationName;
    }

    @Override
    protected Void call() throws Exception {
        _processor.createAudioFile(_creationName);

        return null;
    }
}
