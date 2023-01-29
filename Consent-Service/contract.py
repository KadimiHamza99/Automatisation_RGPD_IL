import mysql.connector


mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  password="root",
  database="consent_db"
)



mycursor = mydb.cursor()

class Contract:

    def findDataById(self, id):
        query = "SELECT * FROM contract WHERE contractId ="+str(id)
        mycursor.execute(query)
        row = mycursor.fetchall()
        return row

    def findAllData(self):
        query = "SELECT * FROM contract"
        mycursor.execute(query)
        records = mycursor.fetchall()
        return records

    def createData(self, data):
        query = "INSERT INTO contract (signatureDate, expirationDate, dataSubjectId) values (%s, %s, %s)"
        val = (data.signatureDate, data.expirationDate, data.dataSubjectId)
        mycursor.execute(query, val)
        mydb.commit()


