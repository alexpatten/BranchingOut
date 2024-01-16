CREATE DATABASE BranchingOut;

REATE TABLE [User] (
    UserID INT IDENTITY(1,1) PRIMARY KEY,
    Username NVARCHAR(50),
    Password NVARCHAR(50),
    Email NVARCHAR(100)
);

-- Family Table
CREATE TABLE Family (
    FamilyID INT PRIMARY KEY,
    FamilyName VARCHAR(255) NOT NULL
);

-- FamilyMember Table
CREATE TABLE FamilyMember (
    MemberID INT PRIMARY KEY,
    FirstName VARCHAR(255) NOT NULL,
    LastName VARCHAR(255) NOT NULL,
    DateOfBirth DATE NOT NULL,
    Relationship VARCHAR(50) NOT NULL,
    Gender VARCHAR(10) NOT NULL,
    ProfilePicture VARCHAR(255),
    UserID INT,
    FamilyID INT,
    FOREIGN KEY (UserID) REFERENCES [User](UserID),
    FOREIGN KEY (FamilyID) REFERENCES Family(FamilyID)
);

-- ContactDetails Table
CREATE TABLE ContactDetails (
    ContactID INT PRIMARY KEY,
    PhoneNumber VARCHAR(20),
    Address VARCHAR(255),
    Email VARCHAR(255),
    SocialMedia VARCHAR(255),
    MemberID INT,
    FOREIGN KEY (MemberID) REFERENCES FamilyMember(MemberID)
);

-- Event Table
CREATE TABLE Event (
    EventID INT PRIMARY KEY,
    EventName VARCHAR(255) NOT NULL,
    Date DATE NOT NULL,
    Time TIME NOT NULL,
    Location VARCHAR(255),
    Description TEXT,
    FamilyID INT,
    FOREIGN KEY (FamilyID) REFERENCES Family(FamilyID)
);

-- Photo Table
CREATE TABLE Photo (
    PhotoID INT PRIMARY KEY,
    Image VARBINARY(MAX),
    Description TEXT,
    DateAdded DATE NOT NULL,
    MemberID INT,
    FOREIGN KEY (MemberID) REFERENCES FamilyMember(MemberID)
);