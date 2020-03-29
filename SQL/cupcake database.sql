DROP DATABASE IF EXISTS `cupcake`;
CREATE DATABASE IF NOT EXISTS `cupcake`;
use cupcake;

CREATE TABLE Roles (
	Roleid int NOT NULL,
    UserRole varchar(15) NOT NULL,
    PRIMARY KEY (Roleid)
);

INSERT INTO Roles (RoleId,UserRole)
VALUES (10,"administrator");
INSERT INTO Roles (RoleId,UserRole)
VALUES (20,"customer");

CREATE TABLE Users (
	UserId int auto_increment,
	Email varchar(50) NOT NULL UNIQUE,
    UserPassword varchar(20) NOT NULL,
    Credit decimal(9,2) DEFAULT 0,
    RoleId int DEFAULT 20,
    FullName varchar(100),
    Phone varchar(20),
    Address varchar (200),
    PRIMARY KEY (UserId),
    FOREIGN KEY (RoleId) REFERENCES Roles (RoleId)
);
ALTER TABLE Users auto_increment=1000;

INSERT INTO Users (Email, UserPassword)
Values ("Alice@Cooper.com","pass1234");
INSERT INTO Users (Email, UserPassword)
Values ("Frank@Zappa.com","pass1234");
INSERT INTO Users (Email, UserPassword)
Values ("Pink@Floyd.com","pass1234");
INSERT INTO Users (Email, UserPassword)
Values ("David@Bowie.com","pass1234");
INSERT INTO Users (Email, UserPassword, RoleId)
Values ("Admin","admin",10);

CREATE TABLE Top (
	TopType varchar(15) NOT NULL,
    Price decimal(5,2) NOT NULL,
    PRIMARY KEY (TopType)
);

INSERT INTO Top (TopType, Price)
Values ("Chocolate", 5);
INSERT INTO Top (TopType, Price)
Values ("Blueberry", 5);
INSERT INTO Top (TopType, Price)
Values ("Rasberry", 5);
INSERT INTO Top (TopType, Price)
Values ("Crispy", 6);
INSERT INTO Top (TopType, Price)
Values ("Strawberry", 6);
INSERT INTO Top (TopType, Price)
Values ("Rum/Raisin", 7);
INSERT INTO Top (TopType, Price)
Values ("Orange", 8);
INSERT INTO Top (TopType, Price)
Values ("Lemon", 8);
INSERT INTO Top (TopType, Price)
Values ("Blue Cheese", 9);

CREATE TABLE Bottom (
	BottomType varchar(15) NOT NULL,
    Price decimal(5,2) NOT NULL,
    PRIMARY KEY (BottomType)
);

INSERT INTO Bottom (BottomType, Price)
Values ("Chocolate", 5);
INSERT INTO Bottom (BottomType, Price)
Values ("Vanilla", 5);
INSERT INTO Bottom (BottomType, Price)
Values ("Nutmeg", 5);
INSERT INTO Bottom (BottomType, Price)
Values ("Pistacio", 6);
INSERT INTO Bottom (BottomType, Price)
Values ("Almond", 7);

CREATE TABLE OrderStatus (
	StatusId int,
    OrderStatus varchar(50),
    PRIMARY KEY (StatusId)
);

INSERT INTO OrderStatus (StatusId, OrderStatus)
VALUE (10,"New order");
INSERT INTO OrderStatus (StatusId, OrderStatus)
VALUE (15,"Order cancelled by User");
INSERT INTO OrderStatus (StatusId, OrderStatus)
VALUE (16,"Order cancelled by Administrator");
INSERT INTO OrderStatus (StatusId, OrderStatus)
VALUE (20,"Payment Recieved");
INSERT INTO OrderStatus (StatusId, OrderStatus)
VALUE (30,"Ready for pickup");
INSERT INTO OrderStatus (StatusId, OrderStatus)
VALUE (50,"Order completed");


CREATE TABLE Orders (
	OrderId int NOT NULL auto_increment,
    UserId int,
    StatusId int DEFAULT 10,
    OrderDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    OrderPrice decimal(6,2) NOT NULL, 
	PRIMARY KEY (OrderId),
    FOREIGN KEY (UserId) REFERENCES Users (UserId),
    FOREIGN KEY (StatusId) REFERENCES OrderStatus (StatusId)    
);
ALTER TABLE Orders auto_increment=2500;

INSERT INTO Orders (UserId,OrderPrice)
VALUES ((SELECT UserId FROM Users WHERE Email = "Alice@Cooper.com"),177);
INSERT INTO Orders (UserId,OrderPrice)
VALUES ((SELECT UserId FROM Users WHERE Email = "Frank@Zappa.com"),74);

UPDATE orders SET StatusId = '20' WHERE OrderId= 2500;

CREATE TABLE OrderContent (
	OrderId int,
    Top varchar(15),
    Bottom varchar(15),
    Quantity int,
    PRIMARY KEY (OrderId,Top,Bottom),
    FOREIGN KEY (OrderId) REFERENCES Orders (OrderId),
    FOREIGN KEY (Top) REFERENCES Top (TopType),
    FOREIGN KEY (Bottom) REFERENCES Bottom (BottomType)
);
INSERT INTO OrderContent (orderId,top,bottom,quantity)
VALUES (2500, "Orange", "Almond", 2);
INSERT INTO OrderContent (orderId,top,bottom,quantity)
VALUES (2500, "Blue Cheese", "Almond", 1);
INSERT INTO OrderContent (orderId,top,bottom,quantity)
VALUES (2500, "Chocolate", "Almond", 4);
INSERT INTO OrderContent (orderId,top,bottom,quantity)
VALUES (2501,"Blueberry", "Vanilla", 3);
INSERT INTO OrderContent (orderId,top,bottom,quantity)
VALUES (2501,"Strawberry", "Chocolate", 4),
	   (2501,"Strawberry", "Vanilla", 4);
