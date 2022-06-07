import java.util.ArrayList;
import java.util.Scanner;

public class Perbankan {
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static String format(double x){
        return String.format("%,.2f", x);
    }
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        String[] nama = {"Susi","Budi"};
        String[] norek = {"0213456", "0314865"};
        double[] saldo = {500000,100000};
        ArrayList<Mutasi> mutasi = new ArrayList<Mutasi>();

        String yn = "y";

        while(yn.equalsIgnoreCase("y")){
            clearScreen();
            int x = 0;
            System.out.println("Selamat datang, "+ nama[x] +"!");
            System.out.println("---------------------------------");
            System.out.println("No. Rekening Anda adalah "+ norek[x] +".");
            System.out.println("Saldo Anda: Rp." + format(saldo[x]));
            System.out.println("---------------------------------");
            System.out.println("1. Transfer");
            System.out.println("2. Cek Mutasi");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda [1/2/3] ? ");
            int pilihan = keyboard.nextInt();

            if(pilihan==1){
                clearScreen();
                System.out.println("--------");
                System.out.println("TRANSFER");
                System.out.println("--------");
                System.out.print("Masukkan No. Rekening tujuan: ");
                String norekt = keyboard.next();
                if(norekt.equals(norek[1])){
                    System.out.print("Masukkan nominal transfer: ");
                    int nominal = keyboard.nextInt();
                    if(nominal<=saldo[x] & nominal!=0){
                        saldo[x]=saldo[x]-nominal;
                        mutasi.add(new Mutasi(norekt, nama[1], nominal));
                        System.out.println("\n<TRANSAKSI BERHASIL>");
                    }
                    else{
                        System.out.println("\n<TRANSAKSI GAGAL>");
                        System.out.println("Saldo tidak mencukupi...");  
                    }
                }
                else{
                    System.out.println("\n<TRANSAKSI GAGAL>");
                    System.out.println("No. Rekening tujuan belum terdaftar...");       
                }
            }
            else if(pilihan==2){
                clearScreen();
                System.out.println("----------");
                System.out.println("CEK MUTASI");
                System.out.println("----------");
                if(mutasi.size()==0){
                    System.out.println("Belum ada transaksi...");
                }
                else{
                    for (Mutasi m : mutasi) {
                        System.out.println("- Berhasil melakukan transfer sebesar Rp."+ format(m.nominal) +" ke "+ m.norek+" ("+m.nama+")");
                    }
                }
            }
            else if(pilihan==3){
                break;
            }
            else{
                System.out.println("Pilihan tidak tersedia...");
            }
            System.out.print("\nKembali ke halaman utama [y/n] ? ");
            yn = keyboard.next();
        }
        System.out.println("\n~ Terima Kasih ~\n");
        keyboard.close();
    }
}
