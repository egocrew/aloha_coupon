package com.tickettaca.commons.firebase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import com.tickettaca.commons.firebase.dto.NotificationRequest;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FCMService {

  @Value("${google.fcm.api_url}")
  private String API_URL;

  @Value("${google.fcm.json}")
  private String firebaseConfigPath;

  private final ObjectMapper objectMapper;

  public void sendMessageTo(String pushToken, String title, String body) throws IOException {
    String message = makeMessage(pushToken, title, body);

    OkHttpClient client = new OkHttpClient();
    RequestBody requestBody =
        RequestBody.create(message, MediaType.get("application/json; charset=utf-8"));
    Request request =
        new Request.Builder()
            .url(API_URL)
            .post(requestBody)
            .addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + getAccessToken())
            .build();

    try {
      Response response = client.newCall(request).execute();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private String getAccessToken() throws IOException {
    GoogleCredentials googleCredentials =
        GoogleCredentials.fromStream(new ClassPathResource(firebaseConfigPath).getInputStream())
            .createScoped(List.of("https://www.googleapis.com/auth/cloud-platform"));
    googleCredentials.refreshIfExpired();
    return googleCredentials.getAccessToken().getTokenValue();
  }

  private String makeMessage(String pushToken, String title, String body) {

    NotificationRequest fcmMessage =
        NotificationRequest.builder()
            .message(
                NotificationRequest.Message.builder()
                    .token(pushToken)
                    .notification(
                        NotificationRequest.Notification.builder()
                            .title(title)
                            .body(body)
                            .image(null)
                            .build())
                    .apns(
                        NotificationRequest.Apns.builder()
                            .payload(
                                NotificationRequest.Payload.builder()
                                    .aps(NotificationRequest.Aps.builder().sound("default").build())
                                    .build())
                            .build())
                    .build())
            .validate_only(false)
            .build();
    

    String fcmMessageString = "";

    try {
      fcmMessageString = objectMapper.writeValueAsString(fcmMessage);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return fcmMessageString;
  }
}
