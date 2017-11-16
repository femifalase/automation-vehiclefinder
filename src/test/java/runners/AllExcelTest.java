package runners;

import com.richard.cordbyte.models.Document;
import com.richard.cordbyte.service.FileService;
import org.junit.Test;

import java.util.List;

public class AllExcelTest {


    @Test
    public void getExcelFiles() {

        FileService fileService = new FileService();

        List<Document> docs = fileService.getExelDocsFromDirectory("files");

        docs.stream().forEach(System.out::println);


    }
}
