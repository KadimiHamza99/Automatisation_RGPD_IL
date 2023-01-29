import atexit
import json

from flask import Flask, jsonify
import requests
#from flask_eureka import Eureka
import py_eureka_client.eureka_client as eureka_client


app = Flask(__name__)

#eureka = Eureka(app)
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


#@atexit.register
"""
@app.teardown_appcontext
def deregister_with_eureka():
    #eureka_client.deregister()
    eureka_client.deregister()

"""

@atexit.register
def deregister_from_eureka_server():
    eureka_client.stop()


#atexit.register(deregister_from_eureka_server)

@app.route("/")
def hello_world():
    return "Hello world"


@app.route('/processing')
def get_processing(processingId):
    response = requests.get('http://localhost:8080/processing/:'+processingId)
    data = response.json()
    return jsonify(data)


@app.route('/processing/cat')
def get_processings(dscId):
    response = requests.get('http://localhost:8080/processing/:'+dscId)
    data = response.json()
    return jsonify(data)


@app.route('/dataSubject')
def get_dataSubject(dataSubjectId):
    response = requests.get('http://localhost:8080/express/dataSubject/getById/:'+dataSubjectId)
    data = response.json()
    return jsonify(data)


if __name__ == '__main__':
    app.run(debug=True, port=5000)