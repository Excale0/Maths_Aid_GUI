package softeng206.a02;

import java.io.File;

/**
 * Created by Raymond Wang on 3/09/17.
 */
public class creationObject {
    private File _creationFile;
    private String _creationName;

    public creationObject(File creationFile){
        _creationFile = creationFile;
        _creationName = creationFile.getName().replace(".mp4","");
    }

    public File getSourceFile(){
        return _creationFile;
    }

    @Override
    public String toString() {
        return _creationName;
    }
}
