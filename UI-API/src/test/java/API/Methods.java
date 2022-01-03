package API;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Methods {

    Service service;

    private JSONObject requestPayload;

    private JSONObject jsonObject;

    private JSONArray jsonArray;

    private List<String> listObject;

    private String fileName = "";

    public Methods() {
        this.service = new Service();
        requestPayload = new JSONObject();
        jsonObject = new JSONObject();
        jsonArray = new JSONArray();
        listObject = new ArrayList<>();
    }

    public void startWebService(String path, String filePath) {

        fileName = filePath;
        service.startWebServices(path);
    }

    public void setMethods(String requestType) {

        service.requestSpecBuilder(requestPayload.toString());

        switch (requestType) {

            case "GET":
                service.get();
                service.getResponse().prettyPrint();
                System.out.println("GET islemi Basarili");
                break;
            case "POST":
                service.post();
                service.getResponse().prettyPrint();
                System.out.println("POST islemi Basarili");
                break;
            case "PUT":
                service.put();
                service.getResponse().prettyPrint();
                System.out.println("PUT islemi Basarili");
                break;
            case "DELETE":
                service.delete();
                System.out.println("DELETE islemi Basarili");
                break;
        }
    }

    public void setPathParam(String key, Object value) {
        service.pathParam(key, value);
    }

    public void createJsonArray(String arrayParameter) {
        requestPayload.put(arrayParameter, jsonArray.put(jsonObject));
    }

    public void createListObject(String arrayParameter) {
        requestPayload.put(arrayParameter, listObject.toArray());
    }


    public void createJsonObject(String objectParameter) {
        requestPayload.put(objectParameter, jsonObject);
    }

    public void setParameter(String parameter, Object value) {
        requestPayload.put(parameter, value);
    }

    public void setListObject(String parameter) {
        listObject.add(parameter);
    }

    public void setJsonObjectParameter(String parameter, Object value) {
        jsonObject.put(parameter, value);
    }

    public void clearJsonObject() {
        while (jsonObject.length() > 0)
            jsonObject.remove(jsonObject.keys().next());
    }

    public Integer getStatusCode() {

        return service.getResponse().statusCode();
    }
}

