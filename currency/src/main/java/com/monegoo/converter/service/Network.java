package com.monegoo.converter.service;

import com.monegoo.converter.entity.NetworkHeader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

}
