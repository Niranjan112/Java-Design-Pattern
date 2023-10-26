package designpattern.behavioral.command;

import java.util.ArrayList;
import java.util.List;

class TextFile {

    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    public String open() {
        return "Opening file " + name;
    }

    public String save() {
        return "Saving file " + name;
    }
}

@FunctionalInterface
interface TextFileOperation {
    String execute();
}

class OpenTextFileOperation implements TextFileOperation{

    private TextFile textFile;

    public OpenTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.open();
    }
}

class SaveTextFileOperation implements TextFileOperation{
    private TextFile textFile;

    public SaveTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.save();
    }
}

class TextFileOperationExecutor {

    private final List<TextFileOperation> textFileOperations
            = new ArrayList<>();

    public String executeOperation(TextFileOperation textFileOperation) {
        textFileOperations.add(textFileOperation);
        return textFileOperation.execute();
    }
}

public class CommandPatternEx {
    public static void main(String[] args) {
        TextFileOperationExecutor textFileOperationExecutor
                = new TextFileOperationExecutor();

        textFileOperationExecutor.executeOperation(
                new OpenTextFileOperation(new TextFile("file1.txt")));

        textFileOperationExecutor.executeOperation(
                new SaveTextFileOperation(new TextFile("file2.txt")));
    }
}
