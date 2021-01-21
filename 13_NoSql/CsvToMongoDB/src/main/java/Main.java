import com.fasterxml.jackson.core.JsonProcessingException;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient( "localhost" , 3678 );

        List<Student> students = readCsvFile("src/mongo.csv");

        MongoDatabase database = mongoClient.getDatabase("test");
        database.createCollection("students");

        List <Document> documents = new ArrayList<>();
        for (Student student : students) {
            Document document = new Document();
            document.append("name", student.getName());
            document.append("age", student.getAge());
            document.append("courses", student.getCourses());
            documents.add(document);
        }

        database.getCollection("students").insertMany(documents);
    }


    private static List<Student> readCsvFile(String filePath) {
        BufferedReader fileReader = null;
        CSVParser csvParser = null;

        List<Student> students = new ArrayList<Student>();

        try {
            fileReader = new BufferedReader(new FileReader(filePath));
            csvParser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                String name = csvRecord.get(0);
                String age = csvRecord.get(1);

                List<String> courses = Arrays.asList(csvRecord.get(2).split("\\s*,\\s*"));

                Student student = new Student(name, age, courses);

                students.add(student);
            }

        } catch (Exception e) {
            System.out.println("Reading CSV Error!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                csvParser.close();
            } catch (IOException e) {
                System.out.println("Closing fileReader/csvParser Error!");
                e.printStackTrace();
            }
        }

        return students;
    }

}
