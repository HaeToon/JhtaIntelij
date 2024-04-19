import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordServer extends JFrame {
    private JTextArea textArea = new JTextArea();
    Word dictionary;

    public WordServer() throws HeadlessException {
        this.setTitle("WordServer");
        this.setSize(400, 500);

        Container c = this.getContentPane();
        c.add(new JScrollPane(textArea));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        dictionary = new Word("C:\\Users\\jhta\\Desktop\\Study\\wordList.txt");
        new ServerAcceptThread().start();
    }

    class ServerAcceptThread extends Thread {
        @Override
        public void run() {
            ServerSocket listener;
            Socket socket;
            try {
                listener = new ServerSocket(9999);
                while (true) {
                    socket = listener.accept();
                    textArea.append("클라이언트 접속됨 \n");
                    new WordCheckThread(socket).start();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class WordCheckThread extends Thread {
        private BufferedReader bufferedReader;
        private BufferedWriter bufferedWriter;
        private Socket socket;


        public WordCheckThread(Socket socket) {
            this.socket = socket;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String word = bufferedReader.readLine();
                    textArea.append(word + "\n");
                    if(dictionary.isExist(word)){

                    bufferedWriter.write("yes \n");
                    }else {

                    bufferedWriter.write("no \n");
                    }
                    bufferedWriter.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    class Word {
        private List<String> wordList = new ArrayList<>();
        private File file = new File("C:\\Users\\jhta\\Desktop\\Study\\wordList.txt");

        public Word(String filePath) {
            try {
                Scanner sc = new Scanner(new FileReader(filePath)); //한줄씩 읽어서 wordList에 집에넣기
                while (sc.hasNext()) {
                    wordList.add(sc.nextLine());

                }
                sc.close();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean isExist(String word) {
            return wordList.contains(word);
        }
    }

    public static void main(String[] args) {
        new WordServer();
    }
}
