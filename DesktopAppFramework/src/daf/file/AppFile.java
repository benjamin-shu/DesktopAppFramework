package daf.file;

import daf.data.AppDataManager;

/**
 * Interface used to define methods for basic file I/O.
 * The AppFile interface assumes that the application 
 * will not need to rename files or create new ones, and only 
 * supports loading/saving data. For more specific file I/O, 
 * applications should use the AppFileEditor interface.
 * 
 * @author Benjamin Shu
 */
public interface AppFile {
    public void saveData(AppDataManager data, String filePath);
    public void loadData(AppDataManager data, String filePath);
}