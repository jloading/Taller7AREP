package org.example;

import static spark.Spark.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Login {

    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) throws NoSuchAlgorithmException {

        addUser();
        port(getPort());
        staticFiles.location("/public");
        secure("keystores/ecikeystore.p12", "123456", null, null);
        get("/hello", (req, res) -> "Hello World");
        post("/login", (req, res) -> {
            String username = req.queryParams("username");
            String password = req.queryParams("password");

            if (users.containsKey(username) && users.get(username).equals(hashGenerator(password))) {
                System.out.println("Login Success");
                res.redirect("https://ec2-3-90-207-33.compute-1.amazonaws.com:5001/loggedInPage.html");
            }

            return "There was an error, try again";
        });

        get("/getLoggedInPage",  (req, res) -> {
            return SecureURLReader.readSecureURL("https://localhost:5001/hello");
        });
    }

    private static void addUser() throws NoSuchAlgorithmException {
        String user = "user";
        String password = "password";
        String passwordHash = hashGenerator(password);
        users.put(user, passwordHash);
    }

    public static String hashGenerator(String input) {
        byte[] encodedHash = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            encodedHash = messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        StringBuilder hexStr = new StringBuilder();
        for (byte b : encodedHash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1)
                hexStr.append('0');
            hexStr.append(hex);
        }

        return hexStr.toString();
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001;
    }
}
