import javax.swing.*;
import java.util.ArrayList;

public class App {

    ArrayList<Object> todoList = new ArrayList<>();

    public void start() {
        String str = "Lütfen seçim yapınız :";
        str+= "\n********************\n";
        str+= "\n [1] Listele";
        str+= "\n [2] Ekle";
        str+= "\n [3] Sil";
        str+= "\n [0] Çıkış";

        String secim = JOptionPane.showInputDialog(null, str);

        if (secim == null) {
            secim = "0";
        } else if (secim.equals(" ") || secim.matches("[^0-9+]")) {
            start();
        }
        switch (secim) {
            case "0":
                exit();
                break;
            case "1":
                list();
                start();
                break;
            case "2":
                add();
                start();
                break;
            case "3":
                delete();
                start();
                break;
            default:
                break;

        }

    }

    private void delete() {
        String title = JOptionPane.showInputDialog(null, "Silinecek Başlık");

        if (title != null && !title.trim().isEmpty()) {
            if (todoList.contains(title)) {
                todoList.remove(title);
                JOptionPane.showMessageDialog(null, "Kayıt Silindi!");
            } else {
                JOptionPane.showMessageDialog(null, "Sistemde kayıtlı olmayan bir veri girdiniz");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Geçerli bir başlık girilmedi.");
        }

    }





    private void add() {
        String title = JOptionPane.showInputDialog(null, "Başlık giriniz");

        if (title != null && !title.trim().isEmpty()) {
            if (todoList.contains(title)) {
                JOptionPane.showMessageDialog(null, "Sistemde kayıtlı bir veri girdiniz!");
            } else {
                todoList.add(title);
                JOptionPane.showMessageDialog(null, "Kayıt Eklendi");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Geçerli bir başlık girilmedi.");
        }

    }


    private void list() {
        String str = "ToDoList";
        str += "\n******************\n";
        for (int i = 0; i < todoList.size(); i++) {
            str += "[" + i + "] " + todoList.get(i) + "\n"; // Düzeltildi
        }
        str += " Toplam " + todoList.size() + " Kayıt Bulunmaktadır";
        message(str);
        
    }



    private void message(String str) {
        JOptionPane.showMessageDialog(null,str);

    }

    private void exit() {
        int confirm = JOptionPane.showConfirmDialog(null, "Çıkmak istediğinize emin misiniz ?");
        if (confirm == 0) {
            System.exit(0);
        } else {
            start();
        }
    }
}


