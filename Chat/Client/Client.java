//package com.dogwalk.game.training511.Chat.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static int id = 0; // уникальный номер пользователя
    private static boolean sendName = false;
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8188);
            //Socket socket = new Socket("localhost",8189);
            System.out.println("Подключился");
            final DataInputStream  in =new DataInputStream(socket.getInputStream());
            DataOutputStream out=new DataOutputStream(socket.getOutputStream());
            String response = in.readUTF(); // Ждём сообщение от сервера
            String[] partResponse = response.split(" : ");
            id = Integer.parseInt(partResponse[1]);
            System.out.println("Ответ от сервера: "+partResponse[0]);
            Scanner scanner = new Scanner(System.in);
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        try {
                            String response = in.readUTF();
                            System.out.println(response);
                        } catch (IOException exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
            while(true){
                String request = scanner.nextLine(); // Читам пользовательский ввод
                out.writeUTF(id+" : "+request); // Отправляем на сервер id плюс текст с коносли
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
