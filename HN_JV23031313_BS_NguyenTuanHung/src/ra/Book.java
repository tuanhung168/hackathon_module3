package ra;

import java.util.Scanner;

public class Book {
    private static int nextBookId = 1;
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
        this.bookId = nextBookId++;
        this.bookStatus = true;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên sách: ");
        bookName = scanner.nextLine();

        System.out.print("Nhập tác giả: ");
        author = scanner.nextLine();

        System.out.print("Nhập mô tả về sách (ít nhất 10 ký tự): ");
        descriptions = scanner.nextLine();
        while (descriptions.length() < 10) {
            System.out.println("Mô tả phải có ít nhất 10 ký tự. Vui lòng nhập lại.");
            System.out.print("Nhập mô tả về sách: ");
            descriptions = scanner.nextLine();
        }

        System.out.print("Nhập giá nhập: ");
        importPrice = scanner.nextDouble();
        while (importPrice <= 0) {
            System.out.println("Giá nhập phải lớn hơn 0. Vui lòng nhập lại.");
            System.out.print("Nhập giá nhập: ");
            importPrice = scanner.nextDouble();
        }

        System.out.print("Nhập giá xuất (phải lớn hơn 1.2 lần giá nhập): ");
        exportPrice = scanner.nextDouble();
        while (exportPrice <= 1.2 * importPrice) {
            System.out.println("Giá xuất phải lớn hơn 1.2 lần giá nhập. Vui lòng nhập lại.");
            System.out.print("Nhập giá xuất: ");
            exportPrice = scanner.nextDouble();
        }

        interest = (float) (exportPrice - importPrice);
    }

    public void displayData() {
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Tác giả: " + author);
        System.out.println("Mô tả: " + descriptions);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Lợi nhuận: " + interest);
        System.out.println("Trạng thái: " + (bookStatus ? "Còn hàng" : "Hết hàng"));
        System.out.println("----------------------------------------");
    }
}
