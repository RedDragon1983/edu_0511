//package com.dogwalk.game.training511.Chat.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        final ArrayList<User> users = new ArrayList<>();
        int numbUser = 0; // уникальный счётчик пользователей
        try {
            ServerSocket serverSocket = new ServerSocket(8188);
            //ServerSocket serverSocket = new ServerSocket(8189);
            while (true){
                final Socket socket = serverSocket.accept(); //Ожидаем клиента
                System.out.println("Клиент подключился");
                numbUser++;
                final int numbUser2 = numbUser; // номер пользователя
                Thread thread = new Thread(new Runnable() { // Создаёи поток для подключившегося клиента
                    @Override
                    public void run() {
                        try {
                            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                            DataInputStream in = new DataInputStream(socket.getInputStream());
                            out.writeUTF("Добро пожаловать на сервер! \nПредставьтесь пожалуйста. : "+numbUser2);
                            while (true){
                                System.out.println("Ожидаем сообщение от пользователей");
                                String request = in.readUTF(); // Ожидаем сообщение от клиента
                                String[] partRequest = request.split(" : "); // Делим сообщение на id и на имя/сообщение
                                String nameUser = null;
                                int idUser = Integer.parseInt(partRequest[0]);
                                for (User user:users) { // ищем пользователя с id. Если находим то сохраняем Имя
                                    if(user.getId() == idUser){
                                        nameUser = user.getName();
                                    }
                                }
                                if(nameUser == null){ // добавляем нового пользователя или рассылаем сообщение другим пользователям от имени найденного Имени
                                    users.add(new User(socket, idUser, partRequest[1]));
                                    System.out.println("Новый пользователь!\nid: "+idUser+"\n"+"Имя: "+partRequest[1]);
                                }else {
                                    for (User user:users) {
                                        if(user.getId() != idUser) { // отправляем сообщение только отличающимся по id пользователям и в консоль Server
                                            DataOutputStream userOut = new DataOutputStream(user.getSocket().getOutputStream());
                                            System.out.println(nameUser+" : "+partRequest[1]);
                                            userOut.writeUTF(nameUser+" : "+partRequest[1]);
                                        }
                                    }
                                }
                            }
                        } catch (IOException exception) {
                            exception.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

class User { // Класс объектов пользователей чата
    private final Socket socket;
    private String name;
    private final int id;
    public User(Socket socket, int id, String name) {
        this.socket = socket;
        this.id = id;
        this.name = name;
    }
    public Socket getSocket() {
        return socket;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
}
