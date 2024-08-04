package org.example.filemanager;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManagerController {

    private static final String TARGET_FOLDER = "StoredFiles";

    @FXML
    private void handleSelectFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Stage stage = new Stage();
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            storeFile(selectedFile);
        }
    }

    private void storeFile(File file) {
        try {
            // Create target folder if it doesn't exist
            Path targetFolderPath = Paths.get(TARGET_FOLDER);
            if (!Files.exists(targetFolderPath)) {
                Files.createDirectory(targetFolderPath);
            }

            // Copy file to target folder
            Path targetFilePath = targetFolderPath.resolve(file.getName());
            Files.copy(file.toPath(), targetFilePath);
            System.out.println("File stored at: " + targetFilePath);
        } catch (IOException e) {
            System.err.println("Failed to store file: " + e.getMessage());
        }
    }
}
