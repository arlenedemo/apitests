package com.hsbc.digital.testautomation.mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

@SuppressWarnings("Since15")
public class MongoAgent implements AutoCloseable{

    private MongoClient _server;
    private MongoDatabase _database;

    public MongoAgent(final String host, final int port, final String databaseName){
        this._server = new MongoClient(host, port);
        this._database = this._server.getDatabase(databaseName);
    }

    public MongoAgentCollection useCollection(final String collectionName){
        return new MongoAgentCollection(this._database.getCollection(collectionName));
    }

    public void close() throws Exception{
        this._server.close();
    }

}
