package com.divya.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
	
public class Loan {
		
		public String _id;
		public String userId;
		public double loan;
		public double duration;
		public String dateTimeStamp;
		public String borrowername;
		public String ph;
		public String address;
		public double rateofinterest;
		public double interestearned;
		public double totalvalue;
		//public String type;
		
		
		
		public Loan() {
			
		}
		
	
		public Loan(String _id, String userId, double loan, double duration, String dateTimeStamp,
				String borrowername, String ph, String address,double rateofinterest ,double interestearned ,double totalvalue) {
			super();
			this._id = _id;
			this.userId = userId;
			this.loan = loan;
			this.duration = duration;
			this.dateTimeStamp = dateTimeStamp;
			this.borrowername = borrowername;
			this.ph = ph;
			this.address = address;
			this.rateofinterest = rateofinterest;	
			this.interestearned = interestearned;
			this.totalvalue = totalvalue;
			//this.type = type;
			}


        	public Map toMap() {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userId", userId);
			map.put("loan", loan);
			map.put("dateTimeStamp", new Date());
            map.put("duration",duration);
            map.put("borrowername",borrowername);
            map.put("ph",ph);
            map.put("address",address);
            map.put("rateofinterest", rateofinterest);
            map.put("interestearned",interestearned);
            map.put("totalvalue", totalvalue);
          //  map.put("type", type);
			return map;
		}


			@Override
			public String toString() {
				return "Loan [_id=" + _id + ", userId=" + userId + ", loan=" + loan + ", duration=" + duration
						+ ", dateTimeStamp=" + dateTimeStamp + ", borrowername=" + borrowername + ", ph=" + ph
						+ ", address=" + address + ", rateofinterest=" + rateofinterest + ", interestearned="
						+ interestearned + ", totalvalue=" + totalvalue + "]";
			}



		



		
	 

		
	}


