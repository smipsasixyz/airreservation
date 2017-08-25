CREATE DATABASE air;
use air;
CREATE TABLE UserProfile(UPID  MEDIUMINT NOT NULL AUTO_INCREMENT, 
                      fname VARCHAR(150) NOT NULL,
                      lname VARCHAR(150) NOT NULL,
                      username VARCHAR(150) NOT NULL UNIQUE,
                      email VARCHAR(150) NOT NULL UNIQUE,
                      PRIMARY KEY (UPID));
                      
CREATE TABLE LoginUser (LUID  MEDIUMINT NOT NULL AUTO_INCREMENT, 
					 email VARCHAR(150) NOT NULL,
                     pass VARCHAR(150) NOT NULL,
                     PRIMARY KEY (LUID),
					 FOREIGN KEY (email)
					 REFERENCES UserProfile(email)
					 ON DELETE CASCADE
					 );

CREATE TABLE flight (fid  MEDIUMINT NOT NULL AUTO_INCREMENT,
				  fnum MEDIUMINT NOT NULL,
                  origin VARCHAR(200) NOT NULL ,
				  destination VARCHAR(200) NOT NULL ,        
                  dtime time NOT NULL,
                  atime time NOT NULL,
                  nseats MEDIUMINT NOT NULL,
                  price  decimal(10,4) NOT NULL, 
                  PRIMARY KEY (fid));
                     
CREATE TABLE CreditCard (ccID  MEDIUMINT NOT NULL AUTO_INCREMENT,
                         cnumber varchar(100) NOT NULL,
                         cvv  varchar(100) NOT NULL,
                         amount decimal(10,4) NOT NULL,
						 PRIMARY KEY (ccID));

CREATE TABLE Transact (TransID  MEDIUMINT NOT NULL AUTO_INCREMENT,
                          UPID MEDIUMINT NOT NULL,
                          Trans_Amount DEC(10,4),
                          Trans_Date datetime,
                          Trans_Status VARCHAR(200),
                          PRIMARY KEY (TransID),
                          FOREIGN KEY (UPID)
					      REFERENCES UserProfile(UPID)
					      ON DELETE CASCADE);
                          
CREATE TABLE Reservation(rID  MEDIUMINT NOT NULL AUTO_INCREMENT , 
						 confnbr varchar(6) NOT NULL,
                        nooftic   MEDIUMINT NOT NULL,
						fid MEDIUMINT NOT NULL,
                      UPID  MEDIUMINT NOT NULL,
                      TransID    MEDIUMINT NOT NULL,
                      PRIMARY KEY (rID),
                      FOREIGN KEY (fid)
					 REFERENCES  Flight(fid)
					 ON DELETE CASCADE,
                     FOREIGN KEY (UPID)
					 REFERENCES  userprofile(UPID)
					 ON DELETE CASCADE,
                     FOREIGN KEY (TransID)
					 REFERENCES  Transact(TransID)
					 ON DELETE CASCADE);
                     
                     
CREATE TABLE Passengers(PID  MEDIUMINT NOT NULL AUTO_INCREMENT, 
                      pfname VARCHAR(150) NOT NULL,
                      plname VARCHAR(150) NOT NULL,
                      dob date NOT NULL,
                      email VARCHAR(150) NOT NULL ,
                     rID MEDIUMINT NOT NULL,
                      PRIMARY KEY (PID),
                      FOREIGN KEY (rID)
					 REFERENCES  Reservation(rID)
					 ON DELETE CASCADE);
                          

insert into flight(fnum,origin,destination,dtime,atime,nseats,price) values( 123,'DFW','NYI','13:20:00',"15:20:00",10,900);
insert into flight(fnum,origin,destination,dtime,atime,nseats,price) values( 321,'DFW','NYI','13:20:00',"15:20:00",20,400);

insert into userprofile(fname,lname,username,email) values('Bala','Koduru','smipsasi','sasidhar@gmail.com');
insert into userprofile(fname,lname,username,email) values('Bala Sasidhar','Reddy','smipsasixyz','smipsasixyz@gmail.com');
insert into loginuser(email,pass) values('sasidhar@gmail.com','sasidhar721');
insert into loginuser(email,pass) values('smipsasixyz@gmail.com','sasidhar721');

insert into creditcard(cnumber,cvv,amount) values('C6B25FFAC5D2C50F41AF3AC4D97D07D95FD4F2D5F9FCEF98DC709E5741060508','A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3',200000);
insert into creditcard(cnumber,cvv,amount) values('F5F6CBBC4AE957ADCEC7EE851A0BA1D64314EFB523BE0E28A7BF96DFAEE41A99','B3A8E0E1F9AB1BFE3A36F231F676F78BB30A519D2B21E6C530C0EEE8EBB4A5D0',100000);
	