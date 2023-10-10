CREATE TABLE InterestGroup (
  GroupNumber INT PRIMARY KEY,
  Name VARCHAR(100) NOT NULL
);

CREATE TABLE Event (
  EventNumber INT PRIMARY KEY,
  Name VARCHAR(100) NOT NULL,
  Description TEXT,
  StartDateTime TIMESTAMP NOT NULL,
  Duration INT,
  GroupNumber INT,
  Notes TEXT,
  FOREIGN KEY (GroupNumber) REFERENCES InterestGroup(GroupNumber)
);

CREATE TABLE Member (
  MemberNumber INT PRIMARY KEY,
  LastName VARCHAR(50) NOT NULL,
  FirstName VARCHAR(50) NOT NULL,
  EmailAddress VARCHAR(100) NOT NULL,
  PhoneNumber VARCHAR(20),
  DateOfBirth DATE NOT NULL,
  ReceiveReminderEmails BOOLEAN NOT NULL,
  GroupNumber INT,
  EventNumber INT,
  FOREIGN KEY (GroupNumber) REFERENCES InterestGroup(GroupNumber),
  FOREIGN KEY (EventNumber) REFERENCES Event(EventNumber)
);

-- Sample data

-- Interest Groups
INSERT INTO InterestGroup (GroupNumber, Name)
VALUES
  (1, 'Sports'),
  (2, 'Music');

-- Events
INSERT INTO Event (EventNumber, Name, Description, StartDateTime, Duration, GroupNumber, Notes)
VALUES
  (1, 'SuperBowl', 'Watch the Superbowl Chargers Vs. Rams!', '2024-02-08 18:30:00', 180, 1, 'Bring your own booze!'),
  (2, 'Beyonce Concert', 'Welcome to the BeeHive.', '2023-07-10 20:00:00', 120, 2, 'Tickets are sold out.');

-- Members
INSERT INTO Member (MemberNumber, LastName, FirstName, EmailAddress, PhoneNumber, DateOfBirth, ReceiveReminderEmails)
VALUES
  (1, 'Khouts', 'Leo', 'leokhouts@gmail.com', '3024559555', '2020-02-03', true),
  (2, 'Khouts', 'Connor', 'connorkhouts@gmail.com', NULL, '2018-05-10', false),
  (3, 'Khouts', 'KJ', 'Kjameskhouts@gmail.com', '3025647777', '2018-08-15', true),
  (4, 'Khouts', 'Jerry', 'jkhoutsssss@gmail.com', '3025689999', '1993-07-26', false);
