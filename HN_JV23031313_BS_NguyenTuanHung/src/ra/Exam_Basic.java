package ra;

import ra.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exam_Basic {
    private static List<Book> bookList = new ArrayList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập thông tin sách");
            System.out.println("2. Hiển thị tất cả sách");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng");
            System.out.println("4. Xóa sách");
            System.out.println("5. Tìm kiếm sách theo tên hoặc mô tả");
            System.out.println("6. Chỉnh sửa thông tin sách");
            System.out.println("7. Thoát");
            System.out.print("Vui lòng chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBooks(scanner);
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    sortBooksByProfit();
                    break;
                case 4:
                    deleteBook(scanner);
                    break;
                case 5:
                    searchBooks(scanner);
                    break;
                case 6:
                    editBook(scanner);
                    break;
                case 7:
                    System.out.println("Thoát khỏi chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 7);
    }

    private static void addBooks(Scanner scanner) {
        System.out.print("Nhập số sách cần thêm: ");
        int numBooks = scanner.nextInt();
        scanner.nextLine();

        if (numBooks <= 0) {
            System.out.println("Số sách cần thêm phải lớn hơn 0.");
            return;
        }

        if (bookList.size() + numBooks > 100) {
            System.out.println("Danh sách sách đã đạt đến giới hạn tối đa.");
            return;
        }

        for (int i = 0; i < numBooks; i++) {
            System.out.println("Nhập thông tin sách thứ " + (i + 1) + ":");
            Book book = new Book();
            book.inputData(scanner);
            bookList.add(book);
        }

        System.out.println("Thêm sách thành công.");
    }

    private static void displayBooks() {
        if (bookList.isEmpty()) {
            System.out.println("Danh sách sách trống.");
        } else {
            System.out.println("Danh sách sách:");
            for (Book book : bookList) {
                book.displayData();
            }
        }
    }

    private static void sortBooksByProfit() {
        if (bookList.isEmpty()) {
            System.out.println("Danh sách sách trống.");
        } else {
            Collections.sort(bookList, (book1, book2) -> Float.compare(book1.getInterest(), book2.getInterest()));
            System.out.println("Danh sách sách sau khi sắp xếp theo lợi nhuận tăng:");
            for (Book book : bookList) {
                book.displayData();
            }
        }
    }

    private static void deleteBook(Scanner scanner) {
        System.out.print("Nhập mã sách cần xóa: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (Book book : bookList) {
            if (book.getBookId() == bookId) {
                bookList.remove(book);
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Xóa sách thành công.");
        } else {
            System.out.println("Không tìm thấy sách có mã " + bookId + ".");
        }
    }

    private static void searchBooks(Scanner scanner) {
        System.out.print("Nhập chuỗi tìm kiếm: ");
        String searchString = scanner.nextLine();

        boolean found = false;
        for (Book book : bookList) {
            if (book.getBookName().contains(searchString) || book.getDescriptions().contains(searchString)) {
                book.displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sách phù hợp với chuỗi tìm kiếm.");
        }
    }

    private static void editBook(Scanner scanner) {
        System.out.print("Nhập mã sách cần chỉnh sửa: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (Book book : bookList) {
            if (book.getBookId() == bookId) {
                System.out.println("Nhập thông tin mới cho sách:");
                book.inputData(scanner);
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Chỉnh sửa sách thành công.");
        } else {
            System.out.println("Không tìm thấy sách có mã " + bookId + ".");
        }
    }
}

