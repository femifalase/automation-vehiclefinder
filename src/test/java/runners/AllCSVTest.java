package runners;

import com.richard.cordbyte.models.Document;
import com.richard.cordbyte.service.FileService;
import org.junit.Test;

import java.util.List;

public class AllCSVTest {


    @Test
    public void getCSVFiles() {

        FileService fileService = new FileService();

        List<Document> docs = fileService.getCSVDocsFromDirectory("files");

        docs.stream().forEach(System.out::println);

    }
}
