import mysql.connector
import mysql.connector.pooling
from flask import Flask, request
from flask_cors import CORS, cross_origin
app = Flask("flashcard-api")
cors = CORS(app)
app.config["CORS_HEADERS"] = 'Content-Type'

def executeandclose(sql, params = None) :
    cursor, db = getnewcursor()
    result = cursor.execute(sql, params, multi=True)
    storedResult = []
    for res in result:
        if (res.with_rows == True):
            storedResult = cursor.fetchall()
    cursor.close()
    db.close()
    return storedResult

def executeprocandclose(procName, params = None) :
    cursor, db = getnewcursor()
    cursor.callproc(procName, params)
    result = cursor.stored_results()
    storedResult = []
    for res in result:
        #if (res.with_rows == True):
        storedResult = res.fetchall()
        break
    cursor.close()
    db.close()
    return storedResult

@app.route('/search', methods = ['POST'])
@cross_origin()
def search_decks():
    data = request.json
    proc = "search"
    return {
        "results":executeprocandclose(proc, [
            data["keyword"]
        ])
    }

@app.route('/deck', methods = ['POST'])
@cross_origin()
def add_set():
    data = request.json