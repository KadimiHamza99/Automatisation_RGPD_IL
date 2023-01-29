import mysql.connector

mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  password="root",
  database="consent_db"
)

mycursor = mydb.cursor()


class Consent:

    def findDataById(self, id):
        query = "SELECT * FROM consent WHERE contractId =" + str(id)
        mycursor.execute(query)
        row = mycursor.fetchall()
        return row

    def findAllData(self):
        query = "SELECT * FROM consent"
        mycursor.execute(query)
        records = mycursor.fetchall()
        return records

    def createData(self, data):
        query = "INSERT INTO consent (startDate, endDate, processingId, contractId) values (%s, %s, %s, %s)"
        val = (data.startDate, data.endDate, data.processingId, data.contractId)
        mycursor.execute(query, val)
        mydb.commit()


