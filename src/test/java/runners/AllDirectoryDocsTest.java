package runners;

import com.richard.cordbyte.models.Document;
import com.richard.cordbyte.service.FileService;
import org.junit.Test;

import java.util.List;

public class AllDirectoryDocsTest {




    @Test
    public void getDirectoryFiles(){

        FileService fileService = new FileService();

        List<Document> docs = fileService.getAllDocsFromDirectory("files");

        for (Document doc : docs) {
            System.out.println(doc.toString());
        }


    }
}
