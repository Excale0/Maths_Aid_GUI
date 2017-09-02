package softeng206.a02;

import javafx.concurrent.Task;

/**
 * Created by Raymond Wang on 2/09/17.
 */
public class creationWorker extends Task<Void> {

    private String _creationName;

    public creationWorker(String creationName){
        _creationName = creationName;
    }

    @Override
    protected Void call() throws Exception {
         String creationCommand = "ffmpeg -f lavfi -i color=c=blue:s=1280x720:d=3 -vf " + "drawtext=fontsize=60: \\ " +
                                  "fontcolor=white:x=(w-text_w)/2:y=(h-text_h)/2:text=\"" + _creationName + "\"\" " +
                                  "./Temporary_files/" + _creationName + ".mp4 &> /dev/null";

        ProcessBuilder creationProcessBuilder = new ProcessBuilder("/bin/bash","-c",creationCommand);
        Process creationProcess = creationProcessBuilder.start();


        return null;
    }
}
