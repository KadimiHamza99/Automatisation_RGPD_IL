import mysql.connector



mydb = mysql.connector.connect(
    host="localhost",
    user="root",
    password="1949"
)

mycursor = mydb.cursor()

mycursor.execute("CREATE DATABASE IF NOT EXISTS consent_db")

mycursor.execute("SHOW DATABASES")

for x in mycursor:
    print(x)


mydb1 = mysql.connector.connect(
    host="localhost",
    user="root",
    password="1949",
    database="consent_db"
)

mycursor1 = mydb1.cursor()

mycursor1.execute("CREATE TABLE IF NOT EXISTS contract ("
                 "contractId INT AUTO_INCREMENT PRIMARY KEY, "
                 "signatureDate DATETIME,"
                 "expirationDate DATETIME, "
                 "dataSubjectId INT )")

mycursor1.execute("CREATE TABLE IF NOT EXISTS consent ("
                 "consentId INT AUTO_INCREMENT PRIMARY KEY, "
                 "startDate DATETIME, "
                 "endDate DATETIME, "
                 "processingId INT, "
                 "contractId INT, "
                 "FOREIGN KEY(contractId) REFERENCES contract(contractId) )")
