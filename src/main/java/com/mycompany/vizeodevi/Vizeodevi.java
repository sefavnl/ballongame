import java.util.Scanner;

public class BalloonGame {
    
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public static void balonPozisyonuBul(int m, int n) {
        if (n <= 0 || m <= 0) { // n ve m pozitif tam sayı olmalı
            System.out.println("Hatalı giriş! Lütfen pozitif tam sayılar giriniz.");
            return;
        }
        
        // Dairesel bağlı listeyi oluştur
        Node head = new Node(1);
        Node prev = head;
        for (int i = 2; i <= n; i++) {
            Node current = new Node(i);
            prev.next = current;
            prev = current;
        }
        prev.next = head;

        // Son kalan balonu bul
        Node current = head;
        Node previous = null;
        int count = n;
        while (count > 1) {
            // M-1 balonu patlat
            for (int i = 1; i < m; i++) {
                previous = current;
                current = current.next;
            }
            previous.next = current.next;
            current = previous.next;
            count--;
        }
        
        // Son kalan balonun pozisyonunu yazdır
        System.out.println("Son kalan balonun pozisyonu: " + current.data);
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Kaç balon olsun?: ");
        int n = input.nextInt();
        System.out.print("Hangi balonda patlatılsın?: ");
        int m = input.nextInt();
        balonPozisyonuBul(m, n);
        input.close();
    }
}
