/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  student
 * Created: Mar 14, 2023
 */
USE Flight;

CREATE TABLE airlineAdmin(
	admin_id		number primary key not null,
	password		varchar(200) not null);

CREATE TABLE passenger(
	username		number primary key not null,
	password		varchar(200) not null);

CREATE TABLE passenger_info(
	email		        varchar(200) primary key not null,
	passenger_first_name	varchar(200) not null,
	passenger_last_name	varchar(200) not null,
	address		        varchar(200) not null,
	transactionOpt		varchar(200) not null);
	
CREATE TABLE airline(
	airline_name		varchar(200) primary key not null,
	contact_no		number not null);

CREATE TABLE flight(
	flight_no		number not null,
	flightDest		varchar(200) not null,
	flightDepart	        varchar(200) not null,
	arrival_time		varchar(200) not null,
	departure_time	        varchar(200) not null,
	price		        number not null;
	seatAvailability	boolean not null,
    foreign key (flight_no) references ticket(flight_no),
    PRIMARY KEY (flight_no)
    );

CREATE TABLE ticket(
	flight_no 		number primary key not null,
	passenger_first_name	varchar(200) not null,
	passenger_last_name	varchar(200) not null,
	numofPassenegers	number not null,
	flightDest		varchar(200) not null,
	flightDepart	        varchar(200) not null,
	arrival_time		varchar(200) not null,
	departure_time	        varchar(200) not null,
	date    	        date not null,
	seat_no    	        varchar(200) not null,
    foreign key(flight_no) references flight(flight_no),
    );