package com.divya.dao;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.divya.model.Loan;
import com.divya.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCursor;

// Mongo DB Code :)
public class DB {

	MongoClient mongoClient;

	public DB() {
		try {
			String connectionURL ="mongodb+srv://divya:divya@cluster0.qjge4.mongodb.net/gw2021java?retryWrites=true&w=majority";
	    	mongoClient = MongoClients.create(connectionURL);
		} catch (Exception e) {
			System.out.println("Something Went Wrong: "+e);
		}

	}


	public boolean registerUser(User user) {

		Document document = new Document(user.toMap());

    	//Insert into DataBase
    	mongoClient.getDatabase("gw2021java").getCollection("users").insertOne(document);
    	System.out.println(user.getName()+" Regsitered in MongoDB :)");

		return true;
	}
	
public boolean logLoanDetails( Loan loan) {
		
     	Document document = new Document(loan.toMap());
    	
    	//Insert into DataBase
    	mongoClient.getDatabase("gw2021java").getCollection("customers").insertOne(document);
    	System.out.println(loan.userId+" "+loan.borrowername+ "Saved in MongoDB");
		
		return true;
	}

public boolean loginUser(User user) {
	
	System.out.println("[DB] User Data:"+user);
	
	BasicDBObject query = new BasicDBObject();
	query.put("email", user.email);
	query.put("password", user.password);
	
	// Fetching the Data
	MongoCursor<Document> cursor = mongoClient.getDatabase("gw2021java").getCollection("users").find(query).iterator();
	//while(cursor.hasNext()) {
	//	System.out.println(cursor.next().toJson());
	//}
	
	
	boolean flag = cursor.hasNext();
	if(flag) {
		//System.out.println(cursor.next().toJson());
		Document document = cursor.next();
		System.out.println(document.getObjectId("_id"));
		System.out.println(document.getString("name"));
		
		user._id = document.getObjectId("_id").toString();
		user.name = document.getString("name");
		user.phonenumber= document.getString("phonenumber");
		System.out.println("[DB] User Data After Successful Login:"+user);
		
	}
	
	
	return flag;
}


	public void fetchUsers() {

		try {
			MongoCursor<Document> cursor = mongoClient.getDatabase("gw2021java").getCollection("admin").find().iterator();
	    	while(cursor.hasNext()) {
	    		//System.out.println(cursor.next());
	    		System.out.println(cursor.next().toJson());
	    	}
		}catch(Exception e) {
			System.out.println("Something Went Wrong: "+e);
		}

	}
public ArrayList<Loan> fetchLoans(String userId) {
		
		ArrayList<Loan> loanRecords = new ArrayList<Loan>();
		
		try {
			
			BasicDBObject query = new BasicDBObject();
			query.put("userId", userId);
			
	    	MongoCursor<Document> cursor = mongoClient.getDatabase("gw2021java").getCollection("customers").find(query).iterator();
	    	while(cursor.hasNext()) {
	    		
	    		Document document = cursor.next();
	    		Loan loan = new Loan();
	    		loan._id = document.getObjectId("_id").toString();
	    		loan.userId = document.getString("userId");
	    		loan.dateTimeStamp = document.getDate("dateTimeStamp").toString();
	    		loan.loan = document.getDouble("loan");
	            loan.duration = document.getDouble("duration");
	    		loan.borrowername= document.getString("borrowername");
	    		loan.ph  = document.getString("ph");	    		
	    		loan.address = document.getString("address");
	     		loan.rateofinterest = document.getDouble("rateofinterest");
	    		loan.interestearned= document.getDouble("interestearned");
	    		loan.totalvalue = document.getDouble("totalvalue");
	    		loanRecords.add(loan);
	    		
	    		System.out.println(loan);
	    		
	    	}
		}catch(Exception e) {
			System.out.println("Something Went Wrong: "+e);
		}
		
		return loanRecords;
    	
	}
//  public DBObject findDocumentById(String loanId) {
//
//    BasicDBObject query = new BasicDBObject();
//    query.put("loanId", new ObjectId(loanId));
//
//    DBObject dbObj = collection.findOne(query);
//    return dbObj;
//      }

public void updateDetails(String loanId ,String borrowername,String ph,String address,Double loan,Double rateofinterest, Double duration) {
	  
	BasicDBObject query = new BasicDBObject();
	query.put("_id", new ObjectId(loanId));
	
	System.out.println();
	
	System.out.println("loanId"+loanId);
	
	MongoCursor<Document> cursor = mongoClient.getDatabase("gw2021java").getCollection("customers").find(query).iterator();
	Document document = cursor.next();
	System.out.println(document.getObjectId("_id"));
	document.put("loan",loan);
	document.put("borrowername",borrowername);
	document.put("ph",ph);
	document.put("address",address);
	document.put("rateofinterest",rateofinterest);
	document.put("duration",duration);
	System.out.println("doc: "+document.toString());
	//Update into DataBase
	mongoClient.getDatabase("gw2021java").getCollection("customers").replaceOne(query, document);
	System.out.println("Loan Details Updated");
	
}

public void deleteDetails(String loanId) {
	
	System.out.println("[DB] Deleting Loan Record:"+loanId);
	
	BasicDBObject query = new BasicDBObject();
	
	query.put("_id", new ObjectId(loanId));
	
	// Fetching the Data
	mongoClient.getDatabase("gw2021java").getCollection("customers").deleteOne(query);
	
}



}