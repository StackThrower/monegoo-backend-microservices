package com.monegoo.notification.service;

import com.monegoo.notification.entity.NetworkHeader;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@Service
public class Network {

    public String get(String urlToRead, Optional<List<NetworkHeader>> headerList) {

        StringBuilder result = new StringBuilder();
        try {
            URL url  = new URL(urlToRead);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            headerList.ifPresent(networkHeaders ->
                    networkHeaders.forEach(header ->
                            conn.setRequestProperty(header.getName(), header.getValue())
                    )
            );

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {
                for (String line; (line = reader.readLine()) != null; ) {
                    result.append(line);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result.toString();
    }



    public String post(String urlToRead, Optional<List<NetworkHeader>> headerList, Optional<String> payload) {

        StringBuilder result = new StringBuilder();
        try {
            URL url  = new URL(urlToRead);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            headerList.ifPresent(networkHeaders ->
                    networkHeaders.forEach(header ->
                            conn.setRequestProperty(header.getName(), header.getValue())
                    )
            );

            if(payload.isPresent()) {
                OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
                writer.write(payload.get());
                writer.close();
            }



            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {
                for (String line; (line = reader.readLine()) != null; ) {
                    result.append(line);
                }
            }
            conn.disconnect();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result.toString();
    }


}
