package com.EmployeeBenefit.repository;

import com.EmployeeBenefit.model.Employee;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.var;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Configuration
public class EmployeeRepository {
    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Value("${spring.data.mongodb.port}")
    private String mongoPort;

    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @Value("${spring.data.mongodb.collection}")
    private String collectionName;

    private MongoDatabase dbConnection = null;
    private MongoCollection<Document> collection = null;

    private MongoDatabase getDbConnection() {
        if (dbConnection == null) {

            MongoClient mongoClient = MongoClients.create("mongodb:// " + mongoHost + ":" + mongoPort);

            dbConnection = mongoClient.getDatabase(dbName);
            collection = dbConnection.getCollection(collectionName);

        }
        return dbConnection;
    }

    public String insert(Employee employee) {
        if (dbConnection == null)
            this.getDbConnection();

        ArrayList docs = new ArrayList<Document>();
        var d1 = new Document("registration_id", employee.getRegistration_id());
        d1.append("id", employee.getId());
        d1.append("name", employee.getName());
        d1.append("email", employee.getEmail());
        d1.append("dept", employee.getDept());
        docs.add(d1);
        collection.insertOne(d1);

        return employee.getRegistration_id();

    }
}
