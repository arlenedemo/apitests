package com.demo.digital.testautomation.mongo;

import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.bson.conversions.Bson;

import static org.junit.Assert.assertTrue;

/**
 * Created by arlene.lehakra on 10/04/2017.
 */
public class MongoAgentCollectionQuery {

    public static boolean findDocumentInCollectionUsingQuery(final MongoAgent agent, final Bson query){

        boolean foundResult= false;
        FindIterable<Document> cursor = agent.useCollection("CallBackResult").getMatchingDocuments(query);
        foundResult=cursor.iterator().hasNext();

        return foundResult;
    }

}
