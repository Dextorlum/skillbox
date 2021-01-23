import com.fasterxml.jackson.core.JsonProcessingException;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
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

import static com.mongodb.client.model.Aggregates.sort;
import static com.mongodb.client.model.Filters.gt;

public class Main {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient( "localhost" , 3678 );

        List<Student> students = readCsvFile("src/mongo.csv");

        MongoDatabase database = mongoClient.getDatabase("test");
//        database.createCollection("students");

        List <Document> documents = new ArrayList<>();
        for (Student student : students) {
            Document document = new Document();
            document.append("name", student.getName());
            document.append("age", student.getAge());
            document.append("courses", student.getCourses());
            documents.add(document);
        }

        MongoCollection<Document> mongoCollection = database.getCollection("students");
        mongoCollection.drop();
        mongoCollection.insertMany(documents);

        System.out.println("Количество студентов - " + mongoCollection.countDocuments());

        Document oldestStudent = mongoCollection.aggregate(Arrays.asList(sort(Sorts.descending("age")))).first();

        System.out.println("Самый старый студент - " + oldestStudent.get("name") + " Возраст - " + oldestStudent.get("age"));
        System.out.println("Список курсор самого старого клиента - " + oldestStudent.get("courses").toString());
        System.out.println("Количество студентов старше 40 " + mongoCollection.countDocuments(gt("age", "40")));
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
