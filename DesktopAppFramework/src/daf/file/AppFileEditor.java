package daf.file;

import daf.data.AppDataManager;

/**
 * Interface used to support file editing.
 * 
 * @author Benjamin Shu
 */
public interface AppFileEditor extends AppFile {
    public void makeNewFile(AppDataManager data, String filePath);
    public void saveToFile(AppDataManager data, String filePath);
    public void loadFromFile(AppDataManager data, String filePath);
    public void importData(AppDataManager data, String filePath);
    public void exportData(AppDataManager data, String filePath);
}