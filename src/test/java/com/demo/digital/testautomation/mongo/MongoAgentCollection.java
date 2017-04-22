package com.demo.digital.testautomation.mongo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoAgentCollection {

    MongoCollection<Document> _collection;

    public MongoAgentCollection(final MongoCollection<Document> collection){
        this._collection= collection;
    }

    public FindIterable<Document> getAllDocuments(){
        return this._collection.find();
    }

    public FindIterable<Document> getMatchingDocuments(final Bson query){
        return this._collection.find(query);
    }
}
