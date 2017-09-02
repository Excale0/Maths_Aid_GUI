package softeng206.a02;

import java.io.IOException;

/**
 * Created by Raymond Wang on 2/09/17.
 */
public class BashCommandProcessor {
    private String _command;

    public BashCommandProcessor(){

    }

    public BashCommandProcessor(String command){
        _command = command;
    }

    public boolean creationExists(String creation) throws Exception{
        _command = "test -e ./Creations/" + creation + ".mp4";
        int exitCode = this.execute();
        if (exitCode == 0){
            return false;
        }
        return true;
    }

    public void createFolders() throws Exception{
        _command = "mkdir Creations Temporary_files";
        this.execute();
    }

    public void deleteCreation(String creation) throws Exception{
        _command = "rm ./Creations/" + creation +".mp4";
        this.execute();
    }

    public void createFFMPEGVideo(String text) throws Exception{
        _command = "ffmpeg -f lavfi -i color=c=blue:s=1280x720:d=3 -vf " + "drawtext=fontsize=60: \\ " +
                "fontcolor=white:x=(w-text_w)/2:y=(h-text_h)/2:text=\"" + text + "\"\" " +
                "./Temporary_files/" + text + ".mp4";
        this.execute();
    }

    public void createAudioFile(String creationName) throws Exception{
        _command = "ffmpeg -f alsa -i default -t 3 -acodec pcm_s16le -ar 16000 -ac 1 -y ./Temporary_files/"
                + creationName +".wav";
        this.execute();
    }

    public void muxVideoAndAudio(String creationName) throws Exception{
        _command = "ffmpeg -i ./Temporary_files/"+ creationName +".mp4 -i ./Temporary_files/"+ creationName +".wav -c:v copy -c:a aac " +
                "-strict experimental ./Creations/"+ creationName +".mp4";
        this.execute();
    }

    public int execute() throws Exception{
        ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash","-c",_command);
        Process bashProcess = processBuilder.start();
        bashProcess.waitFor();
        return bashProcess.exitValue();
    }


}
