import atexit
from flask import Flask, jsonify
import requests
import py_eureka_client.eureka_client as eureka_client
import contract


app = Flask(__name__)

# Eureka server configuration

EUREKA_APP_NAME = 'consent-service'
EUREKA_INSTANCE_ID = f'{EUREKA_APP_NAME}:{app.instance_path}'
rest_port = 5000

# Register the Flask application with the Eureka server
eureka_client.init(eureka_server="http://localhost:8760/eureka",
                   app_name="consent-service",
                   instance_id=EUREKA_INSTANCE_ID,
                   instance_port=rest_port)


# Deregister the app with Eureka server

@atexit.register
def deregister_from_eureka_server():
    eureka_client.stop()


@app.route("/")
def hello_world():
    return "Hello world"


@app.route('/consent/processing')
def get_processing(processingId):
    response = requests.get('http://localhost:8080/processing/:'+processingId)
    data = response.json()
    return jsonify(data)


@app.route('/consent/processing/cat')
def get_processings(dscId):
    response = requests.get('http://localhost:8080/processing/:'+dscId)
    data = response.json()
    return jsonify(data)

@app.route('/consent/contract')
def get_contractById(cId):
    ctr = contract.Contract()
    processing_ids = ctr.showAllProcessings(cId)
    result = list()
    for id in processing_ids:
        result.extend(get_processing(id))
    return result

@app.route('/consent/contract_by_dsId')
def get_contractByDataSubjectId(dsId):
    ctr = contract.Contract()
    contract_ids = ctr.findContractByDataSubjectId(dsId)
    result = list()
    for id in contract_ids:
        result.extend(get_contractById(id))
    return result


@app.route('/consent/dataSubject')
def get_dataSubject(dataSubjectId):
    response = requests.get('http://localhost:8080/express/dataSubject/getById/:'+dataSubjectId)
    data = response.json()
    return jsonify(data)


if __name__ == '__main__':
    app.run(debug=True, port=5000)