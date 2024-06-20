<%@ page import="com.google.gson.JsonArray, com.google.gson.JsonObject" %>
<%@ page import="java.util.ArrayList, java.util.List" %>
<%@ page import="api.TouristApiClient" %>

<%
    TouristApiClient apiClient = new TouristApiClient();
    JsonArray touristData = null;
    try {
        touristData = apiClient.fetchTouristData();
    } catch (Exception e) {
        e.printStackTrace();
    }

    List<String> touristNames = new ArrayList<>();
    List<String> touristDescriptions = new ArrayList<>();
    if (touristData != null) {
        for (int i = 0; i < touristData.size(); i++) {
            JsonObject touristObject = touristData.get(i).getAsJsonObject();
            touristNames.add(touristObject.get("name").getAsString());
            touristDescriptions.add(touristObject.get("description").getAsString());
        }
    }
%>

<html>
<head>
    <title>Tourist Attractions</title>
</head>
<body>
    <h1>Tourist Attractions</h1>
    <ul>
        <%
            for (int i = 0; i < touristNames.size(); i++) {
        %>
            <li>
                <h2><%= touristNames.get(i) %></h2>
                <p><%= touristDescriptions.get(i) %></p>
            </li>
        <%
            }
        %>
    </ul>
</body>
</html>
