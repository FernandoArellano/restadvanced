package client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import examples.model.Message;

public class RestApiClient {

    public static void main(String [] args){

        Client client = ClientBuilder.newClient();

        WebTarget baseTarget = client.target("http://localhost:8082/advancedrest_war/webapi/");
        WebTarget messagesTarget = baseTarget.path("messages");
        WebTarget singleMessageTarget = messagesTarget.path("{messageId}");

        Message message1 = singleMessageTarget
                .resolveTemplate("messageId","1")
                .request(MediaType.APPLICATION_JSON)
                .get(Message.class);


        System.out.println(message1.getMessage());

        Message newMessage = new Message(4, "My new message from client", "fer");

        Response postResponse = messagesTarget
                .request()
                .post(Entity.json(newMessage));

        System.out.println(postResponse);
        Message createdMessage = postResponse.readEntity(Message.class);
        System.out.println(createdMessage.getMessage());
    }
}
