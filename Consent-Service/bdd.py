import mysql.connector
from datetime import datetime
import json


"""mydb = mysql.connector.connect(
    host="localhost",
    user="root",
    password="1949"
)

mycursor = mydb.cursor()

mycursor.execute("CREATE DATABASE consent_db")

mycursor.execute("SHOW DATABASES")

for x in mycursor:
    print(x)"""


mydb1 = mysql.connector.connect(
    host="localhost",
    user="root",
    password="1949",
    database="consent_db"
)

mycursor = mydb1.cursor()

"""mycursor.execute("CREATE TABLE contract ("
                 "contractId INT AUTO_INCREMENT PRIMARY KEY, "
                 "signatureDate DATETIME,"
                 "expirationDate DATETIME, "
                 "dataSubjectId INT )")"""

mycursor.execute("CREATE TABLE consent ("
                 "consentId INT AUTO_INCREMENT PRIMARY KEY, "
                 "startDate DATETIME, "
                 "endDate DATETIME, "
                 "processingId INT, "
                 "contractId INT, "
                 "FOREIGN KEY(contractId) REFERENCES contract(contractId) )")
